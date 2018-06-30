package com.jason_sunyf.moudlewhether.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * @author : Jason_Sunyf
 * @date : 2018年06月30日16时47分
 * E-mail  : jason_sunyf@163.com
 */
@Entity(tableName = "drivers")
public final class Driver {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "driverId")
    private String driverId;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tenantId")
    private String tenantId;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "companyId")
    private String companyId;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "brandId")
    private String brandId;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "lcId")
    private String lcId;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "driverName")
    private String driverName;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "driverMobile")
    private String driverMobile;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idCard")
    private String idCard;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "driverCard")
    private String driverCard;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "driverLevel")
    private String driverLevel;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "remark")
    private String remark;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "driverStatusStr")
    private String driverStatusStr;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "insUser")
    private String insUser;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "insTime")
    private long insTime;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "updUser")
    private String updUser;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "updTime")
    private long updTime;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "driverStatus")
    private String driverStatus;

    public Driver(@NonNull String driverName, @NonNull String driverMobile) {
        this.driverName = driverName;
        this.driverMobile = driverMobile;
    }

    public Driver(@NonNull String driverId, @NonNull String tenantId, @NonNull String companyId,
                  @NonNull String brandId, @NonNull String lcId, @NonNull String driverName,
                  @NonNull String driverMobile, @NonNull String idCard, @NonNull String driverCard,
                  @NonNull String driverLevel, @NonNull String remark, @NonNull String driverStatusStr,
                  @NonNull String insUser, long insTime, @NonNull String updUser,
                  long updTime, @NonNull String driverStatus) {
        this.driverId = driverId;
        this.tenantId = tenantId;
        this.companyId = companyId;
        this.brandId = brandId;
        this.lcId = lcId;
        this.driverName = driverName;
        this.driverMobile = driverMobile;
        this.idCard = idCard;
        this.driverCard = driverCard;
        this.driverLevel = driverLevel;
        this.remark = remark;
        this.driverStatusStr = driverStatusStr;
        this.insUser = insUser;
        this.insTime = insTime;
        this.updUser = updUser;
        this.updTime = updTime;
        this.driverStatus = driverStatus;
    }

    @NonNull
    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(@NonNull String driverId) {
        this.driverId = driverId;
    }

    @NonNull
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(@NonNull String tenantId) {
        this.tenantId = tenantId;
    }

    @NonNull
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(@NonNull String companyId) {
        this.companyId = companyId;
    }

    @NonNull
    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(@NonNull String brandId) {
        this.brandId = brandId;
    }

    @NonNull
    public String getLcId() {
        return lcId;
    }

    public void setLcId(@NonNull String lcId) {
        this.lcId = lcId;
    }

    @NonNull
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(@NonNull String driverName) {
        this.driverName = driverName;
    }

    @NonNull
    public String getDriverMobile() {
        return driverMobile;
    }

    public void setDriverMobile(@NonNull String driverMobile) {
        this.driverMobile = driverMobile;
    }

    @NonNull
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(@NonNull String idCard) {
        this.idCard = idCard;
    }

    @NonNull
    public String getDriverCard() {
        return driverCard;
    }

    public void setDriverCard(@NonNull String driverCard) {
        this.driverCard = driverCard;
    }

    @NonNull
    public String getDriverLevel() {
        return driverLevel;
    }

    public void setDriverLevel(@NonNull String driverLevel) {
        this.driverLevel = driverLevel;
    }

    @NonNull
    public String getRemark() {
        return remark;
    }

    public void setRemark(@NonNull String remark) {
        this.remark = remark;
    }

    @NonNull
    public String getDriverStatusStr() {
        return driverStatusStr;
    }

    public void setDriverStatusStr(@NonNull String driverStatusStr) {
        this.driverStatusStr = driverStatusStr;
    }

    public String getInsUser() {
        return insUser;
    }

    public void setInsUser(String insUser) {
        this.insUser = insUser;
    }

    public long getInsTime() {
        return insTime;
    }

    public void setInsTime(long insTime) {
        this.insTime = insTime;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public long getUpdTime() {
        return updTime;
    }

    public void setUpdTime(long updTime) {
        this.updTime = updTime;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }


}
