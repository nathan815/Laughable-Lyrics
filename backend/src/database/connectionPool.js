const mysql = require('./mysql');

const pool = mysql.init();

pool.query("SELECT 1 + 1 AS solution", function(err, rows, fields) {
    if (err) throw err;
    console.log('The solution is: ', rows[0].solution);
 })

module.exports = pool;