package fonte.com.laughablelyricsandroid.ui.main

import androidx.lifecycle.ViewModel
import fonte.com.laughablelyricsandroid.data.MainRepository

class OptionsViewModel(private val mainRepository: MainRepository) : ViewModel() {
    var numBounces : Int = 10
}