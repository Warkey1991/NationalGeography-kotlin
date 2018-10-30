package yj.song.national.geography.main.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yj.song.national.geography.R
import yj.song.national.geography.adapter.RecommendAdapter
import yj.song.national.geography.base.BaseFragment
import yj.song.national.geography.utils.LoadDataManager
import yj.song.national.geography.model.Data as RecommendData


/**
 * Created by YJ.Song on 2018/10/24.
 */
class RecommendFragment : BaseFragment() {
    private var recommendRecyclerView: RecyclerView? = null
    private var recommendModel: RecommendData? = null
    private var recommendAdapter: RecommendAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_recommend, container, false)
        recommendRecyclerView = view.findViewById<RecyclerView>(R.id.recommend_recycler_view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val seqNo = arguments?.getInt("seqNo") ?: 1
        recommendModel = LoadDataManager.obtainDataFromSeqNo("article.json", seqNo)
        recommendAdapter = RecommendAdapter(context!!)
        val gridLayoutManager = GridLayoutManager(context, 2)
        recommendRecyclerView?.adapter = recommendAdapter
        recommendAdapter?.recommend = recommendModel
        gridLayoutManager.spanSizeLookup = (object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0 -> 2
                    else -> 1
                }
            }
        })
        recommendRecyclerView?.layoutManager = gridLayoutManager
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