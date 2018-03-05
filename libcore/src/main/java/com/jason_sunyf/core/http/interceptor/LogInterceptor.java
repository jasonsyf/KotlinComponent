package com.jason_sunyf.core.http.interceptor;

import android.support.annotation.NonNull;
import android.util.Log;

import com.jason_sunyf.core.appbase.Config;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * 网络请求拦截器
 * Created by LWH on 2017/8/23.
 */
public class LogInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        StringBuilder requestStr = new StringBuilder();
        //请求参数
        Request request = chain.request();
        long t1 = System.nanoTime();//请求发起的时间
        requestStr.append("---url:").append(request.url())
                .append("\n").append("method:").append(request.method());
        RequestBody requestBody = request.body();
        Connection connection = chain.connection();
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        requestStr.append("\n").append("protocol:").append(protocol);
        Buffer bufferRequest = new Buffer();
        if (requestBody != null) {
            requestStr.append("\n").append("Content-Type:").append(requestBody.contentType());
            requestStr.append("\n").append("Content-Length:").append(requestBody.contentLength());
            requestBody.writeTo(bufferRequest);
            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            if (charset != null) {
                requestStr.append("\n").append("requestBody:").append(bufferRequest.readString(charset)).append("\n");
            }
        }
        //返回结果
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();//请求结束的时间
        requestStr.append("\n").append("reponseCode:").append(response.code())
                .append("\n").append("isSuccessful:").append(response.isSuccessful())
                .append("\n").append("responseTime:").append((t2 - t1) / 1e6d).append("ms");
        ResponseBody responseBody = response.peekBody(1024 * 1024);
        requestStr.append("\n").append("Content-Type:").append(responseBody.contentType());
        requestStr.append("\n").append("Content-Length:").append(responseBody.contentLength());
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE); // Buffer the entire body.
        Buffer bufferResponse = source.buffer();
        Charset charset = UTF8;
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(charset);
        }
        if (charset != null) {
            requestStr.append("\n").append("responseBody:").append(bufferResponse.readString(charset)).append("\n");
        }
        //这里不能直接使用response.body().string()的方式输出日志
        Log.d(Config.NetWork, requestStr.toString());
        return response;
    }
}
