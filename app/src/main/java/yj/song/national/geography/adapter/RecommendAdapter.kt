package yj.song.national.geography.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import yj.song.national.geography.R
import yj.song.national.geography.imageloader.GlideImageLoader
import yj.song.national.geography.model.Data as RecommendData
import yj.song.national.geography.model.DataRow as RecommendRow

/**
 * Created by YJ.Song on 2018/10/25.
 */
class RecommendAdapter(cxt: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context: Context? = null

    companion object {
        val TYPE_BANNER = 0
        val TYPE_RECOMMEND = 1
    }

    init {
        context = cxt
    }

    var recommend: RecommendData? = null
        set(value) {
            Log.d("SYJ_", "value")

            field = value
            field?.discatArticles?.rows?.forEach {
                recommends.add(it)
            }

            notifyDataSetChanged()
        }

    private var recommends = mutableListOf<RecommendRow>()

    override fun getItemViewType(position: Int): Int {
        if (itemCount > recommends!!.size) {
            return when (position) {
                0 -> TYPE_BANNER
                else -> TYPE_RECOMMEND
            }
        } else {
            return TYPE_RECOMMEND
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        if (viewType == TYPE_BANNER) {
            val bannerViewHolder = holder as BannerViewHolder
            bannerViewHolder.bindData(recommend!!)
        } else if (viewType == TYPE_RECOMMEND) {

        }
    }

    override fun getItemCount(): Int {
        val bannersLength = recommend?.banners?.size ?: 0
        Log.d("SYJ_", "bannersLength")
        if (bannersLength > 0) {
            return recommends!!.size + 1
        }
        return recommends!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("SYJ_onCreateViewHolder", "onCreateViewHolder")
        return when (viewType) {
            TYPE_BANNER -> BannerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false))
            else -> RecommendViewHolder(LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false))
        }
    }

    /**
     * 内部类。被标记为inner可以访问外部类的成员
     */
    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bannerView: Banner? = null

        init {
            bannerView = itemView.findViewById<Banner>(R.id.home_banner_view)
        }

        fun bindData(recommendModel: RecommendData) {
            val images = mutableListOf<String>()
            val titles = mutableListOf<String>()
            recommendModel?.banners?.forEach {
                images.add(it.fileBrowseUrl)
                titles.add(it.name)
            }
            setBanner(images, titles)
        }

        private fun setBanner(images: List<String>, titles: List<String>) {
            //设置图片加载器
            bannerView?.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
            bannerView?.setImageLoader(GlideImageLoader())
            //设置图片集合
            bannerView?.setImages(images)
            //设置banner动画效果
            // bannerView?.setBannerAnimation(Transformer.DepthPage)
            //设置标题集合（当banner样式有显示title时）
            bannerView?.setBannerTitles(titles)
            //设置自动轮播，默认为true
            bannerView?.isAutoPlay(true)
            //设置轮播时间
            bannerView?.setDelayTime(3500)
            //设置指示器位置（当banner模式中有指示器时）
            bannerView?.setIndicatorGravity(BannerConfig.RIGHT)
            bannerView?.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE)
            //banner设置方法全部调用完毕时最后调用
            bannerView?.start()
        }
    }

    inner class RecommendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {

        }
    }

}