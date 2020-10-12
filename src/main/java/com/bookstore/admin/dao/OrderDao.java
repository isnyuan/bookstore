package com.bookstore.admin.dao;

import com.bookstore.admin.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/13凌晨00：39分
 * 功能：订单管理dao接口
 */

@Mapper
public interface OrderDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：查询订单详情接口,orderDTO为用户form传递的参数接送实体类信息
     */
    List<OrderInfo> findOrder(String orderCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：分页查询订单接口，orderInfo为订单实体类信息
     * listOrderByPage：管理员查全部
     * listOrderStoreByPage：店长查自己的门下的订单
     */
    List<OrderInfo> listOrderByPage(OrderInfo orderInfo);
    List<OrderInfo> listOrderStoreByPage(OrderInfo orderInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：修改订单状态接口，orderInfo为订单实体类信息
     */
    int updateOrderActive(OrderInfo orderInfo);

}
