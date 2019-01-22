const parseLyrics = require('../utils/parseLyrics');
const SongModel = require('../models/SongModel');

function TranslationModel(data) {
    this.id = parseInt(data.id);
    this.song = new SongModel(data.song || data);
    this.stages = data.stages;
    this.languages = data.languages;
    this.original_lyrics = parseLyrics(data.lyrics);
    this.translated_lyrics = parseLyrics(data.translated_lyrics);
}

module.exports = TranslationModel;