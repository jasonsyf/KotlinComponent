package com.jason_sunyf.core.util;

import android.content.Context;
import android.os.Process;

/**
 * 程序崩溃日志处理
 * Created by 江沨 on 2016/8/30.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static CrashHandler mInstance;
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;

    private CrashHandler(Context context) {
        mContext = context;
    }

    /**
     * LWH 2016-08-30
     * 单例获取错误日志处理对象
     *
     * @param context 上下文
     * @return 单例对象
     */
    public static CrashHandler getInstance(Context context) {
        if (mInstance == null) {
            synchronized (CrashHandler.class) {
                if (mInstance == null) {
                    mInstance = new CrashHandler(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * LWH 2016-08-30
     * 错误日志处理初始化
     */
    public void init() {
        /**
         * 是否添加相关权限,
         * READ_PHONE_STATE /WRITE_EXTERNAL_STORAGE/
         * ACCESS_NETWORK_STATE /ACCESS_WIFI_STATE
         */
//        if (!FileUtil.isHasPermission(X.app())) {
//            return;
//        }
        // 获取系统默认的UncaughtException处理器
        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        //自定义处理异常
        ex.printStackTrace();

        if (mDefaultCrashHandler != null) {
            mDefaultCrashHandler.uncaughtException(thread, ex);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }
}