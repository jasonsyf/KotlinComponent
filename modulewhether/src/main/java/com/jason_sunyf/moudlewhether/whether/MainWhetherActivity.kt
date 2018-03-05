package com.jason_sunyf.moudlewhether.whether

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.google.gson.Gson
import com.jason_sunyf.core.base.BaseActivity
import com.jason_sunyf.core.util.ToastUtil
import com.jason_sunyf.moudlewhether.R
import com.jason_sunyf.moudlewhether.entity.WhetherByCity
import kotlinx.android.synthetic.main.activity_main_whether.*

@Route(path = "/whether/main")
class MainWhetherActivity : BaseActivity<WhetherPresenter>(), WhetherContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActionBarTitleTv.text = "天气模块"
        setContentView(R.layout.activity_main_whether)
        mPresenter.getWhetherData("郑州")
    }

    override fun initPresenter() {
        mPresenter = WhetherPresenter(this)
    }

    override fun initDataAndEvent() {
        textView!!.setOnClickListener {
            ARouter.getInstance().build("/traffic/main")
                    .withString("jason", "我是跳转后传过去的数据")
                    .navigation()
        }
    }

    override fun showWhetherData(whetherByCity: WhetherByCity) {
        ToastUtil.showToast("成功")
        textView!!.setText(Gson().toJson(whetherByCity))
    }
}
