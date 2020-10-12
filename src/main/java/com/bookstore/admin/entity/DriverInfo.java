package com.bookstore.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述: 司机管理信息
 * @Author: lihuizong
 * @Date: 2020/9/22 12:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverInfo {

    /**
     * 前端传进来的driverCode
     */
    private String outDriverCode;

    /**
     * 前端传经来的userName
     */
    private String outUserName;

    /**
     * 司机姓名
     */
    private String userName;

    /**
     * 司机编号
     */
    private String driverCode;

    /**
     * 联系电话（司机电话）
     */
    private String phone;


    /**
     * 用户头像
     */
    private String userProfile;

    /**
     * 司机账号
     */
    private String userAccount;

    /**
     * 司机密码
     */
    private String userPassword;

    /**
     * 司机新密码
     */
    private String rawUserPassword;

    /**
     * 身份证号
     */
    private String userIdCard;

    /**
     * 省级编号
     */
    private String provinceCode;

    /**
     * 省级名称
     */
    private String provinceName;

    /**
     * 市级编号
     */
    private String cityCode;

    /**
     * 市级名称
     */
    private String cityName;

    /**
     * 区级编号
     */
    private String areaCode;

    /**
     * 区级名称
     */
    private String areaName;

    /**
     * 角色编号（当前登录的角色）
     */
    private String role;
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

}
