package com.jason_sunyf.core.view;

/**
 * Created by jason_syf on 2017/10/25.
 * Email:jason_sunyf@163.com
 */

public class Trace {
    /** 时间 */
    private String acceptTime;

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Trace(String acceptDate, String acceptTime, String acceptStation) {

        this.acceptTime = acceptTime;
        this.acceptDate = acceptDate;
        this.acceptStation = acceptStation;
    }

    //    日期
    private String acceptDate;
    /** 描述 */
    private String acceptStation;

    public Trace() {
    }

    public Trace(String acceptTime, String acceptStation) {
        this.acceptTime = acceptTime;
        this.acceptStation = acceptStation;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }
}

