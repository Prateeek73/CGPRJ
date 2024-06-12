//Window object of browser
console.log(window);


// LOGGING OUTPUT
console.log('Hello World');
console.error('This is an error');
console.warn('This is a warning');


// DIALOG BOXES:
// Alert -> warning message to the user
// Prompt -> user to verify or accept something
// Confirm -> user to input a value before entering a page
// window.alert("Warning danger you have not filled everything")
// window.confirm("Do you want to continue ?")
// window.prompt("Enter your name : ", "Please enter your name");


// VARIABLES
// - var, let, const
let a = 30;
// let can be re-assigned, const can not
a = 31;

// DATA TYPES
// - String, Number, Boolean, null, undefined
console.warn('DATA TYPES');
const name = 'Brad';
const age = 37;
const rating = 3.5;
const isCool = true;
const x = null;
const y = undefined;
let z; // undefined
// Check type
console.log(`Name ${name}:`, typeof name);
console.log(`Age ${age}:`,typeof age);
console.log(`Rating ${rating}:`,typeof rating);
console.log(`isCool ${isCool}:`,typeof isCool);
console.log(`x ${x}:`,typeof x);
console.log(`y ${y}:`,typeof y);
console.log(`z ${z}:`,typeof z);


// STRINGS
// Template literal (better)
console.warn('STRINGS');
console.log(`My name is ${name} and I am ${age}`);
// String methods & properties
const s = 'Hello World';
let val;
// Get length
console.log(s.length)
// Change case
console.log(s.toUpperCase())
console.log(s.toLowerCase())
// Get sub string
console.log(s.substring(0, 5))
// Split into array
console.log(s.split(''))


// ARRAYS
// - Store multiple values in a variable
// 0-indexed
// dynamic
console.warn('ARRAYS');
const numbers = [1, 2, 3, 4, 5, "six"];
const fruits = ["apples", "oranges", "pears", "grapes"];
console.log(typeof numbers, numbers);
console.log(typeof fruits, fruits);
// Get one value - Arrays start at 0
console.log("Fruit at index 1: ", fruits[1]);
// Add value
fruits[4] = "blueberries";
console.log("Fruits after appending: ", fruits);
// Add value using push()
fruits.push("strawberries");
console.log("Fruits after pushing: ", fruits);
// Add to beginning
fruits.unshift("mangos");
console.log("Fruits after unshifting: ", fruits);
// Remove last value
fruits.pop();
console.log("Fruits after popping: ", fruits);
// Check if array
console.log("Cheking fruits to be an array: ", Array.isArray(fruits));
// Get index
console.log("Fruits:", fruits, " has index of oranges at:", fruits.indexOf("oranges"));


// OBJECT LITERALS
console.warn('OBJECT LITERALS');
const person = {
  firstName: 'John',
  age: 30,
  hobbies: ['music', 'movies', 'sports'],
  address: {
    street: '50 Main st',
    city: 'Boston',
    state: 'MA'
  }
}
// Get single value
console.log("person.getName: ", person.firstName)
// Get array value
console.log("person.hobbies[1]: ", person.hobbies[1]);
// Get embedded object
console.log("person.address.city: ", person.address.city);
// Add property
person.email = 'jdoe@gmail.com';
console.log("person: ", person)
// Destructuring
const {firstName, address: {city}} = person;
console.log("person.address.city: ", city)


//LOOPS
console.warn('LOOPS');
const todo = {
  id: 1,
  text: "Take out trash",
  isComplete: false
}
const todos = [
todo,
{
  id: 2,
  text: "Dinner with wife",
  isComplete: false,
},
{
  id: 3,
  text: "Meeting with boss",
  isComplete: true,
},
];

// For Loop
console.log("Todos by for")
for (let i = 0; i < todos.length; i++) {
console.log(`Todo ${i + 1}: ${todos[i].text}`);
}
// For...of Loop
console.log("Todos by for..of")
for (let todo of todos) {
console.log(todo.text);
}

// HIGH ORDER ARRAY METHODS (show prototype)
console.warn("HIGH ORDER ARRAY METHODS")
// forEach() - Loops through array
console.log("Todo by forEach")
todos.forEach((todo, i) =>console.log(`${i + 1}: ${todo.text}`));
// map() - Loop through and create new array
console.log("Todo by map: ", todos.map(todo => todo.text));
// filter() - Returns array based on condition
console.log("Todo by filter:", todos.filter( todo => todo.id === 1));


// JSON FORMAT
console.warn("JSON FORMAT")
console.log(JSON.stringify(todos));


// CONDITIONALS
console.warn("CONDITIONALS")
// Simple If/Else Statement
const n = 30;
if(n === 10) {
  console.log(`${n} is 10`);
} else if(n > 10) {
  console.log(`${n} is greater than 10`);
} else {
  console.log(`${n} is less than 10`)
}
// Switch
color = 'blue';
switch(color) {
  case 'red':
    console.log(`Color is ${color}`);
  case 'blue':
    console.log(`Color is ${color}`);
  default:  
    console.log('Color is not red or blue')
}
// Ternary operator / Shorthand if
console.log("Ternary: ", color === 'red' ? 10 : 20)



