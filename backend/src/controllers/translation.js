const translationService = require('../services/translation');
const songService = require('../services/song');

module.exports = {

  async index(req, res) {
    res.send('test');
  },

  async create(req, res) {
    const { songId } = req.body;
    res.send(id);
  },

  async song(req, res) {
    const id = req.params.id;
    try {
      const song = await songService.getSongById(id);
      res.json(song);
    } catch(err) {
      res.json(err);
    }
  }

};
