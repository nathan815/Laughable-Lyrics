package fonte.com.laughablelyricsandroid.data

import android.content.Context
import androidx.lifecycle.MutableLiveData

class MainRepository {
    private var mobileRequestService: MobileRequestService = MobileRequestService.getInstance()

    fun searchRequest(queryParams: String, context: Context): MutableLiveData<MutableList<String>> {
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