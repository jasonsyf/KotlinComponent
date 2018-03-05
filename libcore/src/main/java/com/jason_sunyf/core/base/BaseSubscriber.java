package com.jason_sunyf.core.base;

import android.util.Log;
import android.widget.Toast;

import com.jason_sunyf.core.http.exception.ApiException;

import java.io.IOException;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * 简化retrofit网络请求,统一异常处理
 * @author Jason_Sunyf
 * @date 2017/12/9 0009
 * Email： jason_sunyf@163.com
 */

public abstract class BaseSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;

    public BaseSubscriber(BaseView view) {
        this.mView = view;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onError(final Throwable e) {
        Log.w("Subscriber onError", e);
        if (e instanceof HttpException) {
            // We had non-2XX http error
            Toast.makeText(mView.getContext(), "http异常", Toast.LENGTH_SHORT).show();
        } else if (e instanceof IOException) {
            // A network or conversion error happened
            Toast.makeText(mView.getContext(), "IO异常", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ApiException) {
            Toast.makeText(mView.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onComplete() {
        mView.hiddenLoading();
    }

}
