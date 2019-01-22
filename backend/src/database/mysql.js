var mysql = require('mysql');

module.exports.init = function (configs = {}) {
    return mysql.createPool({
        host: process.env.DB_HOST || configs.host,
        user: process.env.DB_USER || configs.user,
        password: process.env.DB_PASS || configs.pass,
        connectionLimit: process.env.MYSQL_CONNECTION_LIMIT || configs.connectionLimit,
        database: process.env.DB_NAME || configs.database,
        debug: process.env.APP_DEBUG == "true"
    });
};