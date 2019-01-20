const ArtistModel = require('./ArtistModel');

function SearchResultModel(data) {
  this.id = data.result.id;
  this.title = data.result.title_with_featured;
  this.artist = new ArtistModel(data.result.primary_artist);
  this.image_url = data.result.header_image_thumbnail_url;
};

module.exports = SearchResultModel;