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


 
The built-in path module in Node.js provides several useful functions for working with file paths. 
Two commonly used functions are path.join() and path.resolve(). Here's a brief explanation of their uses:

path.join([path1], [path2], [...]):
The path.join() function is used to join multiple path segments together into a single normalized path.
It takes multiple arguments representing the path segments and returns a string representing the joined path. 
The function automatically handles the correct path delimiter (forward slash or backslash) based on the operating system.
Example:


const path = require('path');

const joinedPath = path.join('/home', 'user', 'documents', 'file.txt');
console.log(joinedPath); // Output: /home/user/documents/file.txt
In this example, the path.join() function is used to join the path segments /home, user, documents, and file.txt into a single path /home/user/documents/file.txt.

path.resolve([path1], [path2], [...]):
The path.resolve() function is used to resolve an absolute path from the given path segments.
It resolves the path segments relative to the current working directory and returns an absolute path as a string. 
The resolved path may include symbolic links, relative paths, or parent directory references (. and ..).
Example:


const path = require('path');

const resolvedPath = path.resolve('src', 'app', '..', 'index.js');
console.log(resolvedPath); // Output: /path/to/current/directory/src/index.js
In this example, the path.resolve() function resolves the path segments src, app, .. (parent directory), and index.js
relative to the current working directory. The resulting path is an absolute path to the index.js file.

The path.resolve() function is especially useful when you need to work with file paths that are relative to the current
working directory or when you need to resolve the absolute path for a given file or directory.

Both path.join() and path.resolve() are helpful for manipulating and working with file paths in a cross-platform manner in Node.js applications.








*****************************************************************************************************************************************************************



















































































..
