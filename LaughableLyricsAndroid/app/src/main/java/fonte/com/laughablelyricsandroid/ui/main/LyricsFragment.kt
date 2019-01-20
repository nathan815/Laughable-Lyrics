package fonte.com.laughablelyricsandroid.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import fonte.com.laughablelyricsandroid.R
import fonte.com.laughablelyricsandroid.databinding.LyricsFragmentBinding
import fonte.com.laughablelyricsandroid.util.InjectorUtils

class LyricsFragment : Fragment() {

    private lateinit var lyricsFragmentViewModel: LyricsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val factory: LyricsViewModelFactory = InjectorUtils.provideLyricsViewModelFactory()
        lyricsFragmentViewModel = ViewModelProviders.of(this, factory).get(LyricsViewModel::class.java)
        val binding: LyricsFragmentBinding =
            DataBindingUtil.inflate<LyricsFragmentBinding>(inflater, R.layout.lyrics_fragment, container, false).apply {
                viewModel = lyricsFragmentViewModel
                setLifecycleOwner(this@LyricsFragment)
            }
        lyricsFragmentViewModel.songId = LyricsFragmentArgs.fromBundle(arguments!!).songId?.toInt()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lyricsFragmentViewModel.songId?.let { lyricsFragmentViewModel.getLyrics(it, 5, context!!) }
            ?.observe(this, Observer { response ->
                Log.d("Tag", response.Original)
            })
    }
}