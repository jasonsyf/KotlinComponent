package com.jason_sunyf.modulemain

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.jason_sunyf.core.base.BaseActivity
import com.jason_sunyf.moduletraffic.MainTrafficActivity
import com.jason_sunyf.moudlewhether.whether.MainWhetherActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import java.net.URL

class MainActivity : BaseActivity<MainPresenter>(), View.OnClickListener, MainContract.View {

    override fun showData(data: String) {
        tv1.settings.javaScriptEnabled = true
        tv1.setWebViewClient(WebViewClient())
//        tv1.loadDataWithBaseURL(null, data,
//                "text/html", "utf-8", null)
        tv1.loadUrl("https://www.baidu.com")
    }


    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActionBarTitleTv.text = "模块化项目"
        setContentView(R.layout.activity_main)
        btn1!!.setOnClickListener(this)
        btn2!!.setOnClickListener(this)
        btn3!!.setOnClickListener(this)
    }

    override
    fun initPresenter() {
        mPresenter = MainPresenter(this)
        mPresenter.getData()
    }


    override
    fun initDataAndEvent() {

    }

    override fun onClick(v: View) {
        when {
            v.id == R.id.btn1 -> {
                startActivity(Intent(this, MainWhetherActivity::class.java))
            }
            v.id == R.id.btn2 -> {
                startActivity(Intent(this, MainTrafficActivity::class.java))
            }
            v.id == R.id.btn3 -> {
                ARouter.getInstance().build("/kotlin/TestGankActivity").navigation(context)

            }
            else -> Toast.makeText(context, "出现错误", Toast.LENGTH_SHORT).show()
        }
    }


}

public class Request(val url: String) {
    public fun run(): String {
        //url是我们传入的请求地址，通过readText()方法就可以直接返回数据
        val forecastJsonStr = URL(url).readText()
        //打印返回的json格式数据
        Log.d("http", forecastJsonStr)
        return forecastJsonStr
    }
}
