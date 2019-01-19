import genius from '../services/genius';

module.exports = {

  async index(req, res) {
    const query = req.query.q;
    
    try {
      const response = await genius.search(query)
      return res.json(response);
    } catch(err) {
      return res.status(500).json(err);
    }

  }

};
