const translationService = require('../services/translation');
const songService = require('../services/song');
const SongModel = require('../models/SongModel');

const MAX_STAGE_COUNT = 5;

module.exports = {

  async index(req, res) {
    res.json();
  },

  async create(req, res, next) {
    let { songId, stages } = req.body;
    if(!songId) {
      res.status(422).json({
        error: 'songId field is required'
      });
    }
    stages = stages && stages < MAX_STAGE_COUNT ? stages : 2;
    try {
      const song = await songService.getSongById(songId);
      console.log('song:',song);
      const translation =
        await translationService.createTranslation(song, stages);
      res.send(translation);
    } catch (err) {
      res.status(404).send({ error: err.toString() });
    }

  },

  async show(req, res, next) {
    const id = req.params.id;
    if(!id) {
      res.status(422).send({ error: 'ID is required '});
    }
    try {
      const translation = await translationService.getTranslationById(id);
      if(!translation) {
        res.status(404).send({ "error": "Translation not found "});
      }
      res.json(translation);
    } catch (err) {
      next(err);
    }
  },

};
