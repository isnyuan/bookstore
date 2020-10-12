package com.bookstore.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuInfo {
    /**
     * 菜单编号
     */
    private String menuCode;

    /**
     * 菜单路由
     */
    private String menuPath;

    /**
     * 菜单备注
     */
    private String menuRemark;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 用户角色（管理员0、店长1）
     */
    private String userRole;

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
