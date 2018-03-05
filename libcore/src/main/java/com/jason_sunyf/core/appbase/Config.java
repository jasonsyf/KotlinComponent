package com.jason_sunyf.core.appbase;

import android.os.Environment;

import java.io.File;

/**
 * the more diligent, the more luckier you are !
 * ---------------------------------------------
 /**
 *
 * @author Jason_Sunyf
 * @date 2017/12/16 0016
 * Email： jason_sunyf@163.com
 * @des 重要的配置信息
 */

public class Config {
    public final static String BaseIP = "http://v.juhe.cn/";
    public final static String GANKAPI = " http://gank.io/api/";
    //app 名称
    public static String AppName = "SinoTech_Truck_ZZGLG_DRIVER";
    //app 版本信息 根据这个来判断是否更新
    public static String AppVersion = "1001";
    //保存用户信息账号密码 sp 关键字
    public static String UserKey = "save_user";
    //保存用户登录成功账号信息 sp 关键字
    public static String UserKry = "save_user_info";
    //保存用户绑定信息 sp 关键字
    public static String TruckKey = "save_truck_info";
    //网路请求 Log 关键字
    public final static String NetWork = "HTTP_NetWork";
    //异常报错类型  3  表示手机端
    public static String AppError = "3";
    //刷新数据间隔
    public static int OrderDateRefreshTime = 25000;
    //清单界面位置刷新时间
    public static int LocationRefreshTime = 25000;
    /**
     * 百度地图IP
     */
    public static String BaiDu_IP = "http://api.map.baidu.com/";

    //================= PATH ====================
    public static final String PATH_DATA = BaseApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "test" + File.separator + "testcomponent";



}
