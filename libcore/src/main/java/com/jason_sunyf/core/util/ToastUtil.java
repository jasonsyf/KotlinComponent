package com.jason_sunyf.core.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toast工具类
 * Created by Jason_Sunyf on 2017/12/16 0016.
 * Email： jason_sunyf@163.com
 */

public class ToastUtil {
    private static Toast mToast;

    public static void showToast(String value) {
        if (mToast == null) {
            mToast = Toast.makeText(X.app(), value, Toast.LENGTH_SHORT);
        } else {
            //如果当前Toast没有消失， 直接显示内容，不需要重新设置
            mToast.setText(value);
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }
    public static void showToast(Context context,String value) {
        if (mToast == null) {
            mToast = Toast.makeText(context, value, Toast.LENGTH_SHORT);
        } else {
            //如果当前Toast没有消失， 直接显示内容，不需要重新设置
            mToast.setText(value);
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }
}
