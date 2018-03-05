package com.jason_sunyf.modulemain

import com.jason_sunyf.core.http.rxfamily.RxPresenter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * @author : Jason_Sunyf
 * @date   : 2018年02月27日15时15分
 * E-mail  : jason_sunyf@163.com
 */
class MainPresenter internal constructor(private val mViews: MainContract.View) :RxPresenter<MainContract.View>(),MainContract.Presenter {
    override fun getData() {
        doAsync {
            val request = Request("https://www.baidu.com").run()
            uiThread {
                mViews.showData(request)
            }
        }
    }
}
