package com.jason_sunyf.moudlewhether.whether

import com.jason_sunyf.core.base.BasePresenter
import com.jason_sunyf.core.base.BaseView
import com.jason_sunyf.moudlewhether.entity.WhetherByCity

/**
 *
 * @author Jason_Sunyf
 * @date 2017/12/14 0014
 * Email： jason_sunyf@163.com
 */

interface WhetherContract {
    interface View : BaseView {
        fun showWhetherData(whetherByCity: WhetherByCity)
    }

    interface Presenter : BasePresenter<View> {
        fun getWhetherData(cityname: String)
    }
}
