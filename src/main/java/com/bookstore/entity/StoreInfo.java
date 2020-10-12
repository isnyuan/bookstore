package com.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreInfo {

    /***
     * 当前登录用户编号
     */
    private String currentUserCode;

    /**
     * 门店编号
     */
    private String storeCode;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 营业执照编码
     */
    private String businessCode;

    /**
     * 店长（用户）编号
     */
    private String userCode;

    /**
     * 店长名称
     */
    private String userName;

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
     * 电话（门店联系电话）
     */
    private String phone;


    /**
     * 详细地址
     */
    private String address;

    /**
     * 门店邀请码
     */
    private String inviteCode;

    /**
     * 门店账号（店长账号）
     */
    private String userAccount;

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
