
Fs_Moduels

This file system (fs) module allows us to work with the file system on my computer.


We have a text file

file.txt

Helllo George Gacau



index.js

const fs = require("node:fs");

const fileContent = fs.readFileSync('./file.txt')

console.log(fileContent)



This will Print the follwing

<Buffer 48 65 6c 6c 6f 20 47 65 6f 72 67 65 20 47 61 63 61 75>


This is the binary representation of the content in the file.txt,
If we want it in human readable form, we need to add a character encodeing syestem ,e.g utf-8




index.js

const fs = require("node:fs");

const fileContent = fs.readFileSync('./file.txt','utf-8')

console.log(fileContent)



This will Print the follwing

Hello George Gacau




NOTE _> We are reading th file.txt in syncychronous manner, that is why there is sync in fs.readfilesync

This means that code excution wont continue untl all the content in file.txt has been read.







NODE JS ENABLES US TO RUN CODE ASUNCHRONOUSLY

That is why the fs module has the readfile()  function
This function, takes in the file path and the call back finction, that will be ecuted after the data from the file path is doe
This callback function takes in two arguments,error,data
This patern where a claaback function takes in eror first is called an error firt callback







index.js

const fs = require("node:fs");

const fileContent = fs.readFile('./file.txt','utf-8',(error,data)=>{
  if(error){
    console.log(error)
  } else {
    console.log(data)
  }

})




This will Print the follwing

Hello George Gacau

















TO WRITE DATA SYNCHRONOUSLY AND ASYNCHRONOUSLY


SYNCHRONOUSLY - This takes in the file path and the conetent to be witeen tin the file path.
fs.writeFileSync('./name.txt','George Gacau and ELiud wambu')



ASYNCHRONOUSLY
This takes in the file path,the content to be written , and a callback function, that receives an error parameter,Here we wirte the eror if it occurs, and a confirmation message if the writing is succesful

fs.writeFile('./greet.txt','Helllo George Gacau',(error)=>{
    if(error){
      console.log(error)
    } else {
      console.log('File is already written')
    }
  
  })



TO BE ABLE TO APPEND TO THE EXISTING DATA, INSTEAD OF OVERWRITEIN THE EXISTING DATA.
ADD A { FLAG:"a"}



fs.writeFile('./greet.txt','Helllo George Gacau',{flag:"a"},(error)=>{
    if(error){
      console.log(error)
    } else {
      console.log('File is already written')
    }
  
  })







HOWEVER THERE IS A MORE MODERN PROMIS BASED FS SYSSTEM OF WORKING WITH FILES
THE NDE:FS system is more prefered that the promses based system
********************************************************************************************************************************


// We can use the()  and catch() block since we using promise based fs module
fs.readFile("./file.txt",'utf-8')
.then(data => console.log(data)) // Is Excuted when the operation is succesful, and we get access to the data
.catch(error => console.log(error))  // Is excuted when there is an eror, we get access to the eror , which we can log to the console







/WE CAN ALSO READ THE FILE CONTENT USING ASYNC ASWAIT


async function readFile(){
    try {
        const data = await fs.readFile("./file.txt",'utf-8')
        console.log(data)
    }catch(error){
        console.log(error)

    }


}

readFile();



























































..
