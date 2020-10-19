package com.bookstore.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述: 店长个人信息之查询司机信息管理实体类信息
 * @Author: lihuizong
 * @Date: 2020/10/19 15:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AStoreInfo {

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号
     */
    private String phone;

}
