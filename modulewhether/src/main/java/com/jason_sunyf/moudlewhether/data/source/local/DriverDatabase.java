package com.jason_sunyf.moudlewhether.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.jason_sunyf.moudlewhether.data.Driver;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月30日17时13分
 * E-mail  : jason_sunyf@163.com
 */
@Database(entities = {Driver.class}, version = 1)
public abstract class DriverDatabase extends RoomDatabase {
    private static DriverDatabase INSTANCE;

    /**
     * DriverDao 抽象类
     *
     * @return driverDao
     */
    public abstract DriverDao driverDao();

    private static final Object sLock = new Object();

    public static DriverDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        DriverDatabase.class, "drivers.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
