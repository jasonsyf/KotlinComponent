package com.jason_sunyf.core.util;



import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * dialog工具类
 * Created by LWH on 2016/6/14.
 */
public class DialogUtil extends Dialog {
    private static ProgressDialog mProgressBar = null;

    public DialogUtil(Context context) {
        super(context);
    }

    /**
     * 创建提示进度dialog
     *
     * @param titleName String
     * @param content   String
     * @param context   Context上下文
     */
    public static void createDialog(Context context, String titleName, String content) {
        mProgressBar = new ProgressDialog(context);
        mProgressBar.setTitle(titleName);
        mProgressBar.setMessage(content);
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressBar.setCancelable(true);
        mProgressBar.show();
    }

    public static void cancelDialog() {
        if (mProgressBar == null) {
            return;
        }
        mProgressBar.cancel();
    }

    public static void dismissDialog() {
        if (mProgressBar == null) {
            return;
        }
        mProgressBar.dismiss();
    }



    //适用于edittext  日期输入   日期已做格式化 2000-01-01；
    public static void showDateDialog(Context context, final EditText editText) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String monthString;
                String dayString;
                if (monthOfYear + 1 < 10) {
                    monthString = "0" + (monthOfYear + 1);
                } else {
                    monthString = String.valueOf(monthOfYear + 1);
                }
                if (dayOfMonth < 10) {
                    dayString = "0" + dayOfMonth;
                } else {
                    dayString = String.valueOf(dayOfMonth);
                }
                String date = String.valueOf(year) + "-" + monthString + "-" + dayString;
                editText.setText(date);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    /**
     * LWH 2016-07-17
     * 显示错误提示
     *
     * @param title   提示标题
     * @param message 提示内容
     */
    public static void showErrorAlertDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(message);
        builder.setPositiveButton("确定", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}