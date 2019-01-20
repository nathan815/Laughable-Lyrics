package fonte.com.laughablelyricsandroid.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import fonte.com.laughablelyricsandroid.R
import fonte.com.laughablelyricsandroid.databinding.OptionsFragmentBinding
import fonte.com.laughablelyricsandroid.util.InjectorUtils
import kotlinx.android.synthetic.main.options_fragment.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        options_seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {}

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBar?.progress?.let {
                    optionsFragmentViewModel.numBounces = it
                    Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}