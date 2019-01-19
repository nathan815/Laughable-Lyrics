package fonte.com.laughablelyricsandroid.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import fonte.com.laughablelyricsandroid.R
import fonte.com.laughablelyricsandroid.databinding.HomeFragmentBinding
import fonte.com.laughablelyricsandroid.util.InjectorUtils
import kotlinx.android.synthetic.main.home_fragment.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val list: MutableList<String> = arrayListOf()
//        list.add("Hello")
//        list.add("Hi")
//        enter_song.setAdapter(ArrayAdapter<String>(context!!, android.R.layout.simple_dropdown_item_1line, list))

    }
}
