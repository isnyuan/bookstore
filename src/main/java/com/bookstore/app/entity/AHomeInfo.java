package com.bookstore.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：李丹涛
 * 时间：2020/04/14晚上19：58分
 * 功能：首页实体类信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AHomeInfo {

    /**
     * 轮播图片路径
     */
    private String goodsImagePath;

    /**
     * 轮播图展示数量
     */
    private int hotGoodsShowNum;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 版本号
     */
    private String version;

    /**
     * 属于哪家商店
     */
    private String storeCode;
}
