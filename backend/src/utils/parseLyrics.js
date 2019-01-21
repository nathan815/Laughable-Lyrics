function parseLyrics(lyrics, removeAllNewLines) {
    return lyrics
        .replace(/\[((Pre-)?Chorus|Verse|Bridge|Outro|OUTRO|Intro|INTRO)( [0-9]+)?]\]/g, '')
        .replace(/^[(\n)]+/, '')
        .replace(/[(\n)]+/g, removeAllNewLines ? ' ' : '\n ');
}
module.exports = parseLyrics;