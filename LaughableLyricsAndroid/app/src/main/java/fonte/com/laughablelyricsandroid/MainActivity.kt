package fonte.com.laughablelyricsandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import fonte.com.laughablelyricsandroid.databinding.MainActivityBinding
import fonte.com.laughablelyricsandroid.ui.main.MainActivityViewModel
import fonte.com.laughablelyricsandroid.ui.main.MainActivityViewModelFactory
import fonte.com.laughablelyricsandroid.util.InjectorUtils

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory: MainActivityViewModelFactory = InjectorUtils.provideMainActivityViewModelFactory()
        mainActivityViewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        val binding: MainActivityBinding =
            DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity).apply {
                viewModel = mainActivityViewModel
            }
        val navHost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment? ?: return

        navController = navHost.navController

        setSupportActionBar(binding.appMainToolbar)
         NavigationUI.setupWithNavController(binding.appMainToolbar, navController)
    }

}
