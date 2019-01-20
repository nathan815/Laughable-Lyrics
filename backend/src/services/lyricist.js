const Lyricist = require('lyricist');
const lyricist = new Lyricist(process.env.GENIUS_API_ACCESS_TOKEN);
module.exports = lyricist;