EVENTS MODULE

The events module allows us to work with events in Node.js
An event is an action or an occurence that has happend in our application that we can respond to
Using the events module, we can dispathc our own custom events and respond to those custom events in a non-blocking mannher



index.js


const EventEmitte = require('node:events');   --> The  reson we called this import eventemmiter and not event is because, the built in events module, returns a class called EventEmiiter, which encapsulates functionality to emit events and to respond to events. You could call this class events, but event emitter is more appropriate.

//Let us instanciate the class

const emitter = new EventEmitter();


//Using this "emitter" object we can emit events



1.// tO EMIY=T AN EVENT WE USE THE EMIT METHOD
//The emit method, accepts the event name as an argument


emitter.emit("order-pizza")


When excution reaches code 27, an event is broadcasted in our code
To respond to this order-pizza event , we need to register an evet listner


To regestter an event listener, we use the "on" method

The on method accepts the event name, and a call back function that will be called when the evet is emitted


emiitter.on("order-pizza",()=>{console.log("Order received ,baking a pizza")})



2. To pass arguments to the callback function from the emit methods


emitter.emit("order-pizza","large","mushroom")


Then we receive the arguments like this

emiitter.on("order-pizza",(size,topping)=>{console.log(`Order received ,baking a${size} pizza with a ${topping}`)})




3. We can regster more than one event listener for our event


emitter.emit("order-pizza","large","mushroom")


Then  we regester more than one event

emiitter.on("order-pizza",(size,topping)=>{console.log(`Order received ,baking a${size} pizza with a ${topping}`)})

emiitter.on("order-pizza",(size,topping)=> {
  if (size == "large"){
    console.log("Thatbis a very larg e pixxaa")
  
  }


})



The above is what we call event drive programing in node js
Events allow us to write code in a non blocking mananer
NOTE --> The evet lisner must come first, The write the event emitter last, coz otherwise the code won't have an event to respond to. e.g

const EventEmitter = require('node:events');

const emitter = new EventEmitter();


emitter.on("order-pizza",(namesis,cityy)=>{
    console.log("Hello Eliud wambu"+namesis+cityy)
})

emitter.on("order-pizza",(nnaa,ciyyyy)=>{
    console.log("Hello Francis kamau"+nnaa+ciyyyy)
})

emitter.on("order-pizza",(name,city)=>{
    console.log("Hello Dennis Kimani"+name+city)
})


emitter.emit("order-pizza","large","Chichago");


The result

Hello Eliud wambulargeChichago
Hello Francis kamaulargeChichago
Hello Dennis KimanilargeChichago










































































































..
