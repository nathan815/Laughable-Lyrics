const parseLyrics = require('../utils/parseLyrics');

function SongModel(song, removeAllNewLinesFromLyrics = false) {
    this.id = song.id;
    this.lyrics = parseLyrics(song.lyrics, removeAllNewLinesFromLyrics);
    this.title = song.title;
    this.release_date = song.release_date;
    this.media = typeof song.media === 'string' ? JSON.parse(song.media) : song.media;
};

module.exports = SongModel;