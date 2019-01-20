const searchService = require('../services/search');

module.exports = {

  async index(req, res) {
    const term = req.query.q;

    try {
      const response = await searchService.search(term);
      return res.json(response);
    } catch(err) {
      return res.status(500).json(err);
    }

  }

};
