package fonte.com.laughablelyricsandroid.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fonte.com.laughablelyricsandroid.data.MainRepository
import fonte.com.laughablelyricsandroid.util.SearchResult

class OptionsViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var numBounces: Int = 10
    var isProgressBarVisible: MutableLiveData<Boolean> = MutableLiveData()
    var searchTerm: String? = ""

    init {
        isProgressBarVisible.value = true
    }

    fun searchRequest(queryParams: String, context: Context): MutableLiveData<ArrayList<SearchResult>> {
        return mainRepository.searchRequest(queryParams, context)
    }
}