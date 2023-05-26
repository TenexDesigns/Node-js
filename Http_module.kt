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
































































....
