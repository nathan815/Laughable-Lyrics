package fonte.com.laughablelyricsandroid.data

class MainRepository {

    companion object {

        @Volatile
        private var instance: MainRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: MainRepository().also {
                    instance = it
                }
            }
    }
}