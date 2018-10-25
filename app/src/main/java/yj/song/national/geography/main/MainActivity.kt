package yj.song.national.geography.main

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import yj.song.national.geography.R
import yj.song.national.geography.adapter.ViewPagerAdapter
import yj.song.national.geography.base.BaseActivity
import yj.song.national.geography.model.PageTitleWrapper
import yj.song.national.geography.utils.LoadDataManager

class MainActivity : BaseActivity() {
    var pagerAdapter: ViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadDataAndUI()
    }

    private fun loadDataAndUI() {
        val datas = LoadDataManager.convert2HomeData("article.json")
        pagerAdapter = ViewPagerAdapter(supportFragmentManager, PageTitleWrapper.pageTitle(datas))
        viewpager.adapter = pagerAdapter

        //tablayout绑定viewpager
        tablayout.setupWithViewPager(viewpager)
    }

}
