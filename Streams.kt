

A stream is a sequecnec of data that is being moved from one point to another over time


e.g A stream of data being transfered from one file to another within the same computer

 The idea is Work with data in chucks instead of waiting for the entire data to be available ata once

If you are transfering file contents from fileA to fileB, you dont wait for entire fileA content to be saved
in tempory memeory before moving it into fileB


Instead , the content is  transffered in chunks over time which prevents unncessary memery usage

Stream is infact a built-in node module that inherits from the event emitter class.
We rarelu use strreams directly
Other modules use streams for their functioning.


+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Streams are a fundamental concept in Node.js, representing asynchronous flow of data.
They are used to handle reading and writing files or exchanging information efficiently.
There are four types of streams in Node.js: readable, writable, duplex, and transform streams medium.com, section.io.

Readable streams: 
These streams can read data from a particular data source, such as a file system or user input 
via stdin in a terminal application. They emit events like 'data' and 'end' when data is available or when the stream
is finished blog.appsignal.com.

Writable streams:
These streams can write data to a destination. They emit events like 'data', 'end', and 'error' when data
is written or when an error occurs section.io.

Duplex streams: 
These streams can be used for both reading and writing operations. They can be used in scenarios like
a TCP server that needs to handle incoming and outgoing data section.io.

Transform streams: 
These streams are a type of duplex stream where the output is computed based on the input. 
They are commonly used for data manipulation, compression, and decompression section.io.

Streams are useful in various scenarios, such as handling large files, exchanging data between client and server,
and processing data in chunks, which helps reduce memory usage and improve performance blog.appsignal.com.
However, its important to note that using streams can increase the complexity of your application,
so make sure the benefits outweigh the added complexity blog.appsignal.com.
 
 
 
 
 
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 


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



PIPES
*****************************************************************************************************************
 
 
 tank            pipe
  |-------------------------|
                            |
                            Tap
 
 We are reading water from the tank and writin g it in the tap,
In node js pipes are very similar.
It takes a readable stream and connects it to a writeadle stram
We use the pipe method on a readable stream to implement the functionality
 
 
 
Pipe are a more efficnt way to 



const fs = require("node:fs");

const readableStream = fs.createReadStream("./file.txt",{
    encoding :'utf-8',
    highWaterMark:2,
})

const writeableStream = fs.createWriteStream("./file2.txt")

readablestream.pipe(writeableStream)  // This will write the data in file.txtx to file2.txt

A pipe retunrs a destination stream whicl allows chaning. The condintio for this is that The destination stream has to be readable,duplex  or a transform stream
The destination stream has to be readable,duplex  or a transform stream


In our above stream, readablestream.pipe(writeableStream), we have writeable stream , so we can not chain it by calling writeable.pipe

Let us change the implemention for above and use another build in module called zlib, for compressin files and turning them into zip files

CHAINGING WITH THE PIPE METHOD

const fs = require("node:fs");
const zlib = require('node:zlib')  // Provideds compressin functionality implemented by the gzlip algorithm
//zlib allows us to creat zip files
//zlib has the built in transform stream


const gzip = zlib.createGzip()



// This will enable us to read data in chucks fro file.txt
const readableStream = fs.createReadStream("./file.txt",{
    encoding :'utf-8',
})


readableStream.pipe(gzip)//This returns a transform stream so we can call .pipe and pass in fs.writestream('./destiantion to write the fie')
readableStream.pipe(gzip).pipe(fs.WriteStream('./file2.txt.gz'))  
// We are chaing with .pipe
//moving from readable stream to transform stram to a writeable stream









CHAINING PIPES


Pipes in Node.js are used to connect multiple streams together, allowing data to flow from one stream to another.
This is particularly useful for transferring data between files, compressing and decompressing files,
and implementing inter-process communication between Node.js and other languages like Python.
The pipe method is the recommended way to consume streams, as it abstracts away the need to handle events and provides a clean and efficient way to pass data between streams guru99.com, javatpoint.com, mariokandut.com, freecodecamp.org.

Heres an example of piping and chaining streams using the pipe method:

const fs = require('fs');
const zlib = require('zlib');

const input = fs.createReadStream('input.txt');
const output = fs.createWriteStream('input.txt.gz');

const compressor = zlib.createGzip();
const decompressor = zlib.createGunzip();

input.pipe(compressor).pipe(output);

output.on('finish', () => {
  console.log('Compression complete.');
});
In this example, the input.txt file is compressed using the zlib library and the compressed data is written to 
a new file named input.txt.gz. The pipe method is used to connect the input stream to the compressor stream and 
then to the output stream. The finish event is emitted when the compression is complete,
and the decompression can be done similarly javatpoint.com.

You can also chain multiple pipe calls together, as shown in this example:

readableSrc
  .pipe(transformStream1)
  .pipe(transformStream2)
  .pipe(finalWritableDest);
This is equivalent to chaining the streams together using the | operator in a Unix-like shell freecodecamp.org.

Its important to note that the pipe method should be used with streams that implement a Readable interface,
and the destination stream must implement a Writable interface. You can chain multiple pipe calls together
for more complex data manipulation and processing mariokandut.com, freecodecamp.org.

Using the pipe method is beneficial because it allows you to handle data in smaller chunks,
preventing memory issues and maintaining good performance in your applications. The code is shorter, elegant, and easy to follow




















































...
