package com.jason_sunyf.core.http;


import com.jason_sunyf.core.appbase.BaseApplication;
import com.jason_sunyf.core.appbase.Config;
import com.jason_sunyf.core.http.interceptor.LogInterceptor;
import com.jason_sunyf.core.http.sslauthen.HttpsUtil;
import com.jason_sunyf.core.http.sslauthen.SSLHelper;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * the more diligent, the more luckier you are !
 * 越勤奋,你就越幸运
 * ---------------------------------------------
 * Created by Jason_Sunyf on 2017/12/16 0016.
 * Email： jason_sunyf@163.com
 *
 */

public class RetrofitUtil {
    private static Retrofit retrofit;
    private static Retrofit retrofit1;

    public static Retrofit init() {
        if (retrofit == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit
                            .Builder()
                            .baseUrl(getBaseUrl())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(getClient())
                            .build();
                }
            }
        }
        return retrofit;
    }
    public static Retrofit init(String baseUrl) {
        if (retrofit1 == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofit1 == null) {
                    retrofit1 = new Retrofit
                            .Builder()
                            .baseUrl(baseUrl)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(getClient())
                            .build();
                }
            }
        }
        return retrofit1;
    }

    private static String getBaseUrl() {
        return Config.BaseIP;
    }

    /**
     * Created by LWH at 2017/8/24 00:16
     * 设置client和拦截器
     */
    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
//                .sslSocketFactory(SSLHelper.getSSLCertifcation(BaseApplication.getInstance()), new HttpsUtil.UnSafeTrustManager())
//                .hostnameVerifier(new HttpsUtil.UnSafeHostnameVerifier())//由于还没有域名，此处设置忽略掉域名校验
                .build();
    }
}
