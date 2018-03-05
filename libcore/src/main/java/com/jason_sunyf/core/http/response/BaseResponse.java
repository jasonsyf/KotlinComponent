package com.jason_sunyf.core.http.response;

/**
 * 返回结果实体
 * Created by Jason_Sunyf on 2017/11/30 0030.
 * Email： jason_sunyf@163.com
 */

public class BaseResponse<T> {
    /**
     * 操作是否成功
     */
    private boolean IsOk;
    /**
     *操作后返回的消息
     */
    private String Message;
    /**
     *返回的结果
     */
    private T Value;
    /**
     *返回的结果代码
     */
    private int Code;
    /**
     *分页查询的结果的总条数
     */
    private int ItemCount;
    /**
     *分页查询的总页数
     */
    private int PageCount;
    /**
     *分页查询的当前页
     */
    private int CurrentPage;


    public boolean isOk() {
        return IsOk;
    }

    public void setOk(boolean ok) {
        IsOk = ok;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getValue() {
        return Value;
    }

    public void setValue(T value) {
        Value = value;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public int getItemCount() {
        return ItemCount;
    }

    public void setItemCount(int itemCount) {
        ItemCount = itemCount;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }

    public int getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }
}
