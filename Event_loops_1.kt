
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











Under stanfing the event Lop cycle
----------------------------------------------------------------------------
Event loop is a loop that is up and running as long as your node js is running
In every iteration of the loop , we come across six diffrent queues,
Each queue holds one or more call back functions that need to be  excuted on the call statck
The type of call back functions are diffrent for each quueu



Types of Queue on the Event loop

1.first we have the IMER QUEUE this contains callbacks associated with set timeout and set interval


2.second we have the I/O QUEUE this contains callbacks associated with all the async methods that we have seen
so far example methods associated with the fs and HTTP modules


3.third we have the CHECK QUEUE now this contains the callbacks associated with a function called set immediate
this function is specific to node and its not something you would come across when writing JavaScript for the browser


4.fourth we have the CLOSE QUEUE this contains callbacks associated with the close event of an async task


----->finally we have a MICRO QUEUE at  the center this is actually TWO SEPARATE QUEUE cues 


5.the first queue is called NEXT TICK QUEUE and contains callbacks associated
with a function called process dot next take which is again specific to node.js

6.the second cue is the PROMISE QUEUE which contains callbacks that are associated with the native promise in JavaScript


and one very important point to note is that timer IO check and close queues are all part of libuby

the two microtask use however are not  part of libuee

nevertheless they are still part of the node runtime and play an important role in the order of execution of callbacks
speaking of which lets understand that next


ORDER OF EXCUTION OF CALL BACKS
nOTE
--> All user written synchronousjavascript code takes priority over async code that the runtime would like to excute
--> This means that only afte the call stack is empty , does the event loop come into picture

RURLES AND ORDER OF EXCUTION

1.step 1.
any callbacks in the micro task queues are executed first tasks in the next queue and only then tasks in the promise queue
2.Step 2
all callbacks within the timer queue are executed
3.step 3
callbacks in the micro task queues if present are executed after the execution of every callback in the timer
queue again first tasks in the next queue and then tasks in the promise queue
4.step 4
all callbacks within the ioq are executed
5.step 5
callbacks in the micro task queues if present are executed next to queue followed by promise queue
6.step 6 
all callbacks in the check queue are executed 
7.step 7
callbacks in the micro task queues if present are executed after the execution of every callback in the check
queue again first tasks in the next IQ and then tasks in the promise queue
8.step 8 
all callbacks in the close queue are executed
9.step 9 
for one final time in the same Loop the micro task queues are executed next a queue followed by promise queue

<1>at this point if there are more callbacks to be processed the loop is kept alive for one more run and the same
steps are repeated 
<2>On the other hand,if all callbacks are executed and there is no more code to process the event
Loop exits



this is the role libueys event Loop plays in the execution of async code in node.js











Under stanfing the event Lop cycle



Event loop is a cprogram and is part of libuv
 
  It is a design patttern that orchestrates or co-rdinates the excution of synchronous and asynchronous code in node.js


































































































































....
