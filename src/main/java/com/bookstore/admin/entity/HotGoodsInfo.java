package com.bookstore.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：李丹涛
 * 时间：2020/04/13中午10：31分
 * 功能：热门商品实体类信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotGoodsInfo {

    /**
     * 展示数量
     */
    private int showNum;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 热门商品编号
     */
    private String hotGoodsCode;

    /**
     * 热门商品排序
     */
    private String hotGoodsSortNum;

    /**
     * 展示数量数量
     */
    private int hotGoodsShowNum;

    /**
     * 页数
     */
    private String pageNum;

    /**
     * 页数
     */
    private String size;

    /**
     * 总数
     */
    private int total;

    /**
     * 展示数量字典编号
     */
    private final String DICTIONARY_CODE = "123456789";

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 商品描述
     */
    private String goodsIntroduce;

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
