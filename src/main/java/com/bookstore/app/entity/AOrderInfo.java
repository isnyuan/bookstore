package com.bookstore.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：42分
 * 功能：app订单实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AOrderInfo {

    /**
     * 订单详情列表
     */
    private List<AOrderInfo> orderDetailList;

    /**
     * 商品编号
     */
    private String goodsCodeList;

    /**
     * 商品编号列表
     */
    private String newGoodsCodeList;

    /**
     * 平均星级
     */
    private double avgStar;

    /**
     * 商品详情map
     */
    private List<Map> mapList;

    /**
     * 用户编号
     */
    private String userCode;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品数量
     */
    private int goodsCount;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 门店编号
     */
    private String storeCode;

    /**
     * 订单状态
     */
    private String orderActive;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品图片路径
     */
    private String goodsImagePath;

    /**
     * 商品介绍
     */
    private String goodsIntroduce;

    /**
     * 商品合计
     */
    private String goodsSumPrice;

    /**
     * 订单总价
     */
    private double sumPrice;

    /**
     * 支付状态 0:支付，1：未支付
     */
    private String payActive;

    /**
     * 订单商品总数量
     */
    private int pucharNum;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 省编号
     */
    private String provinceCode;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 市编号
     */
    private String cityCode;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 区编号
     */
    private String areaCode;

    /**
     * 区名称
     */
    private String areaName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 支付时间
     */
    private String payTime;

    /**
     * 评价内容
     */
    private String evaluateContent;

    /**
     * 评价等级
     */
    private String evaluateScore;

    /**
     * 评价图片排序
     */
    private String imageSortNum;

    /**
     * 删除标记（1删除、0不删除）
     */
    private String isDelete;

    /**
     * 订单详情编号
     */
    private String orderDetailCode;


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
