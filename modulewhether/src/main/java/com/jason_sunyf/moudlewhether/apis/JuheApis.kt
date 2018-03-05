package com.jason_sunyf.moudlewhether.apis

import com.jason_sunyf.core.http.response.JhResponse
import com.jason_sunyf.moudlewhether.entity.WhetherByCity

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jason_Sunyf on 2017/12/13 0013.
 * Email： jason_sunyf@163.com
 */

interface JuheApis {
    @GET("weather/index")
    fun getWhether(@Query("cityname") cityname: String,
                   @Query("key") key: String): Flowable<JhResponse<WhetherByCity>>

}