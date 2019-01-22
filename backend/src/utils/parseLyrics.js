function parseLyrics(lyrics, removeAllNewLines = false) {
    return lyrics
        .replace(/\[.+\]/g, '')
        .replace(/^[(\n)]+/, '')
        .replace(/[(\n)]+/g, removeAllNewLines ? ' ' : '\n ');
}
module.exports = parseLyrics;