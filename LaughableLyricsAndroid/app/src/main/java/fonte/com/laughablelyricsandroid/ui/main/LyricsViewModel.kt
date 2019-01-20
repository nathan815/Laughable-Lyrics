package fonte.com.laughablelyricsandroid.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fonte.com.laughablelyricsandroid.data.MainRepository

class LyricsViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var isProgressBarVisible: MutableLiveData<Boolean> = MutableLiveData()
    var songId: Int? = 0

    init {
        isProgressBarVisible.value = true
    }
}