package yj.song.national.geography.model

/**
 * Created by YJ.Song on 2018/10/24.
 */
data class HomeDataResult(var requestCode: Int, var requestCodeName: String, var type: String,
                          var code: Int, var codeName: String, var message: String,
                          var data: List<Data>)

data class Data(var id: Int, var type: Int, var name: String, var seqNo: Int, var banners: List<Banner>, var discatArticles: DscatArticles,
                var discatAtlas: String, var state: Boolean, var articleId: String,
                var createTime: String, var ts: String)

data class Banner(var id: Int, var discatId: Int, var imageUuid: String, var imageUsage: String,
                  var imagePath: String, var seqNo: Int, var url: String,
                  var name: String, var meno: String, var fileBrowseUrl: String,
                  var disCatId: Int, var createTime: String,
                  var ts: String)

data class DscatArticles(var pagination: Pagination, var rows: List<DataRow>)

data class Pagination(var totalCount: Int, var pageSize: Int, var pageNumber: Int, var pageIndexRange: PageIndexRange,
                      var pageIndexFrom: Int)

data class PageIndexRange(var from: Int, var to: Int)

data class DataRow(var id: Int, var discatId: Int, var articleId: Int,
                   var seqNo: Int, var logoBrowseUrl: String, var articleTitle: String,
                   var articleAtlas: String, var pubDay: String)


data class PageTitle(var title: String, var seqNo: Int)