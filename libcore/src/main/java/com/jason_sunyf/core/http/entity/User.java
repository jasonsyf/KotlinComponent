package com.jason_sunyf.core.http.entity;

import java.io.Serializable;

/**
 * 用户信息
 * Created by Administrator on 2017/11/14.
 */

public class User implements Serializable {
    // 客户ID
    public String CustId;
    // 登陆账号
    public String CustCode;
    // 登录密码
    public String CustPassword;
    // 身份证号
    public String CustIdcard;
    // 发货人
    public String CustName;
    // 发货地址
    public String CustAddr;

    public String AppVersion;
    //开票部门
    public String BillDeptName;
}
