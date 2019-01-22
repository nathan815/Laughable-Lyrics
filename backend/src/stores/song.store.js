const db = require('../database/connectionPool');
const SongModel = require('../models/SongModel');

module.exports = {
    async createSong(songModel) {
        return new Promise(function (resolve, reject) {
            const sql = `INSERT INTO songs 
                        ( id, title, artist, lyrics, media, release_date ) 
                        VALUES ( ?, ?, ?, ?, ?, ? )`;
            const { id, lyrics, artist, title, release_date, media } = songModel;
            //console.log(songModel);
            const result = db.query(sql, [
                id, title, artist, lyrics, JSON.stringify(media), release_date
            ], function (err, result) {
                if (err) {
                    reject(err);
                }
                resolve(result);
            });
            return result;
        });
    },
    async getSongById(id) {
        return new Promise(function (resolve, reject) {
            const sql = `SELECT * FROM songs WHERE id = ?`;
            const result = db.query(sql, [id], function (err, results) {
                if (err) {
                    reject(err);
                }
                resolve(results[0] ? new SongModel(results[0]) : null);
            });
            return result;
        });
    }
}