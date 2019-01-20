package fonte.com.laughablelyricsandroid.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fonte.com.laughablelyricsandroid.data.MainRepository

class OptionsViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var numBounces: Int = 10
    var isProgressBarVisible: MutableLiveData<Boolean> = MutableLiveData()

    init {
        isProgressBarVisible.value = true
    }

    fun searchRequest(queryParams: String, context: Context): MutableLiveData<MutableList<String>> {
        return mainRepository.searchRequest(queryParams, context)
    }
}