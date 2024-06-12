//Normal scenario
const quotes = [
    { author: "Bilbo Baggins", quote: "Not all those who wander are lost." },
    { author: "Gandalf", quote: "The Ring has awoken, it’s heard its master’s call." },
];

function getQuotes() {
    setTimeout(() => {
        let output = "";
        quotes.forEach((quote) => (output += `<li style="text-align: left; margin: 20px; font-size: 18px; font-weight: bold;">${quote.quote} - ${quote.author}</li>`));
        document.body.innerHTML = output;
    }, 1000);
}

function createQuotes(quote) {
    setTimeout(() => { 
        quotes.push(quote);
    }, 2000);
}

createQuotes({author: 'Smeagol', quote: 'My Precious!!!'});
getQuotes();

//Callback
function createQuoteWithCallback(quote, callback){
    setTimeout(() => {
        quotes.push(quote);
        callback();
    }, 2000)
}

// createQuoteWithCallback({author: 'Smeagol', quote: 'My Precious!!!'}, getQuotes);

//Promise
function createQuoteWithPromise(quote){
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            quotes.push(quote);
            const error = false;
            if(!error){
                resolve();
            } else {
                reject();
            }
        }, 2000)
    })
}

createQuoteWithPromise({author: 'Smeagol', quote: 'My Precious!!!'})
    .then(getQuotes)
    .catch(err => console.error(err));

//Combinig multiple promises
//takes time of longest
const promise1 = Promise.resolve("Hello");
const promise2 = 3000;
const promise3 = new Promise((resolve, reject) =>setTimeout(resolve, 2000, "Goodbye!"));
const promise4 = fetch("https://jsonplaceholder.typicode.com/users").then((res) => res.json());

Promise.all([promise1, promise2, promise3, promise4]).then((values) =>console.log(values));

// Async / await
// await expression needs to be a promise
async function asyncFunction(){
    await createQuoteWithPromise({author: 'Smeagol', quote: 'My Precious!!!'});
    getQuotes();
}

asyncFunction();