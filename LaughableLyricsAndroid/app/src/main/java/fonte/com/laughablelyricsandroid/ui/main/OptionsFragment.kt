package fonte.com.laughablelyricsandroid.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import fonte.com.laughablelyricsandroid.R
import fonte.com.laughablelyricsandroid.databinding.OptionsFragmentBinding
import fonte.com.laughablelyricsandroid.util.InjectorUtils

class OptionsFragment : Fragment() {

    private lateinit var optionsFragmentViewModel: OptionsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val factory: OptionsViewModelFactory = InjectorUtils.provideOptionsViewModelFactory()
        optionsFragmentViewModel = ViewModelProviders.of(this, factory).get(OptionsViewModel::class.java)
        val binding: OptionsFragmentBinding =
            DataBindingUtil.inflate<OptionsFragmentBinding>(inflater, R.layout.options_fragment, container, false)
                .apply {
                    viewModel = optionsFragmentViewModel
                    setLifecycleOwner(this@OptionsFragment)
                }
        return binding.root
    }

}