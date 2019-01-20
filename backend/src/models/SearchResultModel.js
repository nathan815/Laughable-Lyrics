function SearchResultModel(data) {
  this.id = data.result.id;
  this.title = data.result.title_with_featured;
  this.artist = {
      id: data.result.primary_artist.id,
      name: data.result.primary_artist.name,
      url: data.result.primary_artist.url,
  };
  this.image_url = data.result.header_image_thumbnail_url;
};
module.exports = SearchResultModel;