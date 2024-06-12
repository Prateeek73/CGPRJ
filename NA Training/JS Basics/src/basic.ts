// Open source language 
// builds on JS

// Offers additional features like static types
// Using types is optional
// Compiles down to regular JS
// Can be used for frontend as well as backend with Node.js
// Includes most features of ES6, Classes fat arraow 
// Types from 3rd party libraries can be added with type definations


// Included by default with Angular 2+


// Pros
// -> More readable
// -> Easy to spot bugs

// Cons
// -> More code to write
// -> More to learn
// -> Requires Compilation
// -> Not truely statically typed

// #TSC or TypeScriptCompiler to compier .ts files to JS
// #U can crearte tsconfig.json to configure how typescript works


// Types
// does type inference where it infers types of variables


// Basic Types
let id: number = 5;
let company: string = 'Hello World';
let isPublished: boolean = true;
let x: any = 'Hello';
x = false;

//Arrays
let ids: number[] = [1, 2, 3, 4, 5]
let arr: any[] = [1, true, 'Hello']

//Tuples
// Tuple -> Similar to python tuple, u can specify types here
let person: [number, string, boolean] = [1, 'Brad', true]
// Tuple Array
let employees: [number, string][]
employees = [
  [1, 'Prateek'],
  [2, 'Pratap'],
  [3, 'Singh'],
]

// Union -> variable holding more that one type
// Uses pipe character to segregate | 
let pid: string | number
pid = '22'
pid = 22

// Enum types-> names constants
// default values 0
enum Direction {
  Up = 1,
  Down,
  Left,
  Right,
}

// Objects literals
const user2: {id: number, name: string} = { id: 1, name: 'John'}

type User = {
  id: number
  name: string
}

const user: User = {
  id: 1,
  name: 'John',
}


// Type Assertion -> Treat an entity as different type
let cid: any = 1
let customerId1 = <string>cid //-> angled brackets
let customerId2 = cid as string //-> ussing ass keyword


// Functions
// default has any type as return type
function addNum(x: number, y: number): number {
  return x + y
}
// Void
function log(message: string | number): void {
  console.log(message)
}


// Interfaces -> 
// custom type or specific structure to an object or an function
// use interface over tyoe
// type can be used with primitives and unions
// interface can't be, that's why its prefered

interface UserInterface {
  readonly id: number //readonly property
  name: string
  age?: number // optional
}

const user1: UserInterface = {
  id: 1,
  name: 'John'
}

// interfaces with function
interface MathFunc {
  (x: number, y: number): number
}
const add: MathFunc = (x: number, y: number): number => x + y
const sub: MathFunc = (x: number, y: number): number => x - y


// Classes
interface PersonInterface {
  id: number
  name: string
  register(): string
}

class Person implements PersonInterface {
  id: number
  name: string

  constructor(id: number, name: string) {
    this.id = id
    this.name = name
  }

  register() {
    return `${this.name} is now registered`
  }
}

const tail = new Person(1, 'Tail Brandon')
const mike = new Person(2, 'Mike Tyson')

// Subclasses
class Employee extends Person {
  position: string

  constructor(id: number, name: string, position: string) {
    super(id, name)
    this.position = position
  }
}

const emp = new Employee(3, 'Shawn', 'Developer')

// Generics
function getArrayAny<T>(items: any[]): any[] {
  return new Array().concat(items)
}

function getArray<T>(items: T[]): T[] {
  return new Array().concat(items)
}

let numArray = getArrayAny<number>([1, 2, 3, 4])
let strArray = getArray<string>(['prateek', 'pratap', 'singh'])