package fonte.com.laughablelyricsandroid.util



data class SearchResult(
    var Title: String,
    var Artist: String?,
    var Id: String?,
    var ImageUrl: String?
)

data class LyricResponse(
    var Original: String?,
    var Translated: String?
)