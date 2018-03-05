package com.jason_sunyf.core.http.exception;

/**
 * Created by Jason_Sunyf on 2017/12/16 0016.
 * Email： jason_sunyf@163.com
 */
public class ApiException extends Exception {

    private int code;

    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(String msg, int code) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
