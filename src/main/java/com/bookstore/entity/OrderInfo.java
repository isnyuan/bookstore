package com.bookstore.entity;

/**
 * 作者：李丹涛
 * 时间：2020/04/20下午13：33分
 * 功能：订单管理实体类信息
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo {

    /**
     * 下单人
     */
    private String payUser;

    /**
     * 下单人手机号
     */
    private String payPhone;

    /**
     * maplist
     */
    private List<Map> mapList;

    /**
     * 用户角色（管理员0，店长1）
     */
    private String userRole;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单编码
     */
    private String orderCode;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 总金额
     */
    private String sumPrice;

    /**
     * 售价
     */
    private String goodsPrice;

    /**
     * 定价
     */
    private String goodsCostPrice;

    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 购买数量
     */
    private String pucharNum;

    /**
     * 客户账号
     */
    private String userAccount;

    /**
     * 门店编码
     */
    private String storeCode;

    /**
     * 下单人姓名
     */
    private String userName;

    /**
     * 下单人手机号
     */
    private String userPhone;

    /**
     * 确认付款时间
     */
    private String payTime;

    /**
     * 付款时间开始
     */
    private String payStartTime;

    /**
     * 付款时间截止
     */
    private String payEndTime;

    /**
     * 当前登录角色
     */
    private String role;

    /**
     * 订单状态0已下单，1已取消，2已到货，3已取货，4已完成未评价，5已完成已评价
     */
    private String orderActive;

    /**
     * 支付状态,0未支付，1支付
     */
    private String isPay;


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
