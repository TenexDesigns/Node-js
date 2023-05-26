The built-in path module in Node.js provides various methods and properties to work with file and directory paths.
Some of the key methods include:




path.basename(path, ext):
Returns the last part of a file path, or the file name if the path ends with a directory separator.
If the path has no extension, it returns the file name with the extension. educba.com
Example:

const path = require('path');
console.log(path.basename('C:\\Users\\index.html')); // Outputs: index.html





path.dirname(path):
Returns the directory name of a given path. codeforgeek.com
Example:

const path = require('path');
console.log(path.dirname('C:\\Users\\index.html')); // Outputs: C:\Users\




path.join(paths): 
Joins all elements of the given array of strings into a single string, 
  with platform-specific path separators. codeforgeek.com
Example:

const path = require('path');
console.log(path.join('a', 'b', 'c')); // Outputs: a/b/c





path.resolve(path, base): 
Resolves a sequence of path segments to an absolute path. codeforgeek.com
Example:

const path = require('path');
console.log(path.resolve('a/b/c', 'base/')); // Outputs: base/a/b/c






path.extname(path):
Returns the file extension of a given path, or . if the path has no extension. codeforgeek.com
Example:

const path = require('path');
console.log(path.extname('C:\\Users\\index.html')); // Outputs: .html





path.isAbsolute(path):
Returns true if the given path is an absolute path, and false otherwise. codeforgeek.com
Example:

const path = require('path');
console.log(path.isAbsolute('C:\\Users\\index.html')); // Outputs: true






path.normalize(path): 
Normalizes a given path, resolving '..' segments and removing './'. codeforgeek.com
Example:

const path = require('path');
console.log(path.normalize('C:\\Users\\index.html\\..\\page.html')); // Outputs: C:\\Users\\index.html\\page.html
These methods help in working with file and directory paths in a platform-independent way, 
  making it easier to create and manipulate paths.








The built-in path module in Node.js provides two main functions for working with file
and directory paths: path.join() and path.resolve().
Both functions have different behaviors when dealing with segments starting with /.

path.join() concatenates the given path segments into a single string.
It handles different path separators for different operating systems and normalizes
the result by removing leading and trailing slashes. Here's an example:

const path = require('path');
path.join('/a', '/b', '/c'); // Outputs: '/a/b/c'
path.join('/a', '/b', 'c'); // Outputs: '/a/b/c'
path.join('a', 'b', 'c'); // Outputs: 'a/b/c'
path.join('a', 'b', 'c'); // Outputs: 'a/b/c'
blog.logrocket.com

path.resolve() constructs an absolute path from right to left until an absolute path is constructed.
It treats each starting directory as the root directory and ignores all previous paths. For example:

path.resolve('/a', '/b', '/c'); // Outputs: '/b/c'
path.resolve('/a', '/b', 'c'); // Outputs: '/b/c'
path.resolve('/a', 'b', 'c'); // Outputs: '/a/b/c'
stackoverflow.com

To decide which function to use, consider how segments starting with / should behave. 
If they should be joined, use path.join(). If they should act as the new root, use path.resolve(). 
The choice also depends on whether the other arguments are hard-coded or subject to change in the future,
  and how consistent the result should be with other parts of the code.

In summary:

Use path.join() when you want to concatenate path segments, and the behavior of segments starting with / should be to join them.
Use path.resolve() when you want to construct an absolute path from right to left, 
  treating each starting directory as the root directory and ignoring all previous paths.
Both functions can be used to avoid edge cases when manipulating paths manually, 
  such as accidentally ending up with duplicate path separators or not handling different path 
  separators for different operating systems.































































































































































..
