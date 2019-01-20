const songService = require('../services/song');
module.exports = {
    async show(req, res) {
        const id = req.params.id;
        try {
            const song = await songService.getSongById(id);
            res.json(song);
        } catch (err) {
            res.json(err);
        }
    }
};