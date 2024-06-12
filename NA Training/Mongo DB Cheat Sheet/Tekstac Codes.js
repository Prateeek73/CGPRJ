Tekstac Codes

1) Add and employee to collection
db.employees.insertOne(
{
    "_id":"999345637892093",
    "Empno": 490,
    "FirstName": "Cristiano",
    "LastName": "Ronaldo",
    "DeptNo": null,
    "PhoneNo": 9865,
    "HireYear": 2010,
    "Job": "FieldRep",
    "EdLevel": 14,
    "Sex": "M",
    "BirthYear": 1990,
    "Salary": 25840,
    "Bonus": 100,
    "Commission": 1005
    }    
);
db.employees.find(
{
    "_id": "999345637892093"
}
);


2) Updating book documents
//set for updating specific field
//inc for increasing to count
db.books.updateMany(
{
    BookCategory: "Action and Adventure"
},
{   
    $set: {
        BookCopies: 2800
    },
    $inc: {
        BookPrice: 3000
    }
}    
)

3) Update many employees
db.employees.updateMany(
{
    DeptNo: ""
},
{ 
    $set: { 
        DeptNo: null
    }
}
)

4) Add training informations
//push add specified value to array field if it exists
//append multiple values to array in single update 
db.employees.updateMany(
{
    Job: "Manager"
},
{
    $push: {
        Training_to_attend: { 
            $each: ["Python", "DBMS"]
        }
    }
}
)

5) Changes made based on publisher
db.books.updateMany(
{
    BookPublisher: "Justin Paul"
},
{
    $inc: {
        BookPrice: 200,
    },
    $set: {
        BookCopies: 1000,
        BookLanguage: "Tamil"
    }
}
)

6) Remove fields
//unset for removing specific rows
db.books.updateMany(
{},
{
    $unset: {
        BookPrice: "",
        BookCopies: ""
    }
}
);

7) Delete an employee
db.employees.deleteOne(
{
    Salary: {
        $gt: 60000,
    },
    Sex: "M"
}
);

8) Delete an collection
db.employees.drop();

9) Count based on job
//or is a logical query operator that performs opeartion on array of expression
db.employees.find({
$or: [
    {
        Job: "Designer"
    },
    {
        Job: "Analyst"
    }
]
}).count()

10) Category bases on size 
//size of an array field matches the length
db.books.find(
{
    BookCategory: {
        $size: 2
    }
}
).count();

11) Embedded document
db.books.find({ 
    'reviews.rating': 5,
    'reviews.review_text': "Good"
},
{
    _id: 0,
    BookTitle: true,
    BookAuthor: 1
}
);

12) Employee details based on Hired Year
db.employees.find({
$and: [
    {
        HireYear: {
            $gte: 1988
        }
    },
    {
        HireYear: {
            $lte: 2005
        }
    }
]
});

13) Female Employee details
//$ne not equeals
db.employees.find({
$and: [
    {
        Sex: 'F'
    },
    {
        Salary: {
            $gte: 80000
        }
    },
    {
        Salary: {
            $lte: 150000
        }
    },
    {
        DeptNo: {
            $ne: 'E11'
        }
    }
]
})

14) Employee monthly salary
db.employees.find(
{
    Salary: {
        $gt: 50000
    }
}
)

15) Employee salary details
db.employees.find(
{
    $and: [
        {
            Sex: 'F'
        },
        {
            Salary: {
                $gte: 80000
            }
        },
        {
            Salary: {
                $lte: 150000
            }
        },
        {
            DeptNo: {
                $ne: 'E11'
            }
        }
    ]    
},
{
    _id: 0,
    LastName: 1,
    Salary: 1
}
)

16)Hindi and English books
//$eq is equals
db.books.find({
BookCopies: {
    $gte: 5000
},
$or: [
    {
        BookCategory: 'Crime'
    },
    {
        BookLanguage: {
            $in: ['English', 'Hindi']
        }
    }
]
}).count();


Aggregation
MGPSLU - Match Group Project Sort Limit Unwind

//match filters doucument on specfied criteria
db.collection.aggregate([
{ $match: { field: value } }
]);

