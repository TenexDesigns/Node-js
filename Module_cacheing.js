This is when a mudule exports a class and that class is instaciate when exported,
  --->any chages to it will be saved  
  
 superher.js

  class superhero{

    constructor(name){
        this.name = name
    }

    getname(params) {
        return this.name
        
    } 
    setname(value) {
        return this.name = value
        
    }



}


module.exports = new superhero("Batman");









index.js

const superhero = require('./supre-hero')

console.log(superhero.getname())
console.log("Hello George Gaac");
superhero.setname("Superman");
console.log(superhero.getname())


const  newsuperhero = require('./supre-hero')
console.log(newsuperhero.getname())







the result -->


PS D:\node> node node.js
Batman
Hello George Gaac
Superman
Superman                       ..Here we print superman twice because of mdel caching



TO AVOID THIS, JUST EXPORT THE CLASS IN THE SUPERHER FILE, AND EVERY NEW INSTACE CREATED OF THAT CLASS WILL BE A DIFFREENT CLASS



  
 superher.js

  class superhero{

    constructor(name){
        this.name = name
    }

    getname(params) {
        return this.name
        
    } 
    setname(value) {
        return this.name = value
        
    }



}


module.exports = superhero;







index.js

const superhero = require('./supre-hero')

const batman = new superhero("Batman");
console.log(batman.getname())
batman.setname("Bruce wayne");
console.log(batman.getname())


const superman = new superhero("Superman");
console.log(superman.getname())






the result -->


PS D:\node> node node.js
Batman
Bruce wayne
Superman   























































































...
