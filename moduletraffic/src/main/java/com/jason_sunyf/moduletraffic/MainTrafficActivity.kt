package com.jason_sunyf.moduletraffic

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.jason_sunyf.core.base.BaseActivity
import com.jason_sunyf.core.base.BasePresenter
import kotlinx.android.synthetic.main.activity_main_traffic.*

@Route(path = "/traffic/main") //aroute 定义路径
class MainTrafficActivity : BaseActivity<BasePresenter<*>>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActionBarTitleTv.text = "交通模块"
        setContentView(R.layout.activity_main_traffic)
    }

    override fun initPresenter() {

    }

    override fun initDataAndEvent() {
        val s: String? = intent.getStringExtra("jason")
        traffic_text!!.text = s
        traffic_text!!.setOnClickListener {
            ARouter.getInstance().build("/whether/main").navigation()
        }
    }


}
