package com.jason_sunyf.core.http.rxfamily;

/**
 * rxbus 实体类
 * Created by Jason_Sunyf on 2017/11/11 0011.
 * Email： jason_sunyf@163.com
 */

public class RxMessage {
    private int code;
    private Object object;

    public RxMessage() {}

    public RxMessage(int code, Object o) {
        this.code = code;
        this.object = o;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
