
console.log('first')
console.log('second')
console.log('third')



NODE.JS
----------------------------------------------------------------------------

----------------------------------            ---------------
        V8 engine                |            |     LIBUV   |  
 ____________________________    |            |             | 
Memory heap | Call stack         |            |             | 
            |                    |            |             | 
            |                    |            |             | 
            |                    |            |             | 
            |console.log("first")|            |             | 
            |___________________ |            |             | 
            |   global()         |            ----------------
----------------------------------
  
-----------------------------------------------------------------------------------

  
  
  
  
---------------------------------
       Console                  |
                                |
                                |
                                |
                                |
----------------------------------




















First lets take a look at synchronous code execution
on the left we have a simple code snippet three console log statements that log
first, second and third ,one after the other

lets now walk through the code as if the main thread of execution always  starts in the global scope
so the global function is pushed onto the stack [as gloabl() ]

then on line 1 we have a console log statement the function is pushed onto the stack as console.log()
and for the sake of understanding the timeline lets assume this happens at one millisecond,
"first " is logged to the console then the function is popped off  the stack(removed fromt the satck,leaving behing global()) 

Execution comes to line two lets say at 2 milliseconds
log function is again pushed onto the stack
"second "is locked to the console and the function is popped off the stack 

finally execution is on line three and
at three milliseconds function is pushed onto the stack
"third" is locked to the console
and the function is popped off the stack there is no more code to execute and

Global [global()] is also popped off
this is pretty much how synchronous code execution can be visualized with the node runtime
is executed in the node runtime








Asyncronous










console.log('first')
fs.readfile(__filename,()=>{
  cosnole.log("Second")
})
console.log('third')



NODE.JS
----------------------------------------------------------------------------

----------------------------------            -----------------------
        V8 engine                |            |     LIBUV           |  
 ____________________________    |            |                     | 
Memory heap | Call stack         |            |                     | 
            |                    |            | ()=>{               | 
            |                    |            | console.log("second")  
            |                    |            |     }               | 
            |  callback()        |            |                     | 
            |___________________ |            |                     | 
            |   global()         |            -----------------------
----------------------------------
  
-----------------------------------------------------------------------------------

  
  
  
  
---------------------------------
       Console                  |
                                |
                                |
                                |
                                |
----------------------------------




next lets take a look at async nescode

execution

on the left we have another code snippet

three log statements like before but

this time the second log statement is

within a callback function passed to FS

dot read file

let us once again walk through the code

as if the runtime is executing it

the main thread of execution always

starts in the global scope so the global

function is pushed onto the stack

execution comes to line one at one

millisecond console.log is pushed onto

the stack

first is logged in the console

and the function is popped off the stack

execution now moves on to line two

add  milliseconds the read file method

gets pushed onto the stack

in the earlier lecture I mentioned that

read file is an async operation that is

offloaded to libue

so what happens now is that the Callback

function is handed over to libue

JavaScript then simply pops off the

read method from the call stack because

its job is done as far as execution of

line  is concerned

in the background the beauty starts to

read the file contents on a separate

thread

at  milliseconds JavaScript proceeds to

line . it pushes the log function onto

the stack

third gets locked to the console

and the function is popped off the stack

now there is no more user written code

in the global scope to execute so the

call stack is empty

at about  milliseconds let's say that

the file read task is completed in the

thread pool

the associated callback function

is now pushed onto the call stack

within the Callback function we have the

log statement

that is pushed onto the call stack

second is locked to the console and the

function is popped off

as there are no more statements to

execute in the Callback function

that is popped off as well

no more code to run so the global

function as we call it is also popped

off the stack

the console output is going to read

first third and then second

this is how the node runtime executes an

asynchronous code snippet that uses FS

dot read file

similar execution holds good for other

async methods as well

I hope it is clear to you as to how code

is executed in the node runtime




























































































next let's take a look at async nescode
3:17
execution
3:18
on the left we have another code snippet
3:22
three log statements like before but
3:24
this time the second log statement is
3:27
within a callback function passed to FS
3:29
dot read file
3:32
let us once again walk through the code
3:34
as if the runtime is executing it
3:38
the main thread of execution always
3:40
starts in the global scope so the global
3:42
function is pushed onto the stack
3:45
execution comes to line one at one
3:48
millisecond console.log is pushed onto
3:51
the stack
3:52
first is logged in the console
3:55
and the function is popped off the stack
3:58
execution now moves on to line two
4:02
add 2 milliseconds the read file method
4:05
gets pushed onto the stack
4:07
in the earlier lecture I mentioned that
4:09
read file is an async operation that is
4:12
offloaded to libue
4:14
so what happens now is that the Callback
4:17
function is handed over to libue
4:20
JavaScript then simply pops off the
4:23
read5 method from the call stack because
4:25
its job is done as far as execution of
4:28
line 2 is concerned
4:30
in the background the beauty starts to
4:33
read the file contents on a separate
4:35
thread
4:37
at 3 milliseconds JavaScript proceeds to
4:40
line 5. it pushes the log function onto
4:43
the stack
4:45
third gets locked to the console
4:47
and the function is popped off the stack
4:51
now there is no more user written code
4:53
in the global scope to execute so the
4:56
call stack is empty
4:58
at about 4 milliseconds let's say that
5:01
the file read task is completed in the
5:03
thread pool
5:04
the associated callback function
5:07
is now pushed onto the call stack
5:10
within the Callback function we have the
5:12
log statement
5:14
that is pushed onto the call stack
5:17
second is locked to the console and the
5:19
function is popped off
5:22
as there are no more statements to
5:24
execute in the Callback function
5:26
that is popped off as well
5:28
no more code to run so the global
5:31
function as we call it is also popped
5:33
off the stack
5:35
the console output is going to read
5:37
first third and then second
5:40
this is how the node runtime executes an
5:44
asynchronous code snippet that uses FS
5:47
dot read file
5:49
similar execution holds good for other
5:51
async methods as well
5:54
I hope it is clear to you as to how code
5:56
is executed in the node runtime





































...
