package com.jason_sunyf.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 * Created by LWH on 2016/6/15.
 */
public class DateUtil {

    /**
     * LWH 2016-08-19
     * 获取当天日期
     */
    public static String getCurrentDate() {
        String currentTime;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ", Locale.getDefault());
        currentTime = dateFormat.format(date);
        return currentTime;
    }

    /**
     * Created by LWH at 2017-05-12 14:30
     * 格式化日期
     */
    public static String formatDate(String dateString) {
        String dateStr = dateString;
        Date date = parseDate(dateString);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ", Locale.getDefault());
        dateStr = dateFormat.format(date);
        return dateStr;
    }

    /**
     * 获取当前时间
     *
     * @return String yyyy-MM-dd HH:mm:ss
     */
    public static String getNowTime() {
        String currentTime;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        currentTime = dateFormat.format(date);
        return currentTime;
    }

    /**
     * LWH 2016-09-18
     * 解析日期
     *
     * @param dateString string类型的日期
     */
    public static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        Date date;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return date;
    }

    /**
     * LWH 2016-09-08
     * 获取当前时间，精确到毫秒
     *
     * @return yyyy-MM-dd HH:mm:ss:SSS
     */
    public static String getCurrentTimeMS() {
        String currentTime;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault());
        currentTime = dateFormat.format(date);
        return currentTime;
    }

    /**
     * Date日期格式化为String类型
     *
     * @param date Date
     * @return String
     */
    public static String formatDate(Date date) {
        String dateString;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ", Locale.getDefault());
        dateString = dateFormat.format(date);
        return dateString;
    }


    /**
     * LWH 2016-11-26
     * 计算日期差
     *
     * @param startDateString 开始日期
     * @param endDateString   结束日期
     * @return 天数
     */
    public static long getDateBetween(String startDateString, String endDateString) {
        long days = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date startDate = dateFormat.parse(startDateString);
            Date endDate = dateFormat.parse(endDateString);
            long diff = endDate.getTime() - startDate.getTime();
            days = diff / (1000 * 60 * 60 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }
}