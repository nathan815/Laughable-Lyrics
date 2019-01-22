function parseLyrics(lyrics, removeAllNewLines) {
    return lyrics
        .replace(/\[.+\]/g, '')
        .replace(/^[(\n)]+/, '')
        .replace(/[(\n)]+/g, removeAllNewLines ? ' ' : '\n ');
}
module.exports = parseLyrics;