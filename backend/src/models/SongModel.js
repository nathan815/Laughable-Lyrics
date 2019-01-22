const parseLyrics = require('../utils/parseLyrics');

function SongModel(song) {
    if(!song || song instanceof SongModel) {
        return song;
    }
    this.id = parseInt(song.song_id || song.id);
    this.title = song.title;
    this.artist = song.artist;
    this.lyrics = parseLyrics(song.lyrics);
    this.release_date = song.release_date;
    this.media = typeof song.media === 'string' ? JSON.parse(song.media) : song.media;
};

module.exports = SongModel;