//groups document by specfied key and applied aggregation expression on each group
db.collection.aggregate([
{ $group: { _id: "$key", total: { $sum: "$value" } } }
]);

//reshapes document
db.collection.aggregate([
{ $project: { newField: "$existingField", _id: 0 } }
]);

17) Education Levels
db.employees.distinct("Edlevel");

18) Analyst Details
db.employees.aggregate([
{
    $match: {
        Job: Analyst
    }
},
{
    $project: {
        _id: 0,
        FirstName: 1,
        LastName: 1,
        Salary: 1,
        Commission: 1
    }
}
])

19) Employee Details
db.employees.aggregate([
{
    $project: {
        _id: 0,
        Empno: 1,
        FirstName: 1,
        LastName: 1,
        PhoneNo: 1,
        Job: 1,
        EdLevel: 1,
        Sex: 1,
    }
},
{
    $sort: {
        Empno: 1
    }
},
{
    $skip: 10
}
])

20) Employee Information
db.employees.aggregate([
{
    $project: {
        _id: 0,
        Empno: 1,
        FirstName: 1,
    }
},
{
    $sort: {
        Empno: -1
    }
},
{
    $limit: 4
}
])

21) Total Salary
db.employees.aggregate([
    {
        $group: {
            _id: "$DeptNo",
            total_salary: {
                $sum: "$salary"
            }
        }
    },
    {
        $sort: {
            total_salary: -1
        }
    }
])

22)Clerk and Sales Rep Salary Details
db.employees.aggregate([
    {
        $match: {
            Job: { $in: ["Clerk", "SalesRep"] }
        }
    },
    {
        $group: {
            _id: "$DeptNo",
            salary_total: { $sum: "$Salary" }
        }
    },
    {
        $sort: {
            salary_total: 1
        }
    }
]);

23) Books Based on Publications
db.books.aggregate([
{
    $match: {
        PublishDate: { $gte: ISODate("1950-01-01T00:00:00Z") }
    }
},
{
    $project: {
        _id: 0,
        BookTitle: 1,
        month: { $month: "$PublishDate" },
        year: { $year: "$PublishDate" }
    }
},
{
    $sort: {
        year: 1
    }
}
]);


24) Book Details based on Condition
db.books.aggregate([
    {
        $match: {
            BookCategory: "Classics"
        },
        $project: {
            _id: 0,
            BookTitle: 1,
            BookAuthor: 1,
            PriceList: {
                $cond: {
                    if: {
                        $gt: ["$BookPrice", 10000]
                    }, 
                    then: "High Cost",
                    else: {
                        $cond: {
                            if: { 
                                $gte: ["$BookPrice", 5000]
                            }, 
                            then: "Medium Cost",
                            else: "Least Cost" 
                        }
                    }
                }
            }
        }
    }
])

25) Email Count
db.employees.find(
{
    $regex: /@gmail.com/i
}
).count();

26) Price Reduction
db.books.aggregate([
{
    $project: {
        _id: 0,
        BookTitle: 1,
        BookPrice: 1,
        ReducedPrice: {
            $subtract: ["$BookPrice", { $multiply: ["$BookPrice", 0.1]} ]
        }
    }
}
])

27) User defined index
db.books.aggregate([
{
    $unwind: {
        path: "$BookCategory",
        includeArrayIndex: "BookIndex"
    }
}
])

28) Overall Price
db.books.aggregate([
    {
        $unwind: {
            path: "$BookCategory",
            preserveNullAndEmptyArrays: true
        },
    },
    {
        $group: {
            _id: "$BookCategory",
            TotalPrice: {
                $sum: "$BookPrice"
            }
        }
    },
    {
        $sort: {
            TotalPrice: -1
        }
    }
])

29) Salary Update
db.books.aggregate([
{
    $match: {
        Job: "Operator",
        EdLevel: {
            $lt: 15
        }
    },
    $project: {
        _id: 0,
        FirstName: 1,
        HireYear: 1,
        EdLevel: 1,
        UpdatedSalary: {
            $add: ["$Salary", {$multiply: ["$Salary", 0.2]}]
        }
    }
}
])

