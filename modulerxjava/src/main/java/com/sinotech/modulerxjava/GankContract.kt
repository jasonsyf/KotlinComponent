package com.sinotech.modulerxjava

import com.jason_sunyf.core.base.BasePresenter
import com.jason_sunyf.core.base.BaseView

/**
 * @author : Jason_Sunyf
 * @date   : 2018年02月28日15时27分
 * E-mail  : jason_sunyf@163.com
 */
interface GankContract {
    interface View:BaseView{
        fun showGankData(list:MutableList<GankItem>?)
    }

    interface Presenter : BasePresenter<View> {
        fun getGankData(type: String,
                        pageSize: String,
                        pageNum: String)
    }
}