package com.jason_sunyf.moudlewhether.whether

import android.util.Log
import com.google.gson.Gson
import com.jason_sunyf.core.appbase.Config
import com.jason_sunyf.core.base.BaseSubscriber
import com.jason_sunyf.core.http.RetrofitUtil
import com.jason_sunyf.core.http.response.JhResponse
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
        val url = "https://api.weibo.cn/2/guest/cardlist?" +
        "networktype=wifi&uicode=10000327&moduleID=708&checktoken=" +
                "&c=android&i=a52f1e4&s=c1108e87&ua=OPPO-OPPO%20R9m__weibo__6.8.2__android__android5.1" +
                "&wm=9847_0002&aid=01AilAKZLB81znjKciZxofmqIMYg52EReWuEaQL7hIDXj6IR4." +
                "&did=b87cc255f19b91ff8e202968adab0eb9fc159a2e&&v_f=2&v_p=33" +
                "&from=1068295010&gsid=_2AkMg6ZSSf8NhqwJRmP0QzGPgb4l_wgjEieLBAH7sJRM3HRl-3T9jqnUstRUyD-wT6lM3A4HWHM1fFXBWuOYnxg.." +
                "&lang=zh_CN&page=1&skin=default&count=20&oldwm=9893_0044" +
                "&sflag=1&containerid=1087030002_2982_2_50&need_head_cards=0";
//        addSubscribe(RetrofitUtil.init().create(JuheApis::class.java)
//                .getWhether(Config.BaseIP+"weather/index",cityname, "3113bf386346db1f52e57ef6483cbac8")
//                .compose(RxUtil.rxSchedulerHelper())
//                .compose(RxUtil.handleResult())
//                .subscribeWith(object : BaseSubscriber<WhetherByCity>(mViews) {
//                    override fun onNext(whetherByCity: WhetherByCity) {
//                        Log.i("WhetherByCity", "WhetherByCity: " + Gson().toJson(whetherByCity))
//                        mViews.showWhetherData(whetherByCity)
//                    }
//                }))
        addSubscribe(RetrofitUtil.init().create(JuheApis::class.java)
                .getWeiboData(url)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(object : BaseSubscriber<Any>(mViews) {
                    override fun onNext(t: Any?) {
                        Log.i("getWeiboData", "getWeiboData: " + Gson().toJson(t))
                    }
                }))

    }
}