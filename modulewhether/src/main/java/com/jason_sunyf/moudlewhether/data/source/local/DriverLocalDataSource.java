package com.jason_sunyf.moudlewhether.data.source.local;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.jason_sunyf.moudlewhether.data.Driver;
import com.jason_sunyf.moudlewhether.data.source.DriverDataSource;
import com.jason_sunyf.moudlewhether.util.AppExecutors;

import java.util.List;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月30日17时23分
 * E-mail  : jason_sunyf@163.com
 */
public class DriverLocalDataSource implements DriverDataSource {
    private static volatile DriverLocalDataSource INSTANCE;

    private DriverDao mDriverDao;

    private AppExecutors mAppExecutors;

    private DriverLocalDataSource(@NonNull AppExecutors appExecutors,
                                 @NonNull DriverDao driverDao) {
        mAppExecutors = appExecutors;
        mDriverDao = driverDao;
    }

    public static DriverLocalDataSource getInstance(@NonNull AppExecutors appExecutors,
                                                   @NonNull DriverDao driverDao) {
        if (INSTANCE == null) {
            synchronized (DriverLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DriverLocalDataSource(appExecutors, driverDao);
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public void getDrivers(@NonNull final loadDriverCallBack callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Driver> drivers = mDriverDao.getDrivers();
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (drivers.isEmpty()) {
                            // This will be called if the table is new or just empty.
                            callback.onDataNotAvailable();
                        } else {
                            callback.onDriversLoaded(drivers);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);

    }

    @Override
    public void getDriverByName(@NonNull final String driverName, @NonNull final GetDriverCallBack callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Driver driver = mDriverDao.gerDriverByName(driverName);
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (driver != null) {
                            callback.onDriverLoaded(driver);
                        } else {
                            callback.onDataNotAvailable();
                        }
                    }
                });
            }
        };

        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void getDriverByMobile(@NonNull final String driverMobile, @NonNull final GetDriverCallBack callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final Driver driver = mDriverDao.getDriverByMobile(driverMobile);
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (driver != null) {
                            callback.onDriverLoaded(driver);
                        } else {
                            callback.onDataNotAvailable();
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);

    }

    @Override
    public void insertDriver(@NonNull final Driver driver) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                mDriverDao.insertDriver(driver);
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void deleteAllDrivers() {
        Runnable deleteRunnable = new Runnable() {
            @Override
            public void run() {
                mDriverDao.deleteDrivers();
            }
        };

        mAppExecutors.diskIO().execute(deleteRunnable);
    }

    @VisibleForTesting
    static void clearInstance() {
        INSTANCE = null;
    }
}
