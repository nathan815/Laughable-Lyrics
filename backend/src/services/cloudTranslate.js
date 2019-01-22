const { Translate } = require('@google-cloud/translate');

const googleTranslate = new Translate({
    projectId: process.env.GOOGLE_PROJECT_ID,
});

async function translateText(text, options) {
    try {
        const results = await googleTranslate.translate(text, options);
        return results[0];
    } catch (err) {
        console.error('Translation ERROR:', err);
    }
}

let languagesCache = null;
async function getLanguages() {
    if (!languagesCache) {
        console.log('languages cache empty, requesting from google');
        languagesCache = {};
        const [languages] = await googleTranslate.getLanguages();
        for (const key in languages) {
            if (languages.hasOwnProperty(key)) {
                const lang = languages[key];
                languagesCache[lang.code] = lang;
            }
        }
    }
    return languagesCache;
}

async function getRandomLanguage() {
    const languages = await getLanguages();
    delete languages.en;
    const languageCodes = Object.keys(languages);
    const randomLangCode = languageCodes[Math.round(Math.random() * (languageCodes.length - 1))];
    return languages[randomLangCode];
}

async function getLanguage(code) {
    const languages = await getLanguages();
    return languages[code];
}

module.exports = {
    translateText,
    getRandomLanguage,
    getLanguage
};