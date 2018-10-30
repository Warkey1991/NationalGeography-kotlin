package yj.song.national.geography.imageloader

import android.content.Context
import android.widget.ImageView
import com.youth.banner.loader.ImageLoader

/**
 * Created by YJ.Song on 2018/10/25.
 */
class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        GlideApp.with(context!!)
                .load(path)
                .into(imageView!!)
    }
}