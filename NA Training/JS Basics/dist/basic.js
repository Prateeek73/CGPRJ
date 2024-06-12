"use strict";
let id = 5;
let company = 'Hello World';
let isPublished = true;
let x = 'Hello';
x = false;
let ids = [1, 2, 3, 4, 5];
let arr = [1, true, 'Hello'];
let person = [1, 'Brad', true];
let employees;
employees = [
    [1, 'Prateek'],
    [2, 'Pratap'],
    [3, 'Singh'],
];
let pid;
pid = '22';
pid = 22;
var Direction;
(function (Direction) {
    Direction[Direction["Up"] = 1] = "Up";
    Direction[Direction["Down"] = 2] = "Down";
    Direction[Direction["Left"] = 3] = "Left";
    Direction[Direction["Right"] = 4] = "Right";
})(Direction || (Direction = {}));
const user2 = { id: 1, name: 'John' };
const user = {
    id: 1,
    name: 'John',
};
let cid = 1;
let customerId1 = cid;
let customerId2 = cid;
function addNum(x, y) {
    return x + y;
}
function log(message) {
    console.log(message);
}
const user1 = {
    id: 1,
    name: 'John'
};
const add = (x, y) => x + y;
const sub = (x, y) => x - y;
class Person {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
    register() {
        return `${this.name} is now registered`;
    }
}
const tail = new Person(1, 'Tail Brandon');
const mike = new Person(2, 'Mike Tyson');
class Employee extends Person {
    constructor(id, name, position) {
        super(id, name);
        this.position = position;
    }
}
const emp = new Employee(3, 'Shawn', 'Developer');
function getArrayAny(items) {
    return new Array().concat(items);
}
function getArray(items) {
    return new Array().concat(items);
}
let numArray = getArrayAny([1, 2, 3, 4]);
let strArray = getArray(['prateek', 'pratap', 'singh']);
