How the web works


Computers connected to the internet are called cleints and servers

clients are internet-connected devices such as computers or mobile phones , along with web accesing software such as  web browser.


Servers are computers that store web pages, sites or apps



 A client send a request to the server
The server sends a copy of the web page to the clent, through a response
This model is called client server model



But what if the request that the clnt sends is not understood by the  server
What if the response sent by the server is not understoood by the client


That is where HTTP comes in



HTTP 
Hyper Text Tranfer Protocol
Protocal is a set of rules

Http - Is a protocol that defines a format for clients and servers to speak to each other
A client sends a HTTP request and a server respomds with a HTTP response


This is how the web works on a high level


But where does node fit i , in all of this



HTTP AND NODE
We can create a server using Node.js

Node.js has acccess to operating system functionality like networking

Node has an event loop to run tasks a synchronoulsy and is perfect for creating web servers that can run simultaneously  handle large voulumes of requests

The node server we create should still respect the HTTP format, and for that we use the built in HTTP module
The HTTP module allows for creation of  web servers that can transfer data over HTTP








CREATING SERVER USING HTTP MODULE
***************************************************************************************************************************

 const http = require('node:http')
 
 
 // The create server method takes in a callback function as an argument
 //This call back function takes two argumets, request,and response
const server = http.createServer((req,res)=>{
  res.writeHead(200,{"Content-Type":"text/plain"})  // It is adviced to specify the content type
  res.end("Hello World")
 })


server.listen(3000)

Http module also extends the event emitter class, and the callback function we specified here is a request listner
That is, when a request reaches a server, that  function is excuted



RESPONDING TO REQUEST WITH JSON DATA
*********************************************************************************************

To covert a Javascript object to JSON we use 
JSON.stringfy(object)


for example


const http = require('node:http')
 
const name ={
    name:"George Gacau",
    age:21,
    married:false
}
 
// The create server method takes in a callback function as an argument
//This call back function takes two argumets, request,and response
const server = http.createServer((req,res)=>{
 res.writeHead(200,{"Content-Type":"application/json"})        --> It is always advised to include the content type when sending a respone to the broswer.
 res.end(JSON.stringify(name))---------------------------- > Here we send the javascript object as in JSOn format.
})


server.listen(3000,()=>{
    console.log("The server is running")
})







RESPONDING TO REQUEST WITH HTML DATA
*********************************************************************************************


 
 const http = require('node:http')
 



 
 const server = http.createServer((req,res)=>{
 res.writeHead(200,{"Content-Type":"text/html"})   ->> This tells the browesr to tret the responded as html
 res.end("<h1>Hello George Gacau</h1>")
})


server.listen(3000,()=>{
    console.log("The server is running")
})












THERE ARE TWO OTHER WAYS TO SEND BACK HTML FILES

USING FS MODULE


const http = require('node:http')
const fs = require('node:fs')
 

 
const server = http.createServer((req,res)=>{
 const html = fs.readFileSync(__dirname+'./index.html','utf-8')  --> Using fileSyc to read the data in the html file and display it in the broser
 res.writeHead(200,{"Content-Type":"text/html"})
 res.end(html)
})


server.listen(3000,()=>{
    console.log("The server is running")
})




USING PIPES- This is the better approach

const http = require('node:http')
const fs = require('node:fs')
 

 
const server = http.createServer((req,res)=>{
 fs.createReadStream(__dirname+'./index.html').pipe(res)
 res.writeHead(200,{"Content-Type":"text/html"})
})


server.listen(3000,()=>{
    console.log("The server is running")
})





WORKING WITH HTML TEMPLATE
********************************************************************************************************************
To be able to dynaicaly display dat in html pages, we use the string replace method

in the  html

index.html

<!DOCTYPE html>

</head>
<body>
    <P>Kimani  is you name and this is {{name}} </P>
    <h1> This ai a gOdd day to workm as a developer</h1>
    
</body>
</html>


index.js


const http = require('node:http')
const fs = require('node:fs')
 
const name ="George Gacau"


 
const server = http.createServer((req,res)=>{
 let html =fs.readFileSync('./index.html','utf-8')   
 html = html.replace("{{name}}",name)                            --> Here we rerplavce the name with the name in our index gile
 res.writeHead(200,{"Content-Type":"text/html"})
 res.end(html)
})


server.listen(3000,()=>{
    console.log("The server is running")
})







HTML ROUTING
***************************************************************************************************************

 Here we are going to respond to different  routes received in request objects


const http = require('node:http')
const fs = require('node:fs')
 
const server = http.createServer((req,res)=>{

    if(req.url === '/'){
        res.writeHead(200,{"Content-Type":"text/plain"})
        res.end("Home page")
    }
    else if (req.url === '/about'){
        
            res.writeHead(200,{"Content-Type":"text/plain"})
            res.end("About page")
        }
 
    else if (req.url === '/services'){
       
            res.writeHead(200,{"Content-Type":"text/plain"})
            res.end(" Services page")
        }

    else{
            res.writeHead(404,{"Content-Type":"text/plain"})
            res.end("404 error")
        }

})


server.listen(3000,()=>{
    console.log("The server is running")
})





BUT TYPICALY IN REAL WORD APPLICATIONS, yOU USE A WEB FRAMWORK TO HANDLE ALL YOUR ROUTING NEEDS AND RESPONFDING APPROATLY TO HTTP METHODS
The req.methods  allows us to respond correctly to http methods.

























....
