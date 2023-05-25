MODULES

A  module is an encapsulated and resuable chunk of code that has its own context

In node.js , each file is treated as a separate module


Types of Modules

Local modules - Modules that we create in our application
Built-in-modules - Modules that Node.js ships with out of the box
Third party modules - Modules written by other developers that we can use in our application









Locol Module

Modueles that we create and use in our application

In nodejs , each file is a module, but is isolated by default

To share modules in node js, CommonJs is used



To use a module in a diffreent file , we use require('file path ')

e.g

add.js
const add = (a,b)=> {
    return a+b
} 


const sum  = add(90,6)

console.log(sum)


----------------------

index.js

require('./add')
console.log("Hello George Gaac");


result -->
PS D:\node> node node.js
96
Hello George Gaac
PS D:\node> 



But when we use require, We are telling node js to excute the code in that file


A better way to do this is to ol expose certain parts of our file and keep some private,

We do this by using modle exports to expose certain parts of the module and keep the rest private




in The add.js file , we insteda export the add function


add.js
const add = (a,b)=> {
    return a+b
} 

module.exports = add



When we import hthe add moduel, w get the ad function, which we can store add in a costant
This enables us to calll add , any number of times , as it is a reusable block of code

index.js

const add = require("./add")


console.log("Hello George Gaac");


const sum1 = add(78,90);
const sum2 = add(8,9);
const sum3 = add(17,19);

console.log(sum);


The result
 PS D:\node> node node.js
Hello George Gaac
168
17
36
PS D:\node> 




The above is the commonJs Format Node js Adhere s to

--> Exposing certain parts of a module using module.exports
--> Imprting that functionality of that module using require, and storing that functionality in a cosntant
--> Then using that functionality in the imported file


Module Scope

What is witten in one module is not aware of what is written in  another module. This is called the iife


In Node.js, you can create Immediately Invoked Function Expressions (IIFE) just like in traditional JavaScript. Heres an example:


(function() {
  // Your code here
  console.log("IIFE in Node.js");
  // Other statements
})();
In this example, we define an anonymous function enclosed within parentheses (function() { ... }). 
The function is immediately invoked by adding () at the end (function() { ... })(). 
Any code you want to execute immediately should be placed inside the function. 
This helps encapsulate the code and avoid polluting the global scope.

The IIFE is commonly used in Node.js for creating private scopes, modularizing code, and preventing variable conflicts. 
It allows you to execute code once without explicitly calling the function.
Iiife allows you to repeat variable or functionames without any conflicts












































































































..
