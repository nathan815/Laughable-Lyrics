const translationService = require('../services/translation');
const songService = require('../services/song');

const MIN_STAGE_COUNT = 3;
const MAX_STAGE_COUNT = 10;

module.exports = {

  async index(req, res) {
    res.json();
  },

  async create(req, res) {
    const { songId, stages } = req.body;
    if(!songId) {
      res.status(422).json({
        error: 'songId field is required'
      });
    }
    if(!parseInt(stages) || stages < MIN_STAGE_COUNT || stages > MAX_STAGE_COUNT) {
      res.status(422).json({
        error: 'stages field not a number or not within limits'
      });
    }
    try {
      const song = await songService.getSongById(songId);
      const translation =
        await translationService.createTranslation(songId, song.lyrics, stages);
      res.json(translation);
    } catch (err) {
      console.log('ERR', err);
      res.status(500).send(err);
    }

  },

  async show(req, res) {
    const id = req.params.id;
    if(!id) {
      res.status(422).json({ error: 'ID is required '});
    }
    try {
      const translation = await translationService.getTranslationById(id);
      if(!translation) {
        res.status(404).json({ "error": "Translation not found "});
      }
      res.json(translation);
    } catch (err) {
      res.status(500).json(err);
    }
  },

};
