package com.jason_sunyf.moudlewhether.data.source;

import android.support.annotation.NonNull;

import com.jason_sunyf.moudlewhether.data.Driver;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月30日17时42分
 * E-mail  : jason_sunyf@163.com
 */
public class DriverRepository implements DriverDataSource {


    @Override
    public void getDrivers(@NonNull loadDriverCallBack callback) {

    }

    @Override
    public void getDriverByName(@NonNull String driverName, @NonNull GetDriverCallBack callback) {

    }

    @Override
    public void getDriverByMobile(@NonNull String driverMobile, @NonNull GetDriverCallBack callback) {

    }

    @Override
    public void insertDriver(@NonNull Driver driver) {

    }

    @Override
    public void deleteAllDrivers() {

    }
}
