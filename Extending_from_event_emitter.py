There are cases where we would like a class we create to extend the eventEmitter class of the event built in module
For example,Here our pizza shop classs extends the  emitterclass

This class Has a propery called ordernumber whih is set to zero and methods oredr to increase the count incase an order is placed
And diplauy Order number to show the number of orders placed
Since this class extends the eventemitter class,It means we can use it to emit ad and listen to enets using th emit() and onmetods


const EventEmitter = require('node:events');



class Pizzashop extends EventEmitter{
    constructor(){
        super();
        this.ordernumber = 0
    }

    order(){
        this.ordernumber++
          }

    displayOrderNumber(){
        console.log(`Current oreder number :${this.ordernumber}`)
    }
}


module.exports = Pizzashop




Since this class extends the eventemitter class,It means we can use it to emit ad and listen to enets using th emit() and onmetods
Like this in the index,js file

index,.js


const Pizzashop = require('./pizzashop')

const pizzashop = new Pizzashop();

pizzashop.on("order",(size,topping)=>{               -->       Here we listen to that event and accept the arguements using our call back functionand use thos arguments
     console.log(`Hello Dennis Kimani, your pizza is ${size} with ${topping} as the topping `)


})

pizzashop.emit("order","large","mushrooms");  --> Here we emit an event called , order nad pass in two argument large and mushroom
pizzashop.displayOrderNumber()



the above will resuly in this.
The order is 0 since we have not called the order function



Hello Dennis Kimanil  your pizza is large with mushrooms as the topping 
Current oreder number :0










The order is 0 since we have not called the order function
We would like to change this, and emit the order event tin the order function
And since we will be emiting the order event in the order function, tha means we will need to recive the size and topping arguments, so that they can be passed on to the on() event lisner method
And if we do thiss, we will make an order and display the message





const EventEmitter = require('node:events');



class Pizzashop extends EventEmitter{
    constructor(){
        super();
        this.ordernumber = 0
    }

    order(size,toppings){
        this.ordernumber++
        this.emit("order",size,toppings)
    }

    displayOrderNumber(){
        console.log(`Current oreder number :${this.ordernumber}`)
    }
}


module.exports = Pizzashop




Then when we calle the order function , we pass in the argi=uments




const Pizzashop = require('./pizzashop')

const pizzashop = new Pizzashop();

pizzashop.on("order",(size,topping)=>{                                ---> Here we consume th arguments and listen to the ordr event.
     console.log("Hello Dennis Kimani"+size+" "+topping)


})

pizzashop.order("large","mushrooms");  --> Then when we calle the order function , we pass in the argi=uments and make an order

pizzashop.displayOrderNumber()




The result is this



Hello Dennis Kimanilarge mushrooms
Current oreder number :1 






























































































































































































































...
