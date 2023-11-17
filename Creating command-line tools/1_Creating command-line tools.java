Creating command-line tools with Node.js involves a few key steps. Here's a basic guide to get you started:

1. **Initialize Your Project:**

   Create a new directory for your project and navigate into it using the terminal. Run the following command to initialize a new Node.js project:

   ```bash
   npm init -y
   ```

   This creates a `package.json` file with default values.

2. **Create Your Script:**

   Write your command-line script using JavaScript or TypeScript. For example, create a file named `cli.js`:

   ```javascript
   # cli.js

   // This is a simple example
   console.log('Hello, Command Line!');
   ```

3. **Handle Command-Line Arguments:**

   You can use the `process.argv` array to access command-line arguments. For more advanced argument parsing, consider using libraries like `yargs` or `commander`. Install them using:

   ```bash
   npm install yargs
   ```

   Here's a simple example using `yargs`:

   ```javascript
   # cli.js

   const yargs = require('yargs');

   const argv = yargs
     .command('greet', 'Greet the user', {}, (argv) => {
       console.log(`Hello, ${argv.name || 'World'}!`);
     })
     .help()
     .argv;
   ```

   Now you can run your script with:

   ```bash
   node cli.js greet --name=John
   ```

4. **Make the Script Executable:**

   You can make your script executable by adding a shebang line at the top of your script file:

   ```javascript
   #!/usr/bin/env node
   ```

   This allows you to run your script directly from the command line:

   ```bash
   ./cli.js greet --name=John
   ```

5. **Install Globally:**

   If you want to use your tool globally, you can publish it to npm or install it globally on your machine:

   ```bash
   npm install -g .
   ```

   Now, you can use your tool from any directory:

   ```bash
   my-cli-tool greet --name=John
   ```

   Note: The `-g` flag installs the tool globally.

6. **Testing:**

   It's essential to test your command-line tool. You can use testing libraries like `mocha` or `jest` for this purpose.

   Install a testing library:

   ```bash
   npm install --save-dev mocha
   ```

   Create a `test` directory and write your tests.

   ```bash
   mkdir test
   ```

   For example:

   ```javascript
   # test/cli.test.js

   const assert = require('assert');
   const { execSync } = require('child_process');

   describe('CLI', () => {
     it('should greet the user', () => {
       const output = execSync('node cli.js greet --name=John').toString();
       assert.strictEqual(output.trim(), 'Hello, John!');
     });
   });
   ```

   Run tests:

   ```bash
   npm test
   ```

That's a basic outline of creating a simple command-line tool with Node.js. Depending on your tool's complexity, you might need additional libraries or frameworks.



     ......
