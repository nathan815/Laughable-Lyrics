const parseLyrics = require('../utils/parseLyrics');

function TranslationModel(data) {
    this.id = data.id;
    this.song_id = parseInt(data.song_id);
    this.stages = data.stages;
    this.languages = data.languages;
    this.original_lyrics = parseLyrics(data.original_lyrics);
    this.translated_lyrics = parseLyrics(data.translated_lyrics);
}

module.exports = TranslationModel;