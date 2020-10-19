package com.bookstore.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述: 用户注册实体类信息
 * @Author: lihuizong
 * @Date: 2020/10/19 14:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ARegisterInfo {

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户身份证
     */
    private String userIdCard;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户头像
     */
    private String userProfile;

    /**
     * 用户角色 客户 3
     */
    private String userRole;

    /**
     * 门店邀请码
     */
    private String inviteCode;

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
