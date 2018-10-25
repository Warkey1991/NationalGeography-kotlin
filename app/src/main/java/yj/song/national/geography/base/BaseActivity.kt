package yj.song.national.geography.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by YJ.Song on 2018/10/24.
 * Kotlin默认类是final的，无法被继承，要是被继承，需要加open关键字
 */
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}