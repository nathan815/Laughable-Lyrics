const GeniusApi = require('genius-api');
const genius = new GeniusApi(process.env.GENIUS_API_ACCESS_TOKEN);
module.exports = genius;