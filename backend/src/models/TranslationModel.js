const parseLyrics = require('../utils/parseLyrics');

function TranslationModel(data) {
    this.id = data.id;
    this.song_id = parseInt(data.songId);
    this.stages = data.stages;
    this.languages = data.languages;
    this.original_lyrics = parseLyrics(data.originalLyrics);
    this.translated_lyrics = data.translatedLyrics;
}

module.exports = TranslationModel;