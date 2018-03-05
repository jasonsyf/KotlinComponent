package com.jason_sunyf.core.cache;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.jason_sunyf.core.http.entity.User;
import com.jason_sunyf.core.util.LogUtils;
import com.jason_sunyf.core.util.X;

/**
 * 用户信息缓存
 * @author Administrator
 * @date 2017/11/14
 */

public class SharedPreferencesUser {
    private static SharedPreferencesUser mInstance;
    private final static String TAG = SharedPreferencesUser.class.getName();

    public static SharedPreferencesUser getInstance() {
        if (mInstance == null) {
            synchronized (SharedPreferencesUser.class) {
                if (mInstance == null) {
                    mInstance = new SharedPreferencesUser();
                }
            }
        }
        return mInstance;
    }

    private final String userId = "userId";
    private final String userCode = "userCode";
    private final String password = "password";
    private final String userName = "userName";
    private final String billDeptName = "billDeptName";
    private final String shipperAddr = "shipperAddr";

    public void saveUser(User user) {
        LogUtils.i(TAG, "---user:" + new Gson().toJson(user));
        SharedPreferences.Editor sharedData = X.app().getSharedPreferences(User.class.getName(),
                Context.MODE_PRIVATE).edit();
        sharedData.putString(userId, user.CustId);
        sharedData.putString(userCode, user.CustCode);
        sharedData.putString(password, user.CustPassword);
        sharedData.putString(userName, user.CustName);
        sharedData.putString(billDeptName, user.BillDeptName);
        sharedData.putString(shipperAddr, user.CustAddr);
        boolean commit = sharedData.commit();
    }

    public User getUser() {
        SharedPreferences shareds = X.app().getSharedPreferences(User.class.getName(), Context.MODE_PRIVATE);
        if (shareds == null) {
            return null;
        }
        User user = new User();
        user.CustId = shareds.getString(userId, user.CustId);
        user.CustCode = shareds.getString(userCode, user.CustCode);
        user.CustPassword = shareds.getString(password, user.CustPassword);
        user.CustName = shareds.getString(userName, user.CustName);
        user.BillDeptName = shareds.getString(billDeptName, user.BillDeptName);
        user.CustAddr = shareds.getString(shipperAddr, user.CustAddr);
        return user;
    }

    /**
     * 清除登录信息缓存
     *
     * @param context 上下文
     */
    public void clearUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(User.class.getName(),
                Context.MODE_PRIVATE);
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
