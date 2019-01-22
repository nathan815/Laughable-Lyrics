const cloudTranslate = require('./cloudTranslate');
const translationStore = require('../stores/translation.store');
const TranslationModel = require('../models/TranslationModel');

async function createTranslation(songId, lyrics, steps = 1) {
    // generate random languages
    const languages = [];
    for(let i = 0; i < steps; i++) {
        const language = await cloudTranslate.getRandomLanguage();
        languages.push(language);
    }

    let currentText = lyrics;
    let translationSteps = [];

    // translate the lyrics to each language
    for(let language of languages) {
        currentText = await cloudTranslate.translateText(currentText, language.code);
        translationSteps.push({
            language: language.name,
            translation: currentText,
        });
    }

    const finalTranslation = await cloudTranslate.translateText(currentText, 'en');
    const languagesString = languages.reduce((arr, curr) => {
        arr.push(curr.name);
        return arr;
    }, []).join(',');

    const translation = new TranslationModel({
        song_id: songId,
        stages: steps,
        languages: languagesString,
        original_lyrics: lyrics,
        translated_lyrics: finalTranslation,
    });

    const result = await translationStore.createTranslation(translation);
    translation.id = result.insertId;
    return translation;
}

async function getTranslationById(id) {
    const result = await translationStore.getTranslationById(id);
    return new TranslationModel(result[0]);
}

module.exports = {
    createTranslation,
    getTranslationById
};