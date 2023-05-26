
To understand what is a character set , first, we need to understand what is binary data


BINARY DATA

Computers store and represent data in binary format, which is a collection of 0s and 1s

Each 0 or 1 is called a binary digit or bit for shrt

To work with a piece of data, a computer needs to convert the data into its binary representation


decimal              Binary
1                    1
2                    10
3                    11
4                    100
5                    101
6                    110
7                    111
8                    1000
9                    1001
10                   1010


To work with a piece of data, a computer needs to convert the data into its binary representation
4  ----> 100

1               0           0
2^2*1         2^1*0        2^0*0
  4      +     0       +    0         = 4




Numbers are not the only data type we work with, Strings are some other data type
How will a computer represent a charcter in binary format


v---> How will a computer represent v

Computers will first convert the character to a number, then convert that number to its binarry representtion

Computers will first convert V to a number that represents v, then convert that number to binary

86 is the numeric represenation of the character V
It is also called character code

How does a computer know that 86 represnet V,






1.CHARACTER SETS


Character sets are predefined lists of characters represented by numbers.



Porpular character sets ---> UNICODE and ASCIII



UNICODE - Says that 86 is V







2.CHARACTER  ENCODING

Character encoding dictates how to represent a number in a character set as binary data before it can be stored in a computer.
It dictates how many bits to use to represent the number of the character

Example of  a character encoding system is UTF-8

UTF-8 states that characters should be encoded in bytes(8 bits)
e.g

4 => 100 => 00000100
V => 86  => 01010110








Simmilar Guidlines existe on how, images and videos should be stored in binary format.













STEAMS


A stream is a sequence of data that is being moved from one point to another over time

e.g a stream of data over the internet being moved from one computer to another

e.g a stream of data being transffered from one file to another within the same computer

IN NODE JS

STREAM CONT

The idea is to
process streams of data in chuncks as they arrive , instead of waiting for the entire data to be available, te starting to process it after all of it has arrived

example-1
This is best seen when watching a video on youtube, you dont wait for the entire video to be downloaded to watch it.
The data arrives in chunks and you watch in chunks while the rest of the data arrives over time.

example -2
Tranfefering  file contents from file A to file B
The contents arrive in chunks and you transfer in chunks while the remaining contents arrive over time.


Doing this prevents unnecssary data downloads and memeory usage.





but how is that steam of data moved. That brings us to something called buffers


BUFFERS

An amuzement park scenario

A rollercoster has a setting capacity of 30 peopele

SCENARIO 1
100 peope arrive
30 Peopele are accomaodated
70 people wait in queue.


SCENARIO 2

1 - Person arravies 
They  have to wait for atleast 10 peopel


THE UNDELING CONCEPT BEING, YOU CAN NOT COTROLL THE AMOUNT OF PEOPEL ARRIVING,thwy may come many 100 ata a time
or few, one at a time

But what you can control is how many peopel get dispached on the roller coster
when is the right time to let people on the ride

A maximum of 30  - and therest of the people have to wait, e.g the 70 people, when 100 people arrive at a time
and a minimun of 10.  - And that one person who arrives has to wait for other nine people to arrive for the miinimn of 10 to be reached and the ride can begin


THIS AREA THAT PEOPE WAIT is called the BUFFER



BUFFER cont
Node js can not control the pace at which data arrives in the steam

It can only decide when is the right time to send the data for processing

If there is data already processed or too little to process, node  puts the arriving data in a buffer.

It is an intentioaly small area that node maintains in the run timeto process stream of adat.




e.g 
Steraming video online

If your connection is slow, after processing the first chunk of data that arrived, the video player will display a loading spinner which indicate it is waiting for more data to arrive
Once the buffer  is filled up, and the data  processd, the video player shows the video.
While the video is playing , more data will continue toa arrive and wait in the buffer..






What is the connection between character sets, charcter encoding, stream and buffers


IN NODE JS , BUFFER IS A GLOBAL OBJECT WHICH WE CAN USE WITHOUT IMPORTING


const buffer = new Buffer.from("George","utf-8")   ; - This from metho accepts a string and a chacter encoding format.





const buffer = new Buffer.from("George")

console.log(buffer.toJSON());


THE RESULT IS 

{ type: 'Buffer', data: [ 86, 105, 107, 105, 110, 103 ] }

This result is a UNICode, utf-8 character represntaion of the word Viking






HOW EVER IF WE WITE ONLY BUFFER IN THE CONSOE
We see the binary represnetion of the wor viking,
But using binary can sometimes flood your terminal, SO instead, The format used is Hexadecimal


const buffer = new Buffer.from("Viking")



The result
This is a Hexadecimal represntion of the binary of the word Vikings

<Buffer 56 69 6b 69 6e 67>





console.log(buffer.toString());  --> Prints Viking , Convets the buffer to  string




















...
