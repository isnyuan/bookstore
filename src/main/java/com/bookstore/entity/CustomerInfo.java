package com.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述: 客户信息
 * @Author: lihuizong
 * @Date: 2020/9/21 15:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfo {

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户性别：0表示男1表示女
     */
    private String userSex;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 身份证
     */
    private String userIdCard;

    /**
     * 用户角色（3客户）
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