30) Titles with Authors
db.books.aggregate([
{
    $match: {
        BookPublisher: "James Patrik",
        BookPrice: {
            $gt: 2000
        }
    }
},
{
    $project: {
        _id: 0,
        BookInfo: {
            $concat: ["$BookTitle", "is written by", "$BookAuthor"]
        },
        Published_Year: {
            $year: "$PublishDate"
        }
    }
}
])

31) Password Generation
db.employees.aggregate([
{
    $match: {
        HireYear: 2000,
        DeptNo: { $ne: null, $ne: "" } 
    }
},
{
    $project: {
        _id: 0,
        FirstName: 1,
        Password: {
            $concat: [
            { $substr: ["$FirstName", 0, 3] },
            { $substr: ["$DeptNo", 0, 2] }
            ]
        }
    }
},
{
    $sort: {
        FirstName: -1
    }
}
]);

32) Publication Year
db.books.aggregate([
    {
        $group: {
            _id: {
                year: {
                    $year: "$PublishDate"
                }
            },
            PublishedBooks: {
                $addToSet: "$BookTitle"
            }
        }
    }
])

33) Employee Info
db.employees.aggregate([
    {
        $match: {
            BirthYear: {
                $gt: 1980
            },
            DeptNo: {
                $ne: ""
            }
        }
    }
    {
        $project: {
            FirstName: 1,
            LastName: 1,
            Job: 1
        }
    }
])

34) Author Signature
db.books.aggregate([
    {
        $match: {
            BookCategory: "Action",
            BookPrice: {
                $gt: 3000
            }
        },
    },
    {
        $addFields: {
            AuthorSignature: "Available"
        }
    }
])

35) Author Info
db.books.aggregate([
    {
        BookLanguage: "English",
        BookPrice: {
            $lt: 3000
        }
    },
    {
        $lookup: {
            from: "Author",
            localField: "BookAuthor",
            foreignField: "Authorno",
            as: "Author_info"
        }
    },
    {
        $project: {
            _id: 0,
            BookTitle: 1,
            BookPublisher: 1,
            "Author_info.FirstName": 1,
            "Author_info.PhoneNo": 1,
            "Author_info.BirthYear": 1,
        }
    },
    {
        $sort: {
            "Author_info.FirstName": 1
        }
    }

])


36) Publisher-Specfic Book Counts 
db.books.aggregate([
    {
        $match: {
            BookLanguage: "English",
            BookCategory: "Action"
        }
    },
    {       
        $sortByCount: "$BookPublisher"
    }
])

37) Create a Unique index
db.employees.createIndex({
    Empno: 1
})

38) Create a componsite index
db.employees.createIndex({
    LastName: 1,
    Salary: 1
})

39) Indexing
db.employees.createIndex({
    DeptNo: 1
})
db.employees.dropIndex({
    DeptNo: 1
})

40) Display all indexes
db.employees.getIndexes();  

Mock Test 
db.patient.aggregate([
    {
        $match: {
            PayAmount:{
                $gte: 1000, $1te:2000
            }
        }
    },
    {
        $project: {
            _id:1,
            PaymentMode:1,
            PatientId: 1,
            FirstName:1,
            City:1
        }
    },
    {
        $out: "payment_copy"
    }
]);
db.payment_copy.find().pretty();
db.payment_copy.aggregate([
    {
        $group: { 
            _id:{
                Transaction: "$PaymentMode"
            }, 
            patient:{
                $addToSet: "$FirstName"
            }
        }
    }
])

db.doctor.aggregate([
    {
        $match: {
            $or: [
                {
                    $and: [
                        {
                            Gender: "Male"
                        },
                        {
                            Specialization: "Family Medicine Specialist"
                        }
                    ]
                },
                {
                    $and: [
                        {
                            Gender: "Female"
                        },
                        {
                            Specialization: "ENT Specialist"
                        }
                    ]
                }
            ]
        }
    },
    {
        $project: {
            _id:0,
            DocFirstName: 1,
            DocLastName:1,
            Email:{
                $ifNull: [ "$Email", "Not Available"]
            },
            Month: {
                $month: "$PracticingFrom"
            },
            Year: {
                $year: "SPracticingFrom"
            }
        }
    }
]).pretty()