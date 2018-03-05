package com.jason_sunyf.core.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.jason_sunyf.core.R;
import com.jason_sunyf.core.util.ActivityManager;
import com.jason_sunyf.core.util.DialogUtil;
import com.jason_sunyf.core.util.ToastUtil;
import com.jason_sunyf.core.view.LoadingProgressDialog;

/**
 * activity基类
 * @author Jason_Sunyf
 * @date 2017/12/16 0016
 * Email： jason_sunyf@163.com
 */

public abstract class BaseActivity<T extends BasePresenter>  extends AppCompatActivity implements BaseView {
    protected ActionBar mActionBar;
    protected TextView mActionBarReturnTv;
    protected TextView mActionBarTitleTv;
    protected TextView mSettingTv;
    LoadingProgressDialog mLoadingProgressDialog;
    protected T mPresenter;

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        //减少window图层overdraw
        getWindow().setBackgroundDrawable(null);
        // 默认软键盘不弹出
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        //activity添加进栈
        ActivityManager.getInstance().addActivity(this);
        initBaseActionBar();
        initBaseView();
        mLoadingProgressDialog=new LoadingProgressDialog(this);
    }


    @Override
    public void setContentView(int layoutResID) {
        View view = getLayoutInflater().inflate(layoutResID, null);
        setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initDataAndEvent();
    }
    protected abstract void initPresenter();


    protected abstract void initDataAndEvent();

    //自定义actionbar
    protected void initBaseActionBar() {
        mActionBar = getSupportActionBar();
        if (mActionBar == null) {
            return;
        }
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        mActionBar.setCustomView(R.layout.actionbar_base);
        mActionBar.setElevation(0);
    }

    /**
     * Created by LWH at 2017/4/8 0008 下午 5:48
     * 初始化视图控件
     */
    private void initBaseView() {
        mActionBarReturnTv = (TextView) findViewById(R.id.actionbar_returnTv);
        mActionBarTitleTv = (TextView) findViewById(R.id.actionbar_titleTv);
        mSettingTv = (TextView) findViewById(R.id.actionbar_settingTv);
        mActionBarReturnTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    /**
     * Created by LWH at 2017/4/8 0008 下午 5:48
     * 初始化视图控件
     */
    public void initNoBackBaseView() {
        mActionBarReturnTv = (TextView) findViewById(R.id.actionbar_returnTv);
        mActionBarTitleTv = (TextView) findViewById(R.id.actionbar_titleTv);
        mSettingTv = (TextView) findViewById(R.id.actionbar_settingTv);
    }

    @Override
    public void showErrorMsg(String msg) {
        ToastUtil.showToast(msg);
    }

    @Override
    public void showLoading() {
        mLoadingProgressDialog.show();
    }

    @Override
    public void hiddenLoading() {
        mLoadingProgressDialog.dismiss();
    }

    /**
     * Created by LWH at 2017/4/7 0007 下午 2:35
     * 跳转有参数传递的界面
     */
    @Override
    public void startActivity(Class<?> tClass, Bundle bundle) {
        Intent intent = new Intent(getContext(), tClass);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * Created by LWH at 2017/4/7 0007 下午 2:36
     * 跳转界面
     */
    @Override
    public void startActivity(Class<?> tClass) {
        Intent intent = new Intent(getContext(), tClass);
        startActivity(intent);
    }

    @Override
    public void startActivityForResult(Class<?> tClass, Bundle bundle, int requestCode) {
        Intent intent = new Intent(getContext(), tClass);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    public void startActivityForResult(Class<?> tClass, int requestCode) {
        Intent intent = new Intent(getContext(), tClass);
        startActivityForResult(intent, requestCode);
    }

    /**
     * Created by LWH at 2017/4/7 0007 下午 2:37
     * 获取页面上下文
     */
    @Override
    public Context getContext() {
        return this;
    }

    /**
     * Created by LWH at 2017/11/13 10:09
     * 隐藏软键盘
     */
    protected void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        // edit.setCursorVisible(false);//失去光标
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
        DialogUtil.dismissDialog();
    }

}
