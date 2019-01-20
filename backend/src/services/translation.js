const lyricist = require('./lyricist');
const cloudTranslate = require('./cloudTranslate');

async function createTranslation(lyrics, numberOfTranslations = 1) {
    let currentText = lyrics;
    let translationSteps = [];
    for(let i = 0; i < numberOfTranslations; i++) {
        const language = await cloudTranslate.getRandomLanguage();
        currentText = await cloudTranslate.translateText(currentText, language.code);
        translationSteps.push({
            language: language.name,
            translation: currentText,
        });
    }
    return {
        translationSteps,
        finalTranslation: await cloudTranslate.translateText(currentText, 'en'),
    };
}

module.exports = {
    createTranslation
};