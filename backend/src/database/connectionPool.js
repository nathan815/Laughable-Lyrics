const mysql = require('./mysql');

const pool = mysql.init();

module.exports = pool;