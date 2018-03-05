package com.jason_sunyf.core.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by jerry on 2017/11/8.
 */

public class CommonUtil {


    /**
     * 拨打电话
     *
     * @param context  上下文
     * @param telphone 电话号码
     */
    public static void callPhoneNumber(Context context, String telphone) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + telphone));
        context.startActivity(intent);
    }
    /**
     * 判断费用是否为空或者NULL
     */
    public static String judgmentCostValue(String edtTxt) {
        String costValue = edtTxt;
        if (TextUtils.isEmpty(edtTxt)) {
            costValue = "0";
        }
        return costValue;
    }

    /**
     * 判断字符串为NULL，默认设置为""
     */
    public static String judgmentTxtValue(String txt) {
        String value = txt;
        if (TextUtils.isEmpty(value)) {
            value = "";
        }
        return value;
    }
    /**
      * Created by LWH at 2017/11/15 20:50
      * 判断字符串是否大于0
      */
    public static boolean isAbove(String value ){
        value=judgmentCostValue(value);
        return Double.parseDouble(value)>0;
    }
}
