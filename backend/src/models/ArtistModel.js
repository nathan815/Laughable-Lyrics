function ArtistModel(artist) {
    this.id = artist.id;
    this.name = artist.name;
    this.genius_url = artist.url;
    this.image_url = artist.image_url;
}
module.exports = ArtistModel;