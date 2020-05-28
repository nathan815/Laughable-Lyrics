package fonte.com.laughablelyricsandroid.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fonte.com.laughablelyricsandroid.R
import fonte.com.laughablelyricsandroid.util.LyricResponse
import fonte.com.laughablelyricsandroid.util.SearchResult
import kotlinx.android.synthetic.main.main_activity.*
import org.json.JSONObject
import java.net.URLEncoder
import java.util.*

class MobileRequestService {

    fun searchRequest(queryParams: String, context: Context): MutableLiveData<ArrayList<SearchResult>> {
        val result: MutableLiveData<ArrayList<SearchResult>> = MutableLiveData()
        val queue = Volley.newRequestQueue(context)
        val url = "http://10.0.0.177:1337/search?q=${URLEncoder.encode(queryParams, "utf-8")}"

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                Log.d(LOG_TAG, "Response: %s".format(response.toString()))
                val searchResults: ArrayList<SearchResult> = arrayListOf()
                for (i in 0 until response!!.length()) {
                    val searchResult = SearchResult(
                        response.getJSONObject(i).get("title").toString(),
                        response.getJSONObject(i).getJSONObject("artist").get("name").toString(),
                        response.getJSONObject(i).get("id").toString(),
                        response.getJSONObject(i).get("image_url").toString()
                    )
                    searchResults.add(searchResult)
                }
                result.value = searchResults
            },
            Response.ErrorListener { error ->
                Log.e(LOG_TAG, error.toString())
            }
        )
        queue.add(jsonArrayRequest)
        return result
    }

    fun getLyrics(songId: Int, numBounces: Int, context: Context): MutableLiveData<LyricResponse> {
        val result: MutableLiveData<LyricResponse> = MutableLiveData()
        val queue = Volley.newRequestQueue(context)
        val url = "http://10.0.0.177:1337/translations"


        val params = HashMap<String, Int>()
        params["songId"] = songId
        params["stages"] = numBounces
        val parameters = JSONObject(params)
        val jsonArrayRequest = JsonObjectRequest(Request.Method.POST, url, parameters,
            Response.Listener { response ->
                Log.d(LOG_TAG, "Response: %s".format(response.toString()))
                result.value = LyricResponse(
                    response.get("original_lyrics").toString(),
                    response.get("translated_lyrics").toString()
                )
            },
            Response.ErrorListener { error ->
                Log.e(LOG_TAG, error.toString())
            }
        )
        queue.add(jsonArrayRequest)
        return result
    }

    companion object {
        private val LOG_TAG: String = MobileRequestService::class.java.name

        @Volatile
        private var instance: MobileRequestService? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: MobileRequestService().also { instance = it }
            }
    }
}