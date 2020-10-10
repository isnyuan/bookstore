package com.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopInfo {

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户头像路径
     */
    private String userImagePath;

    /**
     * 用户角色 0管理员、1店长
     * （0可以使用全部的功能模块，
     * 1只能使用以下功能模块:
     * 客户管理模块；
     * 订单管理模块；
     * 门店管理的查询、重置和详情；
     * 司机管理的查询、重置和详情）
     */
    private String role;

}
