package com.bookstore.app.entity;


import lombok.Data;

/**
 * 作者：李丹涛
 * 时间：2020/04/15下午15：13
 * 功能：查询司机负责门店，门店得相关信息实体类
 */

@Data
public class ADriverInfo {

    /**
     * 当前登录用户编号
     */
    private String userCode;

    /**
     * 邀请码
     */
    private String inviteCode;

    /**
     * 省
     */
    private String provinceName;

    /**
     * 市
     */
    private String cityName;

    /**
     * 区
     */
    private String areaName;

    /**
     * 门店编号
     */
    private String storeCode;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 门店详细地址
     */
    private String address;

    /**
     * 店长名字
     */
    private String userName;

    /**
     * 店长电话
     */
    private String phone;

}