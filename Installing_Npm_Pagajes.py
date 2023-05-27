What to llo for when installing a packaage from NPM

-> It age
-> Weekly downloads . The more the better
-> Its size - Should not be too large as it increase project size
-> It documentation




Installing Packages:
To install packages using npm, you can run the following command in your project's directory:


npm installipper-case

This command installs the package and its dependencies, adding them to the node_modules directory in your project.


Deependecies

The package you install is added to a fileled callled dependecies on the package.json file

e.g  
"dependencies": {
    "upper-case": "^2.0.2"
}




  
 node_modules Directory:
  Where the package is installed is in the node modules
The node_modules directory is where npm installs packages and their dependencies. 
It acts as a local repository for all the packages required by your project. 
It is automatically created and managed by npm, and you should not modify or commit it to version control.
Instead, you can include the node_modules directory in your .gitignore file to prevent it from being tracked.
  
  


package-lock.json File:
  This package is keeps track of installed packages and their subsquent versions, ensuring thre is no inconsistency wen some one install the same packages
The package-lock.json file is generated automatically when you run npm install and helps ensure reproducible builds. 
It serves as a record of the exact versions of dependencies installed in your project, including their transitive dependencies. 
The package-lock.json file helps
maintain consistency across different environments and ensures that subsequent installations use the same package versions.






TO UNINSTALL A PACKAGE

npm uninstall uper-case









































































...
