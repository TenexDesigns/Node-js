
Points to 

Java script is a synchronous , blocking, single-threaded language

To make async programing possible in node.js, we need the help of libuv



Event loop is a loop that is up and running as long as your node js is running
In every iteration of the loop , we come across six diffrent queues,
Each queue holds one or more call back functions that need to be  excuted on the call statck
The type of call back functions are diffrent for each quueu






HOW CODE EXCUTES IN NODE RUNTIME



----------------------------------            ---------------
        V8 engine                |            |     LIBUV   |  
 ____________________________    |            |             | 
Memory heap | Call stack         |            |             | 
            |                    |            |             | 
            |                    |            |             | 
                                 |            |             | 
                                 |            |             | 
                                 |            |             | 
                                 |            ----------------
----------------------------------
  


1.we have the V8 engine which executes JavaScript code
2.The v8 engine comprises of a memory heap and a call stack
2.Whenever you declare variables or functions ,memory is allocated on the memeory Heap
4.whenever you execute code ,functions are pushed into the call stack and when the
function returns its value , it is popped off the call stack

That is a straightforward last in first out implementation of the stack data structure

5. on the right we have libuv, whenever you execute an async method it is offloaded to the libUV
Libuv will then run the task using , native async mechanisms of the operating system and if that is not possible it 
will utilize its thread pool to run the task ensuring the main thread is not blocked



























































































....
