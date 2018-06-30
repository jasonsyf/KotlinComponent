package com.jason_sunyf.moudlewhether.whether

import android.util.Log
import com.google.gson.Gson
import com.jason_sunyf.core.appbase.Config
import com.jason_sunyf.core.base.BaseSubscriber
import com.jason_sunyf.core.http.RetrofitUtil
import com.jason_sunyf.core.http.rxfamily.RxPresenter
import com.jason_sunyf.core.http.rxfamily.RxUtil
import com.jason_sunyf.moudlewhether.apis.JuheApis
import com.jason_sunyf.moudlewhether.entity.WhetherByCity

/**
 * @author : Jason_Sunyf
 * @date : 2018/2/3 0003  上午 11:44
 * @Email : jason_sunyf@163.com
 */
class WhetherPresenter(var mViews: WhetherContract.View) : RxPresenter<WhetherContract.View>(), WhetherContract.Presenter {

    override fun getWhetherData(cityname: String) {
        addSubscribe(RetrofitUtil.init().create(JuheApis::class.java)
                .getWhether(Config.BaseIP+"weather/index",cityname, "3113bf386346db1f52e57ef6483cbac8")
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(object : BaseSubscriber<WhetherByCity>(mViews) {
                    override fun onNext(whetherByCity: WhetherByCity) {
                        Log.i("WhetherByCity", "WhetherByCity: " + Gson().toJson(whetherByCity))
                        mViews.showWhetherData(whetherByCity)
                    }
                }))
    }
}