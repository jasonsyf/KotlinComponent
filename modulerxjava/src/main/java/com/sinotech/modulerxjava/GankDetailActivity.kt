package com.sinotech.modulerxjava

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.alibaba.android.arouter.facade.annotation.Route
import com.jason_sunyf.core.base.BaseActivity
import com.jason_sunyf.core.base.BasePresenter
import kotlinx.android.synthetic.main.activity_gank_detail.*
@Route(path="/kotlin/GankDetailActivity")
class GankDetailActivity : BaseActivity<BasePresenter<*>>() {
    var url = ""


    override fun initDataAndEvent() {
        gank_detail_webview.settings.javaScriptEnabled = true
        gank_detail_webview.setWebViewClient(WebViewClient())
        gank_detail_webview.loadUrl(url)
    }

    override fun initPresenter() {
        url=intent.getStringExtra("url")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActionBarTitleTv.setText("详情")
        setContentView(R.layout.activity_gank_detail)
    }
}
