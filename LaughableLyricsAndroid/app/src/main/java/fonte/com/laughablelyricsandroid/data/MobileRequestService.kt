package fonte.com.laughablelyricsandroid.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import fonte.com.laughablelyricsandroid.util.SearchResult
import java.net.URLEncoder

class MobileRequestService {

    fun searchRequest(queryParams: String, context: Context): MutableLiveData<ArrayList<SearchResult>> {
        val result: MutableLiveData<ArrayList<SearchResult>> = MutableLiveData()
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        val url = "http://35.22.120.35:1337/search?q=${URLEncoder.encode(queryParams, "utf-8")}"

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                Log.d(LOG_TAG, "Response: %s".format(response.toString()))
                // result.value = response
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