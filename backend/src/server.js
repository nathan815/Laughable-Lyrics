const express = require('express');
const bodyParser = require('body-parser');
const expressValidator = require('express-validator');
const dotenv = require('dotenv');

const app = express();
dotenv.load();

const port = process.env.SERVER_PORT;

require('./routes')(app);

app.use(bodyParser.json());
app.use(expressValidator);

app.listen(port, function() {
  console.log(`Server running at http://localhost:${port}`);
});
