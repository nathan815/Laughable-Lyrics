import express from 'express';
import bodyParser from 'body-parser';
import expressValidator from 'express-validator';
import dotenv from 'dotenv';

const app = express();
dotenv.load();

const port = process.env.SERVER_PORT;

require('./app/routes')(app);

app.use(bodyParser.json());

app.listen(port, function() {
  console.log(`Server running at http://localhost:${port}`);
});
