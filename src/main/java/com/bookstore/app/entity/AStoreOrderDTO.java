package com.bookstore.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：45分
 * 功能：多参传递dto实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AStoreOrderDTO {

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

}
