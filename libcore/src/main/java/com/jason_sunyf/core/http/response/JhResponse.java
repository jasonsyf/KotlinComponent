package com.jason_sunyf.core.http.response;

/**
 * Created by Jason_Sunyf on 2017/12/14 0014.
 * Email： jason_sunyf@163.com
 */

public class JhResponse<T> {

    private String resultcode;
    private String reason;
    private T result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
