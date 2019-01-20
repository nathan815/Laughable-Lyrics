function parseLyrics(lyrics, removeAllNewLines) {
    return lyrics
        .replace(/\[((Pre-)?Chorus|Verse)( [0-9]+)?]/g, '')
        .replace(/^[(\n)]+/, '')
        .replace(/[(\n)]+/g, removeAllNewLines ? ' ' : '\n ');
}

function SongModel(song, removeAllNewLinesFromLyrics = false) {
    this.id = song.id;
    this.lyrics = parseLyrics(song.lyrics, removeAllNewLinesFromLyrics);
    this.title = song.title;
    this.release_date = song.release_date;
    this.media = JSON.parse(song.media);
};

module.exports = SongModel;