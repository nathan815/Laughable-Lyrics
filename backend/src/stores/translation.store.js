const db = require('../database/connectionPool');

module.exports = {
    async createTranslation(translationModel) {
        return new Promise(function (resolve, reject) {
            const sql = `INSERT INTO translations 
                        ( song_id, stages, languages, original_lyrics, translated_lyrics ) 
                        VALUES ( ?, ?, ?, ?, ? )`;
            const { songId, stages, languages, originalLyrics, translatedLyrics } = translationModel;
            const result = db.query(sql, [
                songId, stages, languages.join(','), originalLyrics, translatedLyrics
            ], function (err, result) {
                if(err) {
                    reject(err);
                }
                resolve(result);
            });
            return result;
        });
    }
}