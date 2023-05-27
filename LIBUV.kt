WHAT IS LIBUV

What is libuv ?
  Libuv is a cross platform open source library writtten in  C language

Why do we need LIBUV
It handles asynchronous non-blocking operations in Node.js

How Does it do the above
using 1.--> Theread pool  - It is a pool of threads in the libuv that  the javascript main thread can offload time consuming tasks to. 
                             This thread pool works on the time consuming tasks and after compliting the tasks, the associated callback function is called.
      2.--> Event loop






THREAD POOP
 It is a pool of threads in the libuv that  the javascript main thread can offload time consuming tasks to. 
This thread pool works on the time consuming tasks and after compliting the tasks, the associated callback function is called.


A ferw async methods like fs.readfile and crypto.pbkd2 run on separate threads in libuvs thread poool.
They do not run synchronously in theirw own threads, but as far as the main thread is concerened,
it apperares the method is runing asynchronoulmsly.


Libuv has a pool of 4 threads
If we are excuting 5 tasks in pararl and each task takes about 300 miliseconds, then the first 4 will each take 300 miliceconnds, but the fifht will take 600 miliseconds
This is because the 5 task will wait for the first task to finish , and then that will be done on the first thread
This will result in it waititng for the first 300 miliseconds, and then it taking 300 miliseconds to  do its own task, thus resulting in 600  miliseconds.





BUT , CAN WE INCREASE THE THREAD POOL, SO THAT WE CAN RUN MORE TASKS IN PARELL,
The answer is yes

To increase the number of threads just run this 

 process.env.UV_THREADPOOL_SIZE = 5;  --- This increase the number of threads to 5;


BY Increasing the thread pool, we are able to improve the total time taken to run multile calls of an asynchronous method like pbkfd2


How ever if you increase the number of threads beyond the number of cpu cores, then the time for  excution also increases.
So Increasing the thread pool size can help with performanc, buit that is limited by the number of available cpu cores.


 const fs = require('node:fs');
 const crypto = require("crypto");
 
 process.env.UV_THREADPOOL_SIZE = 16;
 
 const start = Date.now();
 
 const MAX_CALLS = 7;
 
 for (let i = 0; i < MAX_CALLS; i++) {
   crypto.pbkdf2("a", "b", 10000, 512, "sha512", () => {
     console.log(`Hash: ${i + 1}`, Date.now() - start);
     })
     
    };


----------------------------------------------------------------------------------------------------------


How wever , Not all sync functions in node js seem  to be using the thread pool, they are insterad using the native asyn 
Here we are making a network call using the https method.
How ever, it looks like this method does not care about the threrads, and time excuted for the calls remails the same, even if calles are 3 or 16

const https = require("https");

 process.env.UV_THREADPOOL_SIZE = 16;

const start = Date.now();

const MAX_CALLS = 12;

for (let i = 0; i < MAX_CALLS; i++) {

  https
    .request("https://www.google.com", (res) => {
      res.on("data", () => {});
      res.on("end", () => {
        console.log(`Request: ${i + 1}`, Date.now() - start);
      });
    })
    .end();


The inference
  Although both  crypto.pdkf2 and https.request are asyncronous , http.request method does not sem to use the thread pool
  htttp.request does not seem to be affected by the number of threads or the number of cpu core eihther

Networks I/O - Http.request is a network input/output opearation and  not a cpu bound operation
It does not use the thread pool


For the  http.request method, libuv instead delegete the work to the opearting system kernel,and then libuv pools the  kernel to see if the request has completed
  



LIBUV AND ASYNC METHODS SUMMARY
  In node.js async methods are handled by libuv
  These asyncs methods in libuv are handled in two differen t ways
    1. Native async mechanism
    2. Thread pool


Whenever possible, LIBUV will use native async mechanisms in the os, so as to avoid blocking the main thread
Since this is part of the kernel, there is different mechanisms for each os, We have poll for linux,Kququq for MACOS and IO completeion port for windws  

Relying on native async mechanisms makes Node  scaleable as the only limitation is the operating system kernel
e.g network I/O opreation is highly scalable and the  only limitataion to it will be the  oprating syystem kernel, and not the cpu, or cpu cores or threads, since this opration is not cpu bound w.g  https.request() method



--------------
How ever if there is no native async support of the task, or if the taski is file I/O  or CPU intensive,
  Then LIBUV uses the thread pool to avoid blocking the main thread
  
  Although the thread pool preserves asynchronicty with respect to NOde;s main thread, it can still become a bottleneck if all threads are busy.



















******************************EVENT LOOP ******************88
Event loop is a cprogram and is part of libuv
 
  It is a design patttern that orchestrates or co-rdinates the excution of synchronous and asynchronous code in node.js


11:04
step one
11:05
any callbacks in the micro task queues
11:08
are executed
11:10
first tasks in the next queue and only
11:13
then tasks in the promise queue
11:16
Step 2 all callbacks within the timer
11:19
queue are executed
11:22
step 3 callbacks in the micro task
11:24
queues if present are executed after the
11:28
execution of every callback in the timer
11:30
queue
11:31
again first tasks in the next queue and
11:35
then tasks in the promise queue
11:38
step 4
11:39
all callbacks within the ioq are
11:42
executed
11:44
step 5 callbacks in the micro task
11:47
queues if present are executed
11:50
next to queue followed by promise queue
11:54
step 6 all callbacks in the check queue
11:57
are executed
11:59
step 7 callbacks in the micro task
12:02
queues if present are executed after the
12:05
execution of every callback in the check
12:08
queue
12:09
again first tasks in the next IQ and
12:12
then tasks in the promise queue
12:15
step 8 all callbacks in the close queue
12:19
are executed
12:21
step 9
12:22
for one final time in the same Loop the
12:25
micro task queues are executed next a
12:29
queue followed by promise queue
12:32
at this point if there are more
12:35
callbacks to be processed the loop is
12:38
kept alive for one more run and the same
12:41
steps are repeated
12:43
on the other hand
12:45
if all callbacks are executed and there
12:47
is no more code to process the event
12:50
Loop exits
12:52
this is the role libuey's event Loop


plays in the execution of async code in
12:57
node.js





















..
