package com.bookstore.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述: 购物车实体类型信息
 * @Author: lihuizong
 * @Date: 2020/10/19 16:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AShopCarInfo {

    /**
     * 购物车编号
     */
    private String shopCarCode;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品购买数量
     */
    private String goodsCount;

    /**
     * 商品图片路径
     */
    private String goodsImagePath;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 商品名称
     */
    private String goodsName;

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

    /**
     * 属于哪家商店
     */
    private String storeCode;

}
