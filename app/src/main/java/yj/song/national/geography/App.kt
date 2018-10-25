package yj.song.national.geography

import android.app.Application

/**
 * Created by YJ.Song on 2018/10/24.
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}