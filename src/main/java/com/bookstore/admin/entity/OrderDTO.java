package com.bookstore.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    //订单编号列表
    private List<String> orderCodeList;

    //版本号列表
    private List<String> versionList;

    //订单状态编号.取消订单1，订单到货2，取消到货0，订单已取货3，取消已取货2）
    private String orderActive;

    //修改者
    private String lastUpdateUser;

    //订单id
    private String orderId;

    //订单编码
    private String orderCode;

    //用户编号
    private String userCode;

    //总金额
    private String sumPrice;

    //售价
    private String goodsPrice;

    //定价
    private String goodsCostPrice;

    //商品编码
    private String goodsCode;

    //商品名称
    private String goodsName;

    //购买数量
    private String pucharNum;

}
