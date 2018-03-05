package com.sinotech.modulerxjava

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout.VERTICAL
import com.alibaba.android.arouter.facade.annotation.Route
import com.jason_sunyf.core.base.BaseActivity
import kotlinx.android.synthetic.main.activity_test_gank.*
@Route(path="/kotlin/TestGankActivity")
class TestGankActivity : BaseActivity<GankPresenter>(), GankContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_gank)
    }

    override fun initPresenter() {
        mPresenter = GankPresenter(this)
        mPresenter.getGankData("Android", "99", "1")
    }

    override fun initDataAndEvent() {



    }

    override fun showGankData(list: MutableList<GankItem>?) {
        gank_recycler.layoutManager = LinearLayoutManager(context, VERTICAL, false)
        val adapter=GankAdapter(context, list)
        gank_recycler.adapter =adapter

    }


}

