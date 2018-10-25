package yj.song.national.geography.model

/**
 * Created by YJ.Song on 2018/10/24.
 */
object PageTitleWrapper {
    /**
     * 根据给定的数据返回另一个列表对象
     */
    fun pageTitle(data: List<Data>): List<PageTitle> {
        return data.map { data ->
            PageTitle(data.name, data.seqNo)
        }
    }
}
