const lyricist = require('./lyricist');
const SongModel = require('../models/SongModel');

module.exports = {
    async getSongById(id) {
        const song = await lyricist.song(id, { fetchLyrics: true });
        return new SongModel(song);
    },
};