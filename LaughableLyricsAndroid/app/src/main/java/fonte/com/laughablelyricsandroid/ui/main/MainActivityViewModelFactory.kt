package fonte.com.laughablelyricsandroid.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fonte.com.laughablelyricsandroid.data.MainRepository

class MainActivityViewModelFactory(private val repository: MainRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}