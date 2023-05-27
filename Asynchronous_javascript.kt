

Befoere we Learn About ASynchromous java script, There is something we need to undersatnd about Java script


JAVASCRIPT
Javascri[t is a synchronous ,blocking single threaded lanfuage
         
         
         
         1.Synchronos
         
         It means code will be excude i one line from top to down
         If we have two cosnole,log messgaes
        Console.log("A")
        Console.log("B")
        Then Log A will Be excuted first Then Log B
         Code excutes top down, with only one line excuting at any given time.
         
         2.Blockinf
         This is because of its synchronous nature
         This means that No matte how long a previous process takes, the subsequesnt process wont kick off until
         the former is completed
         That is what blocking means


         3.Single Threaded
         Java script does not support multithreading
         Javascript has just one thread called the main thread for excuting any code
         This means thread and javascript can only do one task at a time
         A thread is a process that your javascript can use to run a task.



         
         We can Not wait for long Time taking tasks to complete so that we can continue with our code excution
         That is why we need asyncronous javascript
         
         
         But for assynchronous javascriptm Javascript is not enougj
         
         We need new pieces outside of javascript to help us write asynchronous code
         For Front-end, This is where web brosers come into play
         For backend, This is where Node.js Comes into play


         

Web brosers and Node.js define functions and Apis that allow us to register functions that should not be 
         excuted synchrounously, and that should instead be invoked asynchronoulsy , when some kind of event occures
         
         
         

For example,that could be passing of time (SetTimeout, setInterval)
The users interaction with the mouce(addEventListner)
Data being read from a file system or the arrival of data over the network (callbacks,Promises, async-await)


This means that your code can do several things at the same time without stopping or blocking your main thread.



The synchrous Blocking nature of javascrit is not benefitioal for writting apps
         
We want non-Blocking asynchronous behaviou, which is made possible by a browser for front end and Node.js for backenf=d


         IN NODE JS JAVASCRIOT IS ABLE TO RUN ASYNCRONOUSLY BECAUSE OF THE LIBUV LIBRAY
****************************************************************************************************************
    
                  
        This is what node js is made up of unde the hood          
                  
                node js  
---------------------------------------         
        1. JS libray                  |
                                      |
        2.c/c++ features              |
                                      |
        3.Dependecies                 |
            (a) V8 engine             |
            (b) libuv                 |         ----> This is the one enebling us to write asyncronous javascript in node js
            (c) zlib                  |
            (d) crypto                |
            (d) etc                   |
---------------------------------------         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         



ASYNCCHROINUS JAVASCRIPT
******************************************************************


    
Executing code asynchronously in JavaScript means that the code doesnt block the execution of other code.
In traditional synchronous programming, code is executed sequentially, one line at a time, 
and each line of code must complete before moving on to the next line. This can be problematic when dealing 
with time-consuming tasks or operations that involve waiting for external resources.

Asynchronous programming in JavaScript allows code to run concurrently and independently, without waiting for
blocking operations to complete. It enables the execution of multiple tasks simultaneously, improving the overall
performance and responsiveness of the application. Here are a few key concepts related to asynchronous code execution:

Callbacks: Callbacks are a common pattern in JavaScript for handling asynchronous operations. Instead of waiting 
for a task to complete, a callback function is passed as an argument to the asynchronous function. When the task finishes,
the callback is invoked, allowing you to handle the result or continue with the next steps.

Promises: Promises provide a more structured and intuitive way to handle asynchronous operations in JavaScript. 
A Promise represents the eventual completion (or failure) of an asynchronous operation and allows you to chain operations
using .then() and .catch() methods. Promises help avoid the "callback hell" problem and provide better error handling and control flow
.

Async/Await: Async/await is a modern syntax introduced in ECMAScript 2017 (ES8) that simplifies working with Promises.
It allows you to write asynchronous code that looks more like synchronous code, making it easier to read, write, 
and reason about asynchronous operations. The async keyword is used to define an asynchronous function,
and await is used to pause the execution and wait for a Promise to resolve.

Asynchronous code execution is particularly useful when dealing with I/O operations, such as fetching data
from an API, reading from a file, or making database queries. It allows the program to continue executing 
other tasks while waiting for the asynchronous operations to complete, preventing the application from becoming unresponsive.

By leveraging asynchronous programming techniques, JavaScript can handle multiple tasks concurrently, 
make efficient use of system resources, and provide a better user experience in applications that 
involve time-consuming or non-blocking operations.































































































































































































...
