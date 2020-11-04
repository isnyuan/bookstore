package com.bookstore.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: 商品详情实体类信息
 * @Author: lihuizong
 * @Date: 2020/10/19 14:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AGoodsInfo {

    /**
     * 评价编号
     */
    private String goodsEvaluateCode;

    /**
     * 二级商品分类
     */
    private List<Map<String, String>> listSecondCate;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 评价内容
     */
    private String goodsEvaluateContent;

    /**
     * 评价时间
     */
    private String goodsEvaluateTime;

    /**
     * 二级分类下商品列表
     */
    private List<AGoodsInfo> goodsInfoList;

    /**
     * 一级分类编号
     */
    private String firstCateCode;

    /**
     * 二级分类编号
     */
    private String secondCateCode;

    /**
     * 商品分类编号
     */
    private String goodsCateCode;


    /**
     * 商品分类名称
     */
    private String goodsCateName;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 书号
     */
    private String isbn;

    /**
     * 商品介绍
     */
    private String goodsIntroduce;

    /**
     * 售价
     */
    private String goodsPrice;

    /**
     * 商品图片路径
     */
    private String goodsImagePath;

    /**
     * 商品评价等级
     */
    private String goodsEvaluateScore;

    /**
     * 商品评价图片
     */
    private String goodsEvaluateImage;

    /**
     * 作者
     */
    private String goodsAuthor;

    /**
     * 出版社
     */
    private String goodsPublish;

    /**
     * 用户编号
     */
    private String userCode;

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
