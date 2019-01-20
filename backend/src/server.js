const express = require('express');
const bodyParser = require('body-parser');
const dotenv = require('dotenv');

dotenv.load();

const app = express();

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

require('./routes')(app);

const port = process.env.HTTP_PORT;
const url = process.env.APP_URL;
app.listen(port, function() {
  console.log(`Server now running at ${url}:${port}`);
});
