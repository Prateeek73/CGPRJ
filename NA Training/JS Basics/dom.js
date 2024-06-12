// EXAMINE THE DOCUMENT OBJECT
console.dir(document);

// .............
// DOM PROPERTIES
// ............
console.warn("DOM PROPERTIES");

console.log("Domain:", document.domain);
console.log("URL:", document.URL);
console.log("Title:", document.title);
console.log("Doctype:", document.doctype);
console.log("Head:", document.head);
console.log("Body:", document.body);
//gives HTML collection of all elements
console.log("All:", document.all);
console.log("All[10]:", document.all[10]);
console.log("Forms:", document.forms[0]);
//gives HTML collection of all link
console.log("Links:", document.links);
//gives HTML collection of all images
console.log("Images:", document.images);


// .............. 
// DOM SELECTORS
// .............
console.warn("DOM SELECTORS");

//Single element selectors
var headerTitle = document.getElementById("header-title");
console.log("Header title by getElementById: ", headerTitle);
//fetches first element
var header = document.querySelector("main-header");
console.log("Header by querySelector:", header);

// Multiple element selector -> returns HTML Collection 

// getElementsByClassName
var items = document.getElementsByClassName("list-group-item");
console.log("Items by getElementsByClassName:", items);
console.log("First Item by getElementsByClassName:", items[1]);

//getElementsByTagName
var li = document.getElementsByTagName("li");
console.log("List by getElementsByTagName:", li);
console.log("First li by getElementsByClassName:", li[1]);

//querySelectorAll
var odd = document.querySelectorAll("li:nth-child(odd)");
console.log("Odds by querySelectorAll:", odd);
console.log("First odd by querySelectorAll:", odd[1]);



// ...................
// TRAVERSING THE DOM
// ..................
console.warn("TRAVERSING THE DOM");

var itemList = document.querySelector('#items');
// parentNode
console.log("ItemList Parent Node:", itemList.parentNode);
// parentElement
console.log("ItemList Parent Element:",itemList.parentElement);
// childNodes
console.log("ItemList Child Nodes:",itemList.childNodes);
console.log("ItemList Children:",itemList.children);
console.log("Second children of ItemList:",itemList.children[1]);
// FirstChild
console.log("First child of ItemList:", itemList.firstChild);
// firstElementChild
console.log("First element child of ItemList:",itemList.firstElementChild);
// lastChild
console.log("Last child of ItemList:",itemList.lastChild);
// lastElementChild
console.log("Last element child of ItemList:",itemList.lastElementChild);
// nextSibling
console.log("Next Sibling of ItemList:",itemList.nextSibling);
// nextElementSibling
console.log("Next Element Sibling of ItemList:",itemList.nextElementSibling);
// previousSibling
console.log("Previous sibling of ItemList:",itemList.previousSibling);
// previousElementSibling
console.log("Next Element Sibling of ItemList:", itemList.previousElementSibling);


// .................
// Manipulating DOM
// ................
console.warn("Manipulating DOM");

headerTitle.textContent = "Hello";
headerTitle.innerText = "Goodbye";
headerTitle.innerHTML = "<h3>Hello</h3>";
headerTitle.style.borderBottom = "solid 3px #000";
// Gives error
//items.style.backgroundColor = '#f4f4f4';
for (var i = 0; i < items.length; i++) {
  items[i].style.backgroundColor = "pink";
}
li[0].textContent = "Item 1 modified";
li[0].style.fontWeight = "bold";
li[0].style.backgroundColor = "yellow";
//Why to use querySelector -> ability to use all css selectors combinations
var input = document.querySelector("input");
var submit = document.querySelector('input[type="submit"]');
var item = document.querySelector(".list-group-item");
var lastItem = document.querySelector(".list-group-item:last-child");
var secondItem = document.querySelector(".list-group-item:nth-child(2)");
var odd = document.querySelectorAll("li:nth-child(odd)");
var even = document.querySelectorAll("li:nth-child(even)");

input.value = "Enter content modified";
submit.value = "SEND";
item.style.color = "violet";
lastItem.style.color = "green";
secondItem.style.color = "yellow";
for (var i = 0; i < odd.length; i++) {
  odd[i].style.backgroundColor = "pink";
  even[i].style.backgroundColor = "orange";
}


// .....................
// Creating DOM elements
// .....................
console.warn("CREATING DOM")
// Create a element
var newDiv =  document.createElement('div');
console.log(newDiv);
 // Add class
newDiv.className= 'hello';
console.log(newDiv);
// Add id
newDiv.id = 'hello1';
console.log(newDiv);
// Add attr
newDiv.setAttribute('title', 'Hello Div');
console.log(newDiv);
// Create text node and append
var newDivText = document.createTextNode('Hello World');
newDiv.appendChild(newDivText);
console.log(newDiv);
// add styles
newDiv.style.fontSize = '30px';
console.log(newDiv);

// insert the element
var container = document.querySelector('header .container');
var h1 = document.querySelector('header h1');
container.insertBefore(newDiv, h1);

//........../
// EVENTS //
// ......./

console.warn("EVENT ACTIONS")
// mouse actions
var button = document.getElementById('button')
button.addEventListener('click', buttonClick);
button.addEventListener('dblclick', buttonClick);
button.addEventListener('mousedown', buttonClick);
button.addEventListener('mouseup', buttonClick);

// mouse hover
var box = document.getElementById('box');
box.addEventListener('mouseenter', runEvent);
box.addEventListener('mouseleave', runEvent);
box.addEventListener('mouseover', runEvent);
box.addEventListener('mouseout', runEvent);
box.addEventListener('mousemove', runEvent);

//keyborad actions -> input boxes
var itemInput = document.querySelector('input[type="text"]');
itemInput.addEventListener('input', runEvent);
itemInput.addEventListener('keyup', runEvent);
itemInput.addEventListener('keypress', runEvent);
itemInput.addEventListener('focus', runEvent);
itemInput.addEventListener('blur', runEvent);
itemInput.addEventListener('cut', runEvent);
itemInput.addEventListener('paste', runEvent);
itemInput.addEventListener('input', runEvent);

// select actions
var select = document.querySelector('select');
select.addEventListener('change', runEvent);
select.addEventListener('input', runEvent);

//form actions
var form = document.querySelector('form');
form.addEventListener('submit', submitEvent);

function buttonClick(e){
  e.preventDefault();
  console.log('Button clicked');
  
  //event attributes
  console.log(e);
  console.log("Event :", e.type);
  console.log("Event screen coordinates:", e.screenX, e.screenY);
  console.log("Event window coordinates:", e.clientX, e.clientY);
  console.log("Event doument coordinates:", e.pageX, e.pageY);
  console.log("Event element coordinates:", e.offsetX, e.offsetY);
  console.log("Alt key pressed:" + e.altKey);
  console.log("Ctrl key pressed:", e.ctrlKey);
  console.log("Shift key pressed:", e.shiftKey);

  console.log("Event element :", e.target);
  console.log("Event element id:", e.target.id);
  console.log("Event element class:", e.target.className);
  console.log("Event element classList:",e.target.classList);
  
}

function runEvent(e){
  // e.preventDefault();
  // console.log('Event type: '+ e.type);
}

function submitEvent(e){
  
}


//table
var table = document.querySelector("table");