// FUNCTIONS
console.warn("FUNCTIONS");
function greet(greeting , name ='There') {
  return `${greeting}, ${name}`;
}
// ARROW FUNCTIONS
const greetAF = (greeting , name ='There') => `${greeting}, ${name}`;
console.log(greet('Hi', 'Magot'));
console.log(greetAF('Hello'));

// OOP
console.warn("OOPS")
// Constructor Function
function Person(firstName, lastName, dob) {
  // Set object properties
  this.firstName = firstName;
  this.lastName = lastName;
  this.dob = new Date(dob); // Set to actual date object using Date constructor
  // this.getBirthYear = function(){
  //   return this.dob.getFullYear();
  // }
  // this.getFullName = function() {
  //   return `${this.firstName} ${this.lastName}`
  // }
}
//Prototyping
// Get Birth Year
Person.prototype.getBirthYear = function () {
  return this.dob.getFullYear();
}

// Get Full Name
Person.prototype.getFullName = function() {
  return `${this.firstName} ${this.lastName}`
}
// Instantiate an object from the class
const personObj = new Person('John', 'Doe', '7-8-80');
console.log("Constructor function object: ", personObj);
console.log("Person.getBirthYear(): ",  personObj.getBirthYear());
console.log("Person.getFullName(): ",personObj.getFullName());
// Built in constructors objects
const namma = new String('Kevin');
console.log(`Namma = ${namma}: `, typeof namma); // Shows 'Object'
const num = new Number(5);
console.log(`Num = ${num}: `,typeof num); // Shows 'Object'

// ES6 CLASSES
class PersonObj {
  constructor(firstName, lastName, dob) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = new Date(dob);
  }

  // Get Birth Year
  getBirthYear() {
    return this.dob.getFullYear();
  }

  // Get Full Name
  getFullName() {
    return `${this.firstName} ${this.lastName}`
  }
}

const personObject = new PersonObj('John', 'Doe', '7-8-80');
console.log("ES6 class object: ", personObject);
console.log("Person.getBirthYear(): ",  personObject.getBirthYear());
console.log("Person.getFullName(): ",personObject.getFullName());


//EVENTS
// onchange	-> An HTML element has been changed
// onclick	-> The user clicks an HTML element
// onmouseover	-> The user moves the mouse over an HTML element
// onmouseout -> The user moves the mouse away from an HTML element
// onkeydown -> The user pushes a keyboard key
// onload -> The browser has finished loading the page
console.warn("EVENTS")
const btn = document.querySelector(".btn");

btn.addEventListener("click", (e) => {
  console.log("Clicked");
});

btn.addEventListener("mouseover", (e) => {
  e.preventDefault();
  console.log("Mouse moved over");
});

btn.addEventListener("mouseout", (e) => {
  e.preventDefault();
  console.log("Mouse moved out");
});


// // // ELEMENT SELECTORS

// // Single Element Selectors
// console.log(document.getElementById('my-form'));
// console.log(document.querySelector('.container'));
// // Multiple Element Selectors
// console.log(document.querySelectorAll('.item'));
// console.log(document.getElementsByTagName('li'));
// console.log(document.getElementsByClassName('item'));

// const items = document.querySelectorAll('.item');
// items.forEach((item) => console.log(item));


// // MANIPULATING THE DOM
// const ul = document.querySelector('.items');
// // ul.remove();
// // ul.lastElementChild.remove();
// ul.firstElementChild.textContent = 'Hello';
// ul.children[1].innerText = 'Brad';
// ul.lastElementChild.innerHTML = '<h1>Hello</h1>';

// const btn = document.querySelector('.btn');
// btn.style.background = 'red';


// // EVENTS

// // Mouse Event
// btn.addEventListener('click', e => {
//   e.preventDefault();
//   console.log(e.target.className);
//   document.getElementById('my-form').style.background = '#ccc';
//   document.querySelector('body').classList.add('bg-dark');
//   ul.lastElementChild.innerHTML = '<h1>Changed</h1>';
// });

// // Keyboard Event
// const nameInput = document.querySelector('#name');
// nameInput.addEventListener('input', e => {
//   document.querySelector('.container').append(nameInput.value);
// });


// // // USER FORM SCRIPT

// // Put DOM elements into variables
// const myForm = document.querySelector('#my-form');
// // const nameInput = document.querySelector('#name');
// const emailInput = document.querySelector('#email');
// const msg = document.querySelector('.msg');
// const userList = document.querySelector('#users');

// // Listen for form submit
// myForm.addEventListener('submit', onSubmit);

// function onSubmit(e) {
//   e.preventDefault();
  
//   if(nameInput.value === '' || emailInput.value === '') {
//     // alert('Please enter all fields');
//     msg.classList.add('error');
//     msg.innerHTML = 'Please enter all fields';

//     // Remove error after 3 seconds
//     setTimeout(() => msg.remove(), 3000);
//   } else {
//     // Create new list item with user
//     const li = document.createElement('li');

//     // Add text node with input values
//     li.appendChild(document.createTextNode(`${nameInput.value}: ${emailInput.value}`));

//     // Add HTML
//     // li.innerHTML = `<strong>${nameInput.value}</strong>e: ${emailInput.value}`;

//     // Append to ul
//     userList.appendChild(li);

//     // Clear fields
//     nameInput.value = '';
//     emailInput.value = '';
//   }
// }