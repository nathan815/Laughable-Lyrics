const db = require('../database/connectionPool');

module.exports = {
    async createSong(songModel) {
        return new Promise(function (resolve, reject) {
            const sql = `INSERT INTO songs 
                        ( id, title, lyrics, media, release_date ) 
                        VALUES ( ?, ?, ?, ?, ? )`;
            const { id, lyrics, title, release_date, media } = songModel;
            //console.log(songModel);
            const result = db.query(sql, [
                id, title, lyrics, JSON.stringify(media), release_date
            ], function (err, result) {
                if(err) {
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
            const result = db.query(sql, [ id ], function (err, results) {
                if(err) {
                    reject(err);
                }
                resolve(results[0] || null);
            });
            return result;
        });
    }
}