package com.jason_sunyf.core.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.jason_sunyf.core.R;

/**
 * Created by Jason_Sunyf on 2017/12/9 0009.
 * Email： jason_sunyf@163.com
 */

public class LoadingProgressDialog extends ProgressDialog {
    public LoadingProgressDialog(Context context) {
        super(context, R.style.Progress_Dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_layout);
    }
}
