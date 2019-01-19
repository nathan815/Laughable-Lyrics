package fonte.com.laughablelyricsandroid.util

import fonte.com.laughablelyricsandroid.data.MainRepository
import fonte.com.laughablelyricsandroid.ui.main.HomeViewModelFactory

object InjectorUtils {

    private fun getMainRepositorySingleton(): MainRepository {
        return MainRepository.getInstance()
    }

    fun provideHomeViewModelFactory() : HomeViewModelFactory {
        val mainRepository: MainRepository = getMainRepositorySingleton()
        return HomeViewModelFactory(mainRepository)
    }
}