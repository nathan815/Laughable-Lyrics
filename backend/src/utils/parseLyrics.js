function parseLyrics(lyrics, removeAllNewLines = false) {
    return lyrics ? 
        lyrics
            .replace(/\[.+\]/g, '')
            .replace(/^[(\n)]+/, '')
            .replace(/[(\n)]+/g, removeAllNewLines ? ' ' : '\n')
        : '';
}
module.exports = parseLyrics;