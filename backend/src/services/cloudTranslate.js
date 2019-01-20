const { Translate } = require('@google-cloud/translate');

const googleTranslate = new Translate({
    projectId: process.env.GOOGLE_PROJECT_ID,
});

let languagesCache = null;
async function getLanguages() {
    if (!languagesCache) {
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

async function translateText(text, targetLanguage = null) {
    if (!targetLanguage) {
        throw new Exception("Target language is required");
    }
    try {
        const results = await googleTranslate.translate(text, targetLanguage);
        return results[0];
    } catch (err) {
        console.error('ERROR:', err);
    }
}

async function getRandomLanguage() {
    const languages = await getLanguages();
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