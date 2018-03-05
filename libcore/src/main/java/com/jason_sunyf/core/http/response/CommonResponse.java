package com.jason_sunyf.core.http.response;

/**
 * 最常见的服务器返回数据
 * Created by Jason_Sunyf on 2017/12/12 0012.
 * Email： jason_sunyf@163.com
 */

public class CommonResponse<T> {
    private int code;
    private String massage;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
