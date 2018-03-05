package com.jason_sunyf.core.http.rxfamily;


import android.util.Log;

import com.google.gson.Gson;
import com.jason_sunyf.core.http.exception.ApiException;
import com.jason_sunyf.core.http.response.GankResponse;
import com.jason_sunyf.core.http.response.JhResponse;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jason_Sunyf on 2017/12/9 0009.
 * Email： jason_sunyf@163.com
 */
public class RxUtil {

//      ====================================Observable================================================
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> rxObserverSchedulerHelper() {    //compose简化线程
        return new ObservableTransformer<T, T>() {
            @Override
            public Observable<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */

    public static <T> ObservableTransformer<JhResponse<T>,T > handleObserverResult() {   //compose判断结果
        return httpResponseFlowable -> httpResponseFlowable.flatMap(tJhResponse -> {
            if ("200".equals(tJhResponse.getResultcode())) {
                Log.i("onNext", "onNext: "+new Gson().toJson(tJhResponse));
                return createObserverData(tJhResponse.getResult());
            } else {
                return Observable.error(new ApiException(tJhResponse.getReason(),
                       tJhResponse.getError_code()));
            }
        });
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */

    public static <T> ObservableTransformer<GankResponse<T>,T > handleGankObserverResult() {   //compose判断结果
        return httpResponseFlowable -> httpResponseFlowable.flatMap(tJhResponse -> {
            if (!tJhResponse.getError()) {
                Log.i("onNext", "onNext: "+new Gson().toJson(tJhResponse));
                return createObserverData(tJhResponse.getResults());
            } else {
                return Observable.error(new ApiException("error",
                        1000));
            }
        });
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<JhResponse<T>,T > handleObserverObjectResult() {   //compose判断结果
        return httpResponseFlowable -> httpResponseFlowable.flatMap(tJhResponse -> {
            if ("200".equals(tJhResponse.getResultcode())) {
                return createObserverData((T) tJhResponse);
            } else {
                return Observable.error(new ApiException(tJhResponse.getReason(),
                        tJhResponse.getError_code()));
            }
        });
    }

    /**
     * 生成Flowable
     *
     * @param t baseresponse
     * @return
     */
    public static <T> Observable<T> createObserverData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }

//      ====================================Flowable================================================
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> tFlowable) {
                return tFlowable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<JhResponse<T>,T > handleResult() {   //compose判断结果
        return (Flowable<JhResponse<T>> httpResponseFlowable) -> httpResponseFlowable.flatMap(new Function<JhResponse<T>, Publisher<? extends T>>() {
            @Override
            public Publisher<? extends T> apply(JhResponse<T> tJhResponse) throws Exception {
                if ("200".equals(tJhResponse.getResultcode())) {
                    Log.i("onNext", "onNext: " + new Gson().toJson(tJhResponse));
                    return createData(tJhResponse.getResult());
                } else {
                    return Flowable.error(new ApiException(tJhResponse.getReason(),
                            tJhResponse.getError_code()));
                }
            }
        });
    }
    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<GankResponse<T>,T > handleGankResult() {   //compose判断结果
        return (Flowable<GankResponse<T>> httpResponseFlowable) -> httpResponseFlowable.flatMap(new Function<GankResponse<T>, Publisher<? extends T>>() {
            @Override
            public Publisher<? extends T> apply(GankResponse<T> tJhResponse) throws Exception {
                if (!tJhResponse.getError()) {
                    Log.i("onNext", "onNext: " + new Gson().toJson(tJhResponse));
                    return createData(tJhResponse.getResults());
                } else {
                    return Flowable.error(new ApiException("",
                           -1));
                }
            }
        });
    }


    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<JhResponse<T>,T > handleObjectResult() {   //compose判断结果
        return httpResponseFlowable -> httpResponseFlowable.flatMap(tJhResponse -> {
            if ("200".equals(tJhResponse.getResultcode())) {
                return createData((T) tJhResponse);
            } else {
                return Flowable.error(new ApiException(tJhResponse.getReason(), tJhResponse.getError_code()));
            }
        });
    }
 
    /**
     * 生成Flowable
     *
     * @param t baseresponse
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}
