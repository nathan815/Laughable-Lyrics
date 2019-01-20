package fonte.com.laughablelyricsandroid.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import fonte.com.laughablelyricsandroid.util.SearchResult

class MainRepository {
    private var mobileRequestService: MobileRequestService = MobileRequestService.getInstance()

    fun searchRequest(queryParams: String, context: Context): MutableLiveData<ArrayList<SearchResult>> {
        return mobileRequestService.searchRequest(queryParams, context)
    }

    companion object {

        @Volatile
        private var instance: MainRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: MainRepository().also {
                    instance = it
                }
            }
    }
}