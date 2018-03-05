package com.jason_sunyf.core.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.lang.reflect.Method;

/**
 * 手机相关工具类
 * Created by LWH on 2016/6/23.
 */
public class MobileUtil {

    private static Object result_0;
    private static Object result_1;

    /**
     * LWH 2016-07-19
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getMobileModel() {
        return Build.MODEL;
    }

    /**
     * LWH 2016-08-30
     * 获取手机硬件制造厂商
     */
    public static String getVendor() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取APP版本名
     *
     * @param context 上下文
     * @return 版本名
     */
    public static String getLocalVersionName(Context context) {
        String versionName = "1";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return versionName;
        }
        return versionName;
    }

    /**
     * LWH 2016-08-30
     * 获取本地APP版本号
     *
     * @param context 上下文
     * @return 版本号
     */
    public static String getLocalVersionCode(Context context) {
        int versionCode = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return String.valueOf(versionCode);
    }

    /**
     * 获取手机IMEI号
     */
    public static String getIemiNo(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }


    /**
     * LWH 2016-08-30
     * 获取androidid
     *
     * @param context 上下文
     * @return android id 唯一标识
     */
    public static String getAndroidId(Context context) {
        return android.provider.Settings.System.getString(context.getContentResolver(), "android_id");
    }

    /**
     * LWH 2016-08-30
     * 获取手机SN编号
     */
    public static String getSerialNo() {
        boolean is;
        String serialNo = "";
        Class<?> c;
        try {
            c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class);
            serialNo = (String) get.invoke(c, "ro.serialno");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serialNo;
    }

}
