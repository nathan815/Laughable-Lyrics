const db = require('../database/connectionPool');

module.exports = {
    async createTranslation(translationModel) {
        return new Promise(function (resolve, reject) {
            const sql = `INSERT INTO translations 
                        ( song_id, stages, languages, translated_lyrics ) 
                        VALUES ( ?, ?, ?, ? )`;
            const { song_id, stages, languages, translated_lyrics } = translationModel;
            const result = db.query(sql, [
                song_id, stages, languages, translated_lyrics
            ], function (err, result) {
                if(err) {
                    reject(err);
                }
                resolve(result);
            });
            return result;
        });
    },
    async getTranslationById(id) {
        console.log('getTranslationById',id);
        return new Promise(function (resolve, reject) {
            const sql = `SELECT translations.*, songs.id as song_id, songs.title, 
                            songs.lyrics, songs.release_date, songs.media
                        FROM translations 
                        JOIN songs ON songs.id = translations.song_id
                        WHERE translations.id = ?`;
            const result = db.query(sql, [ id ], function (err, result) {
                if(err) {
                    reject(err);
                }
                console.log(result);
                resolve(result);
            });
            return result;
        });
    }
}