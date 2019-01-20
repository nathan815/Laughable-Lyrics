package fonte.com.laughablelyricsandroid.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fonte.com.laughablelyricsandroid.data.MainRepository

class LyricsViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var isProgressBarVisible: MutableLiveData<Boolean> = MutableLiveData()

    init {
        isProgressBarVisible.value = true
    }
}