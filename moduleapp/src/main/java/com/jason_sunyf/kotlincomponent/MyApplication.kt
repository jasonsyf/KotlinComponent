package com.jason_sunyf.kotlincomponent

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

import com.alibaba.android.arouter.launcher.ARouter
import com.jason_sunyf.core.appbase.BaseApplication
import com.jason_sunyf.core.base.BaseActivity
import com.jason_sunyf.core.util.StringUtils

/**
 * Created by Jason_Sunyf on 2017/12/16 0016.
 * Email： jason_sunyf@163.com
 */

class MyApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        if (isAppDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
    }

    companion object {

        @get:Synchronized
        var instance: BaseApplication? = null
            private set

        /**
         * 判断App是否是Debug版本
         *
         * @return `true`: 是<br></br>`false`: 否
         */
        val isAppDebug: Boolean
            get() {
                if (StringUtils.isSpace(instance!!.packageName)) {
                    return false
                }
                try {
                    val pm = instance!!.packageManager
                    val ai = pm.getApplicationInfo(instance!!.packageName, 0)
                    return ai != null && ai.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
                } catch (e: PackageManager.NameNotFoundException) {
                    e.printStackTrace()
                    return false
                }

            }
    }

}
