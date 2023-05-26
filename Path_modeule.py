PATH MODEULE

The path module provides utilietes for working with file and directpory paths

index.js

const path = require('node:path')

 

console.log(__dirname)                 -->  Prints the directory path
D:\node

console.log(__filename)                --> Prints the file path
D:\node\node.js

  
  
  
  
  
  
console.log(path.basename(__dirname))   --> Prints the folder name
node

console.log(path.basename(__filename))   --> Prints the file name
node.js        







console.log(path.extname(__dirname))   --> Prints th extension of the folder, which is nothing , hence an empy string in the terminal


console.log(path.extname(__filename))   --> Prints the extension of the file which is .js
.js






console.log(path.parse(__filename))   ---> Print information about base, root, extension and name, The information in this can be accessed like anuothet javascript object

{
  root: 'D:\\',    
  dir: 'D:\\node', 
  base: 'index.js',
  ext: '.js',      
  name: 'index'    
}









console.log(path.format(path.parse(__filename)))   ---> Formathrs the information above into a file path
D:\node\index.js


console.log(path.isAbsolute(__filename))   --> Tell us if the file path is froom the root, retuns boolean true , since the filename ath is from root. This file  path is absolute
true


console.log(path.isAbsolute('./data.json'))  --Return false since this path is not absloulye and does not start from root. This file path is relative
false







console.log(path.join("folder1","folder2","index.html"))
folder1\folder2\index.html


console.log(path.resolve("folder1","folder2","index.html"))
D:\node\folder1\folder2\index.html






























































































..
