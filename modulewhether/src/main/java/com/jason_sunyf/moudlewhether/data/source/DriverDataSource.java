package com.jason_sunyf.moudlewhether.data.source;

import android.support.annotation.NonNull;

import com.jason_sunyf.moudlewhether.data.Driver;

import java.util.List;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月30日17时26分
 * E-mail  : jason_sunyf@163.com
 */
public interface DriverDataSource {
    /**
     * 加载Driver的回调
     */
    interface loadDriverCallBack{
        /**
         * 当Drivers 加载时
         * @param drivers drivers
         */
        void onDriversLoaded(List<Driver> drivers);

        void onDataNotAvailable();
    }

    /**
     * 获取Driver的回调
     */
    interface GetDriverCallBack{
        /**
         * dang driver load
         * @param driver driver
         */
        void onDriverLoaded(Driver driver);

        void onDataNotAvailable();
    }

    void getDrivers(@NonNull loadDriverCallBack callback);

    void getDriverByName(@NonNull String driverName, @NonNull GetDriverCallBack callback);

    void getDriverByMobile(@NonNull String driverMobile, @NonNull GetDriverCallBack callback);

    void insertDriver(@NonNull Driver driver);


    void deleteAllDrivers();

}
