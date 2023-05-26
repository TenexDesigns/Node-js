There are various waus to imort and export items from modules in node s


1. Here we wxport the function for adding

math.js


const add = (a,b)=>{
    return a +b

}


module.exports = add;



Here we import thr method and consume it

index.js

const add = require('./math');

const sum = add(5,8);

console.log(sum);





2. Here weassign the module.exports to the function



math.js


module.exports = (a,b)=>{
    return a +b

}

The import remains the same

index.js

const add = require('./math');

const sum = add(5,8);

console.log(sum);



3. Where we export more than one variable or function


math.js


const add = (a,b)=>{
    return a +b

}


const subtract = (a,b)=>{
    return a - b

}



// To export these two, you have to put them in an object
//But if key and value are the same, we can just put the key only
module.exports = {
  add:add,
  subtract:subtract


}


What willbe imported will be an object

index.js
//This require statement will import an object


const math = require('./math');




const sum = math.add(5,8);
const subtract = math.subtract(9,8);

console.log(sum);
console.log(subtract);



DESTRUCTURING IN THE INDEX.JS


const math = require('./math');

const  { add,subtract} = math




const sum1 = add(5,8);
const subtract2 = subtract(9,8);

console.log(sum1);
console.log(subtract2);




4.We assign the  module.exports to the function we want to export




math.js


module.exports.add = (a,b)=>{
    return a +b

}


module.exports.subtract = (a,b)=>{
    return a - b

}




The import will stillbe an object, so


index.js
//This require statement will import an object


const math = require('./math');




const sum = math.add(5,8);
const subtract = math.subtract(9,8);

console.log(sum);
console.log(subtract);




5. Only using exports, But this pattern is highly discouraged


math.js


exports.add = (a,b)=>{
    return a +b

}


exports.subtract = (a,b)=>{
    return a - b

}





The import will stillbe an object, so


index.js
//This require statement will import an object


const math = require('./math');




const sum = math.add(5,8);
const subtract = math.subtract(9,8);

console.log(sum);
console.log(subtract);


































































...
