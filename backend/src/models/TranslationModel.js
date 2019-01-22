const parseLyrics = require('../utils/parseLyrics');
const SongModel = require('../models/SongModel');

function TranslationModel(data) {
    this.id = data.id;
    this.song = new SongModel(data);
    this.stages = data.stages;
    this.languages = data.languages;
    this.translated_lyrics = parseLyrics(data.translated_lyrics);
}

module.exports = TranslationModel;