package com.jason_sunyf.moudlewhether.data.source.local;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.jason_sunyf.moudlewhether.data.Driver;

import java.util.List;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月30日16时56分
 * E-mail  : jason_sunyf@163.com
 */
public interface DriverDao {

    /**
     * 获取所有的驾驶员信息
     *
     * @return List<Driver
                    */
    @Query("SELECT * FROM drivers")
    List<Driver> getDrivers();


    /**
     * 根据手机号获取驾驶员信息
     *
     * @param driverMobile 驾驶员手机号
     * @return Driver
     */
    @Query("SELECT * FROM drivers WHERE driverMobile=:driverMobile")
    Driver getDriverByMobile(String driverMobile);

    /**
     * 根据姓名获取驾驶员信息
     *
     * @param driverName 驾驶员姓名
     * @return Driver
     */
    @Query("SELECT * FROM DRIVERS WHERE driverName=:driverName")
    Driver gerDriverByName(String driverName);

    /**
     * 插入一个Driver信息到数据库，如果Driver已经存在，替换他
     *
     * @param driver 驾驶员信息
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDriver(Driver driver);

    /**
     * 删除所有Driver信息
     */
    @Query("DELETE FROM drivers")
    void deleteDrivers();
}
