const genius = require('./genius');

module.exports = {
  async search(query) {

    const hitMapper = (hit) => ({
      id: hit.result.id,
      title: hit.result.title_with_featured,
      artist: {
        id: hit.result.primary_artist.id,
        name: hit.result.primary_artist.name,
        url: hit.result.primary_artist.url,
      },
      image_url: hit.result.header_image_thumbnail_url,
    });
  
    const hitFilter = (hit) => {
      return hit.type === 'song';
    };
  
    try {
      const response = await genius.search(query);
      return response.hits.filter(hitFilter).map(hitMapper);
    } catch(err) {
      throw new Exception("Error fetching search results from Genius. ", err);
    }

  }

};