package com.jason_sunyf.modulemain

import com.jason_sunyf.core.base.BasePresenter
import com.jason_sunyf.core.base.BaseView
import com.jason_sunyf.moudlewhether.whether.WhetherContract

/**
 * @author : Jason_Sunyf
 * @date   : 2018年02月27日15时11分
 * E-mail  : jason_sunyf@163.com
 */
interface MainContract {
    interface View: BaseView{
        fun showData(data:String)
    }

    interface Presenter : BasePresenter<View> {
        fun getData()
    }
}