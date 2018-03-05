package com.jason_sunyf.core.appbase;

import android.app.Application;

import com.jason_sunyf.core.util.CrashHandler;
import com.jason_sunyf.core.util.X;

/**
 *
 * @author Jason_Sunyf
 * @date 2017/12/16 0016
 * Email： jason_sunyf@163.com
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;

    public static synchronized BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        X.Ext.init(this);
        CrashHandler.getInstance(this).init();
    }
}
