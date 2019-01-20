function TranslationModel(data) {
    this.id = data.id;
    this.songId = data.songId;
    this.languages = data.languages;
    this.originalLyrics = data.originalLyrics;
    this.translatedLyrics = data.translatedLyrics;
}

module.exports = TranslationModel;