package com.sinotech.modulerxjava

import com.jason_sunyf.core.appbase.Config
import com.jason_sunyf.core.base.BaseSubscriber
import com.jason_sunyf.core.http.RetrofitUtil
import com.jason_sunyf.core.http.rxfamily.RxPresenter
import com.jason_sunyf.core.http.rxfamily.RxUtil

/**
 * @author : Jason_Sunyf
 * @date   : 2018年02月28日15时37分
 * E-mail  : jason_sunyf@163.com
 */
class GankPresenter(var mViews: GankContract.View): RxPresenter<GankContract.View>(),GankContract.Presenter{
    override fun getGankData(type: String, pageSize: String, pageNum: String) {
        addSubscribe(RetrofitUtil
                .init(Config.GANKAPI)
                .create(GankApis::class.java)
                .getGankData(type, pageSize, pageNum)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleGankResult())
                .subscribeWith(object : BaseSubscriber<MutableList<GankItem>>(mViews) {
                    override fun onNext(t: MutableList<GankItem>) {
                        mViews.showGankData(t)
                    }
                })
        )
    }
}