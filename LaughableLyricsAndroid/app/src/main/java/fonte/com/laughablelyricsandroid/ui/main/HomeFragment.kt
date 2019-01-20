package fonte.com.laughablelyricsandroid.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import fonte.com.laughablelyricsandroid.MainActivity
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
        val binding: HomeFragmentBinding =
            DataBindingUtil.inflate<HomeFragmentBinding>(inflater, R.layout.home_fragment, container, false).apply {
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
        execute_search_button.setOnClickListener{
            (activity as MainActivity).navController.navigate(R.id.action_homeFragment_to_optionsFragment, null)
        }
    }
}
