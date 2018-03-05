package com.jason_sunyf.core.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Administrator on 2017/11/15.
 */
public class ProgressDialogUtil {
    private static ProgressDialog progressDialog;

    public static void createDialog(Context context, String title) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgress(0);
        progressDialog.setTitle(title);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.show();
    }

    public static void setProgress(int progress) {
        progressDialog.setProgress(progress);
    }

    public static void cancelDialog() {
        if (progressDialog == null) {
            return;
        }
        progressDialog.cancel();
    }
}