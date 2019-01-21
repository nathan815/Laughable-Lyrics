const lyricist = require('./lyricist');
const SongModel = require('../models/SongModel');
const songStore = require('../stores/song.store');
       
module.exports = {
    async getSongById(id) {
        let song = await songStore.getSongById(id);
        if(song == null) {
            song = await lyricist.song(id, { fetchLyrics: true });
            songStore.createSong(new SongModel(song));
        }
        return new SongModel(song);
    },
};