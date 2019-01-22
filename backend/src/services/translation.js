const cloudTranslate = require('./cloudTranslate');
const translationStore = require('../stores/translation.store');
const TranslationModel = require('../models/TranslationModel');
const SongModel = require('../models/SongModel');
const parseLyrics = require('../utils/parseLyrics');
const sleep = require('../utils/sleep');

async function createTranslation(song, steps = 1) {
    // generate random languages
    const languages = [];
    for (let i = 0; i < steps; i++) {
        const language = await cloudTranslate.getRandomLanguage();
        languages.push(language);
    }

    let currentText = song.lyrics;
    let prevLang = null;
    let translationSteps = [];

    // translate the lyrics to each language
    for (let language of languages) {
        currentText = await cloudTranslate.translateText(parseLyrics(currentText), {
            from: prevLang ? prevLang.code : null,
            to: language.code
        });
        prevLang = language;
        translationSteps.push({
            language: language,
            translation: currentText
        });
        await sleep(1000);
    }

    const finalTranslation = await cloudTranslate.translateText(currentText, { to: 'en' });
    const languagesString = languages.reduce((arr, curr) => {
        arr.push(curr.name);
        return arr;
    }, []).join(',');

    const translation = new TranslationModel({
        stages: steps,
        languages: languagesString,
        lyrics: song.lyrics,
        translated_lyrics: finalTranslation,
        song: song,
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