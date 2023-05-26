


A function that accepts another function as an argument is aclled a highrr order function
A funtion passed as an argument to another function is called callback function


index.js


function reet(name){
  console.log(`Hello ${name}`);

}


function higherOredrfunction(callback){
  const name ="Vishwas"
  callback(name)
}



higherOrderfunction(greet);








TYPES OF CALLBACKS
Syncrous callbacks
Asynchronous callbacks


SYNCHROUNS CALLBACKS
A callback that is excuted immediatly is called a synchrounous callback

function reet(name){
  console.log(`Hello ${name}`);

}


function higherOredrfunction(callback){
  const name ="Vishwas"
  callback(name)   --> This is a sychrous callback
}




ASYNCHROUMOUS CALLBACKS

A callback that is often used to continue or resume code exction after an asynchromous operation has completed 

These are callbacks that are used to delay the excution of a function until a particular time or event has occured


In node.js most functions have an asynchrous nature to prevent blocking of excution

e.g fetcing data from database,handling network request















































































































...
