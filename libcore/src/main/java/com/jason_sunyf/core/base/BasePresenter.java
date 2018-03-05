package com.jason_sunyf.core.base;

/**
 *
 * @author Jason_Sunyf
 * @date 2017/12/16 0016
 * Email： jason_sunyf@163.com
 */

public interface BasePresenter<T extends BaseView> {

    /** 绑定view
     * @param view view
     */
    void attachView(T view);

    /**
     *  解绑 view
     */
    void detachView();
}
