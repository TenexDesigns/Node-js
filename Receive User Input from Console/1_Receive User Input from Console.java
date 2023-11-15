import readline from 'readline';

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question('What is your number? ', (answer) => {
  const num = parseInt(answer);
  if (!isNaN(num)) {
    console.log(num % 10);
  } else {
    console.log('Please enter a valid number');
  }
  rl.close();
});



....
