package yj.song.national.geography.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yj.song.national.geography.base.BaseFragment

/**
 * Created by YJ.Song on 2018/10/24.
 */
class DoingsFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun getInstance(): BaseFragment {
            return DoingsFragment()
        }
    }
}