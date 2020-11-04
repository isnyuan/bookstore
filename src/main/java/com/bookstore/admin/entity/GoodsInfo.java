package com.bookstore.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 功能描述:商品信息实体类
 * @Author: lihuizong
 * @Date: 2020/9/23 19:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfo {

    /**
     * List<Map>映射参数
     */
    private List<Map> mapList;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 定价
     */
    private String goodsCostPrice;

    /**
     * 售价
     */
    private String goodsPrice;

    /**
     * 销售量
     */
    private String goodsSallNum;

    /**
     * 一级分类编号
     */
    private String firstCateCode;

    /**
     * 二级分类编号
     */
    private String secondCateCode;

    /**
     * 一级分类名称
     */
    private String firstCateName;

    /**
     * 二级分类名称
     */
    private String secondCateName;

    /**
     * 广告词
     */
    private String goodsAdvertise;

    /**
     * 商品介绍
     */
    private String goodsIntroduce;

    /**
     * 商品状态（在售1、已下架2、未发布3（格式：商品状态+状态编号））
     */
    private String goodsActive;

    /**
     * 上架时间
     */
    private String goodsStartTime;

    /**
     * 浏览量
     */
    private String goodsViewNum;

    /**
     * 商家名称
     */
    private String sallerName;

    /**
     * isbn书号
     */
    private String isbn;

    /**
     * 作者
     */
    private String goodsAuthor;

    /**
     * 出版社
     */
    private String goodsPublish;

    /**
     * 图片（图片路径）
     */
    private String goodsImagePath;

    /**
     * 库存
     */
    private String goodsStock;

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
