const cloudTranslate = require('./cloudTranslate');
const translationStore = require('../stores/translation.store');
const TranslationModel = require('../models/TranslationModel');

async function createTranslation(songId, lyrics, numberOfTranslations = 1) {
    let currentText = lyrics;
    let translationSteps = [];
    const languages = [];
    for(let i = 0; i < numberOfTranslations; i++) {
        const language = await cloudTranslate.getRandomLanguage();
        currentText = await cloudTranslate.translateText(currentText, language.code);
        translationSteps.push({
            language: language.name,
            translation: currentText,
        });
        languages.push(language.name);
    }
    const finalTranslation = await cloudTranslate.translateText(currentText, 'en');
    const translation = new TranslationModel({
        songId,
        stages: numberOfTranslations,
        languages: languages.join(','),
        originalLyrics: lyrics,
        translatedLyrics: finalTranslation,
    });
    const result = await translationStore.createTranslation(translation);
    translation.id = result.insertId;
    return translation;
}

async function getTranslationById(id) {
    const result = await translationStore.getTranslationById(id);
    return result[0];
}

module.exports = {
    createTranslation,
    getTranslationById
};