const GeniusApi = require('genius-api');
module.exports = new GeniusApi(process.env.GENIUS_API_ACCESS_TOKEN);