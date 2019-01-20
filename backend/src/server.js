const express = require('express');
const bodyParser = require('body-parser');
const expressValidator = require('express-validator');
const dotenv = require('dotenv');

const app = express();
dotenv.load();

app.use(bodyParser.json());

require('./routes')(app);

const port = process.env.HTTP_PORT;
const url = process.env.APP_URL;
app.listen(port, function() {
  console.log(`Server now running at ${url}:${port}`);
});
