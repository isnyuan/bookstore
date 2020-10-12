package com.bookstore.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    /**
     * 用户编码
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
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户角色（0表示管理员、1表示店长）
     */
    private String userRole;

    /**
     * 用户头像（存入路径）
     */
    private String userProfile;

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
