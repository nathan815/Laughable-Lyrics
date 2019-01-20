const genius = require('./genius');
const SearchResultModel = require('../models/SearchResultModel');

module.exports = {
  async search(query) {

    const hitMapper = (hit) => new SearchResultModel(hit);

    const hitFilter = (hit) => {
      return hit.type === 'song';
    };

    try {
      const response = await genius.search(query);
      return response.hits.filter(hitFilter).map(hitMapper);
    } catch (err) {
      throw new Exception("Error fetching search results from Genius. ", err);
    }

  }

};