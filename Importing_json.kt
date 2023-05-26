When we import a json file in node js,
The json data is parsed or conveted to  a javascript object


data.json

{
    "name":"George Gacau",
    "home":"Beverly hills",
    "address":"califirnia"
}


index.json

const data = require('./data.json');

console.log(data);


the reult is this, which is a javascript object and not json. The reuire method convetrs the json data into javascript object

PS D:\node> node node.js
{ name: 'George Gacau', home: 'Beverly hills', address: 'califirnia' }
PS D:\node> 
































































































































...
