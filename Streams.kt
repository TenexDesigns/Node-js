

A stream is a sequecnec of data that is being moved from one point to another over time


e.g A stream of data being transfered from one file to another within the same computer

 The idea is Work with data in chucks instead of waiting for the entire data to be available ata once

If you are transfering file contents from fileA to fileB, you dont wait for entire fileA content to be saved
in tempory memeory before moving it into fileB


Instead , the content is  transffered in chunks over time which prevents unncessary memery usage

Stream is infact a built-in node module that inherits from the event emitter class.
We rarelu use strreams directly
Other modules use streams for their functioning.






const fs = require("node:fs");

// This will enable us to read data in chucks fro file.txt
const readableStream = fs.createReadStream("./file.txt",{
    encoding :'utf-8',
    highWaterMark:2,
})

// Here we give the path to the file tat we are going to write to.
const writeableStream = fs.createWriteStream("./file2.txt")

//Streams extend from the emitter class
//So we can use the streams we created above to emit an event
// The read stream emits an event called "data" that we can listen to

// This reads the data in chucks, The default chuck size is 64 bytes, 
//But if we want to reduce that size, we can use    highWaterMark:2, where the number represent s bytsysze, This will  make the data be trand=ferebd from file.txt, to file2.txtx in chucnks of 2 bytes
readableStream.on('data',(chunck)=>{
    console.log(chunck)
    writeableStream.write(chunck)

})



This will write the datat from file.txtx to file2.txtx
Streams allow us to work with chucks of data rather than large amounts of data.










types of streams

Readable Streams - from which data can be read
Writeable streams  to which we can write data
Duplesx streams to which we can both write and read data
Transform streams - That can  modify or transform the data as it is written and read


EXAMPLES

Readable stream - Reading from a file
Writeable streams - writting to a file
Duplesx streams - sockets
Transform streams - File compressio  where you can write compressed data and read decompressed data to and from a file as a transform stream.








































































...
