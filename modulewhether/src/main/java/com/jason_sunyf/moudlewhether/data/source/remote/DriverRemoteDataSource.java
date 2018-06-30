package com.jason_sunyf.moudlewhether.data.source.remote;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.google.common.collect.Lists;
import com.jason_sunyf.moudlewhether.data.Driver;
import com.jason_sunyf.moudlewhether.data.source.DriverDataSource;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月30日17时47分
 * E-mail  : jason_sunyf@163.com
 */
public class DriverRemoteDataSource implements DriverDataSource {

    private static  DriverRemoteDataSource INSTANCE;

    private static final int SERVICE_LATENCY_IN_MILLIS = 5000;

    private final static Map<String, Driver> DRIVERS_SERVICE_DATA;


    static {
        DRIVERS_SERVICE_DATA = new LinkedHashMap<>(2);
        addDriver("冲冲冲", "15684488745");
        addDriver("2B阳", "15638784512");
    }

    public static DriverRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriverRemoteDataSource();
        }
        return INSTANCE;
    }

    private static void addDriver(String name, String mobile) {
        Driver  newDriver = new Driver(name, mobile);
        DRIVERS_SERVICE_DATA.put(newDriver.getDriverMobile(), newDriver);
    }


    @Override
    public void getDrivers(@NonNull final loadDriverCallBack callback) {
        // Simulate network by delaying the execution.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onDriversLoaded(Lists.newArrayList(DRIVERS_SERVICE_DATA.values()));
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    @Override
    public void getDriverByName(@NonNull String driverName, @NonNull final GetDriverCallBack callback) {
        final Driver driver = DRIVERS_SERVICE_DATA.get(driverName);

        // Simulate network by delaying the execution.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onDriverLoaded(driver);
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    @Override
    public void getDriverByMobile(@NonNull String driverMobile, @NonNull GetDriverCallBack callback) {

    }

    @Override
    public void insertDriver(@NonNull Driver driver) {

    }

    @Override
    public void deleteAllDrivers() {
        DRIVERS_SERVICE_DATA.clear();

    }
}
