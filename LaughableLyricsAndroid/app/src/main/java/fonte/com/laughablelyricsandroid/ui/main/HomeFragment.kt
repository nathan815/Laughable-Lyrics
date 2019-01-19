package fonte.com.laughablelyricsandroid.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import fonte.com.laughablelyricsandroid.R
import fonte.com.laughablelyricsandroid.databinding.HomeFragmentBinding
import fonte.com.laughablelyricsandroid.util.InjectorUtils

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var homeFragmentViewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val factory: HomeViewModelFactory = InjectorUtils.provideHomeViewModelFactory()
        homeFragmentViewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
        val binding: HomeFragmentBinding = DataBindingUtil.inflate<HomeFragmentBinding>(inflater, R.layout.home_fragment, container, false).apply {
            viewModel = homeFragmentViewModel
            setLifecycleOwner(this@HomeFragment)
        }
        return binding.root
    }

}
