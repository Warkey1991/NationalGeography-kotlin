package yj.song.national.geography.utils

import com.google.gson.Gson
import yj.song.national.geography.App
import yj.song.national.geography.model.HomeDataResult
import yj.song.national.geography.model.Data as HomePageData

/**
 * Created by YJ.Song on 2018/10/24.
 */
object LoadDataManager {
    private fun loadDataFromAssets(assetsFileName: String): String {
        var fileString = App.instance.assets.open(assetsFileName).bufferedReader().use { it.readText() }
        return fileString
    }

    fun convert2HomeData(assetsFileName: String): List<HomePageData> {
        var fileString = loadDataFromAssets(assetsFileName)
        val gson = Gson()
        val homeDataResult = gson.fromJson(fileString, HomeDataResult::class.java)
        return homeDataResult.data
    }

}