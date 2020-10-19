package com.bookstore.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AUserInfo {

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userImagePath;

    /**
     * 用户角色
     */
    private String role;

    /**
     * 门店编号
     */
    private String storeCode;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 省级名称
     */
    private String provinceName;

    /**
     * 市级名称
     */
    private String cityName;

    /**
     * 区级名称
     */
    private String areaName;

    /**
     * 司机名称
     */
    private String driverName;

    /**
     * 门店邀请码
     */
    private String inviteCode;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 手机号
     */
    private String phone;


    /**
     * 删除标记（1删除、0不删除）
     */
    private String isDelete;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 最后一次更新者
     */
    private String lastUpdateUser;

    /**
     * 最后一次更新时间
     */
    private String lastUpdateTime;

    /**
     * 版本
     */
    private String version;

    /**
     * 原密码
     */
    private String userPassword;

    /**
     * 新密码
     */
    private String userNewPassword;

}
