package com.sinotech.modulerxjava;

import com.jason_sunyf.core.http.response.BaseResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface TestApis {
    @GET("url")
    Flowable<BaseResponse<String>> getData();
}
