package fonte.com.laughablelyricsandroid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import fonte.com.laughablelyricsandroid.LyricPageFragment
import kotlinx.android.synthetic.main.fragment_lyric_page.*


class LyricPagerAdapter(fm: FragmentManager?,private val original: String, private val translated: String) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
       return 2
    }

    override fun getItem(position: Int): Fragment {
        val fragment = LyricPageFragment()
        if(position == 0) {
            fragment.lyric_page_text.text = translated
        }
        else {
            fragment.lyric_page_text.text = original
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0) return "REMIXED"
        return "ORIGINAL"
    }
}