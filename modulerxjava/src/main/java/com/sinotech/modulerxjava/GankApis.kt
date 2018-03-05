package com.sinotech.modulerxjava

import com.jason_sunyf.core.http.response.GankResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

/**
 * @author : Jason_Sunyf
 * @date   : 2018年02月28日14时48分
 * E-mail  : jason_sunyf@163.com
 */
interface GankApis {
    @GET("data/{type}/{pageSize}/{pageNum}")
    fun getGankData(@Path("type")     type: String,
                    @Path("pageSize") pageSize: String,
                    @Path("pageNum")  pageNum: String):Flowable<GankResponse<MutableList<GankItem>>>

    @GET("day/{year}/{month}/{day}")
    fun getDataForDate(@Path("year") year:String,
                       @Path("month") month:String,
                       @Path("day") day:String):Flowable<MutableList<GankItem>>

}