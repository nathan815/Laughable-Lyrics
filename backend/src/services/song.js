const lyricist = require('./lyricist');

module.exports = {
    async getSongById(id) {
        const song = await lyricist.song(id, { fetchLyrics: true });
        console.log('song',song);
        return song;
    },
}