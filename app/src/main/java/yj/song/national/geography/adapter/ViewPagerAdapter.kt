package yj.song.national.geography.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import yj.song.national.geography.main.fragment.DoingsFragment
import yj.song.national.geography.main.fragment.PhotographyFragment
import yj.song.national.geography.main.fragment.RecommendFragment
import yj.song.national.geography.main.fragment.VideoFragment
import yj.song.national.geography.model.PageTitle

/**
 * Created by YJ.Song on 2018/10/24.
 */
class ViewPagerAdapter(fm: FragmentManager, pageTitles: List<PageTitle>) : FragmentPagerAdapter(fm) {

    var titles: List<PageTitle>? = null

    init {
        titles = pageTitles
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles!![position].title
    }

    override fun getItem(position: Int): Fragment {
        when (titles!![position].seqNo) {
            1 -> return RecommendFragment.getInstance(1)
            2 -> return PhotographyFragment.getInstance()
            3 -> return VideoFragment.getInstance()
            4 -> return DoingsFragment.getInstance()
            else -> return RecommendFragment.getInstance(1)
        }
    }

    override fun getCount(): Int {
        return titles!!.size
    }
}