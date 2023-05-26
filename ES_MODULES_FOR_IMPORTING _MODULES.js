IN THE PAST WE HAVE BEEN USING COMMONJS

Which treats each file a a module

Where variables , functions, classes e.tc are not accessible to other files by default

Where you have to explicity tell the module system which parts of your code should be exported via module.exports

Where to impott code into a file , you use the require() function.



HOW EVER A NE WAY OF IMPORTING MODULES HAS BEEN INTRODUCED CALLED  ES MODULES


ES MODULES
The file names end with .mjs


1.FIRST EXPORT IMPORT PATTERN


math.mjs

const add = (a,b) => {
  
  return a+b;
}

expor default add;



The imprt in index.mjs

import add from '.math.mjs'

console.log(add(9,8))




2. Second export pattern, whe have the export on the  function



math.mjs

expor default = (a,b) => {
  
  return a+b;
}




The imprt in index.mjs

import add from '.math.mjs'

console.log(add(9,8))




3. Where we export more than one function or varaible

math.mjs

const add = (a,b) => {
  
  return a+b;
}


const subtract = (a,b) => {
  
  return a - b;
}



export default {
  
  add:add,
  subtract:subtract


}




The imprt in index.mjs

import math from '.math.mjs'


console.log(math.add(9,8))
console.log(math.subtract(9,8))





4. Named export where you have to import the named patters as it is  named
Here we put the xport name infron of the function name

math.mjs

export const add = (a,b) => {
  
  return a+b;
}


export const subtract = (a,b) => {
  
  return a - b;
}


There are two ways of impoting in index.mjs



a) ----> This is the more common one

import {add,subtract} from '.math.mjs'

console.log(add(9,8))
console.log(subtract(9,8))



b) -->The imprt in index.mjs

import * as math from '.math.mjs'
const {add,subtract} = math;

console.log(add(9,8))
console.log(subtract(9,8))







SUMMMARY

Instead of unsing the modeule.exports we use the export keyword
The export can be default or named
We import the exported variables or functions using the import keyword
if it is a default export, we can assign any name while importing
if it is a named export, the import name must be the same







































































































































































..




