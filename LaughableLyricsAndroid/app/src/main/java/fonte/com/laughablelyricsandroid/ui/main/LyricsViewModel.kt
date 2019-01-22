package fonte.com.laughablelyricsandroid.ui.main

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fonte.com.laughablelyricsandroid.data.MainRepository
import fonte.com.laughablelyricsandroid.util.LyricResponse

class LyricsViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var isProgressBarVisible: MutableLiveData<Boolean> = MutableLiveData()
    var songId: Int? = 0
    var numBounces: Int = 0

    init {
        isProgressBarVisible.value = true
    }

    fun getLyrics(songId: Int, numBounces: Int, context: Context): MutableLiveData<LyricResponse> {
        return mainRepository.getLyrics(songId, numBounces, context)
    }

}