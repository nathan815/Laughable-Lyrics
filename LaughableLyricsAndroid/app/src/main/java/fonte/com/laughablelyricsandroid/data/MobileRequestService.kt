package fonte.com.laughablelyricsandroid.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MobileRequestService {

    fun searchRequest(queryParams: String, context: Context): MutableLiveData<MutableList<String>> {
        val result: MutableLiveData<MutableList<String>> = MutableLiveData()
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        val url = "http://35.22.120.35:1337/search?q=$queryParams"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                Log.d(LOG_TAG, "Response: %s".format(response.toString()))
            },
            Response.ErrorListener { error ->
                Log.e(LOG_TAG, error.toString())
            }
        )


        queue.add(jsonObjectRequest)
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