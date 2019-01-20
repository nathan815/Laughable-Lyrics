const searchService = require('../services/search');

module.exports = {

  async index(req, res) {
    const term = req.query.q;

    try {
      const response = await searchService.search(term);
      res.json(response);
    } catch(err) {
      res.status(500).json(err);
    }

  }

};
