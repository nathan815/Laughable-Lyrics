const cloudTranslate = require('./cloudTranslate');
const translationStore = require('../stores/translation.store');
const TranslationModel = require('../models/TranslationModel');

async function createTranslation(songId, lyrics, numberOfTranslations = 1) {
    let currentText = lyrics;
    let translationSteps = [];
    const languages = [];
    console.log('creating translation for song '+songId+'...');
    for(let i = 0; i < numberOfTranslations; i++) {
        const language = await cloudTranslate.getRandomLanguage();
        console.log('lang',language);
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
        languages,
        originalLyrics: lyrics,
        translatedLyrics: finalTranslation,
    });
    // console.log('pre-create translation db', translation);
    const result = await translationStore.createTranslation(translation);
    translation.id = result.insertId;
    console.log('created translation', translation);
    return translation;
}

module.exports = {
    createTranslation
};