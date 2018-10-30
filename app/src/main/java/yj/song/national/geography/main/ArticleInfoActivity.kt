package yj.song.national.geography.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_article_info.*
import yj.song.national.geography.R
import yj.song.national.geography.base.BaseActivity

class ArticleInfoActivity : BaseActivity() {
    companion object {
        fun start(context: Context, id: String) {
            val intent = Intent(context, ArticleInfoActivity::class.java)
            intent.putExtra("id", id)
            context.startActivity(intent)
        }
    }

    var articleWebView: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_info)
        initViews()

        val id = intent.getStringExtra("id")
        val articleUrl = "http://wap.ngchina.cn/article/info/jsp?id=$id"
        articleWebView = findViewById(R.id.article_view)
        articleWebView?.loadUrl(articleUrl)
        articleWebView?.settings?.javaScriptEnabled = true
        articleWebView?.settings?.defaultTextEncodingName = "UTF-8"
        articleWebView?.settings?.blockNetworkImage = false
        articleWebView?.settings?.domStorageEnabled = true
        articleWebView?.settings?.useWideViewPort = true
        articleWebView?.settings?.loadWithOverviewMode = false
        articleWebView?.webViewClient = (object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
                articleWebView?.loadUrl(articleUrl)
            }
        })
    }

    fun initViews() {
        toolbar.setNavigationOnClickListener({ finish() })
    }
}
