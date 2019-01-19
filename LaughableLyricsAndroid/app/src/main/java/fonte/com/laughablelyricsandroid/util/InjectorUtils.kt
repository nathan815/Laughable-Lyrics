package fonte.com.laughablelyricsandroid.util

import fonte.com.laughablelyricsandroid.data.MainRepository
import fonte.com.laughablelyricsandroid.ui.main.HomeViewModelFactory
import fonte.com.laughablelyricsandroid.ui.main.LyricsViewModelFactory
import fonte.com.laughablelyricsandroid.ui.main.MainActivityViewModelFactory
import fonte.com.laughablelyricsandroid.ui.main.OptionsViewModelFactory

object InjectorUtils {

    private fun getMainRepositorySingleton(): MainRepository {
        return MainRepository.getInstance()
    }

    fun provideHomeViewModelFactory(): HomeViewModelFactory {
        val mainRepository: MainRepository = getMainRepositorySingleton()
        return HomeViewModelFactory(mainRepository)
    }

    fun provideOptionsViewModelFactory(): OptionsViewModelFactory {
        val mainRepository: MainRepository = getMainRepositorySingleton()
        return OptionsViewModelFactory(mainRepository)
    }

    fun provideLyricsViewModelFactory(): LyricsViewModelFactory {
        val mainRepository: MainRepository = getMainRepositorySingleton()
        return LyricsViewModelFactory(mainRepository)
    }

    fun provideMainActivityViewModelFactory(): MainActivityViewModelFactory {
        val mainRepository: MainRepository = getMainRepositorySingleton()
        return MainActivityViewModelFactory(mainRepository)
    }
}