package com.bookstore.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 作者：李丹涛
 * 时间：2020/04/21晚上22：53分
 * 功能：app订单管理DTO实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AOrderDTO {

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品购买数量
     */
    private String goodsCount;

    /**
     * 商品价格列表
     */
    private List<String> goodsPriceList;

    /**
     * 订单状态
     */
    private String orderActive;

    /**
     * 页码
     */
    private int PageNum;

    /**
     * 页数量
     */
    private int PageSize;

    /**
     * 总数量
     */
    private int total;

    /**
     * 库存mapList
     */
    private List<Map> stockMapList;

    /**
     * 商品编号列表
     */
    private List<String> goodsCodeList;

    /**
     * 商品数量列表
     */
    private List<String> goodsCountList;

    /**
     * 商品合计列表
     */
    private List<String> goodsSumPriceList;

    /**
     * 购物车编号
     */
    private List<String> shopCarCodeList;

    /**
     * 商品价格
     */
    private String goodsPrice;

    /**
     * 门店编号
     */
    private String storeCode;

    /**
     * 更新后的库存列表
     */
    private List<Integer> stockList;

    /**
     * 最后一次更新者
     */
    private String lastUpdateUser;

}
