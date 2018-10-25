package yj.song.national.geography.main.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yj.song.national.geography.R
import yj.song.national.geography.base.BaseFragment

/**
 * Created by YJ.Song on 2018/10/24.
 */
class RecommendFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_recommend, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    /**
     * 静态方法
     */
    companion object {
        fun getInstance(seqNo: Int): Fragment {
            var recommendFragment = RecommendFragment()
            var bundle = Bundle()
            bundle.putInt("seqNo", seqNo)
            recommendFragment.arguments = bundle
            return recommendFragment
        }
    }

}