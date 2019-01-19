package fonte.com.laughablelyricsandroid.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fonte.com.laughablelyricsandroid.data.MainRepository

class LyricsViewModelFactory(private val repository: MainRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LyricsViewModel(repository) as T
    }
}