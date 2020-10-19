package com.bookstore.app.dao;


import com.bookstore.app.entity.AStoreOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：45分
 * 功能：店长订单管理dao接口
 */

@Mapper
public interface AStoreOrderDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询门店编号
     */
    String findStoreCode(String userCode);


    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     * @return
     */
    List<AStoreOrderInfo> listManagerOrdersByPage(@Param("orderActive") String orderActive, @Param("storeCode") String storeCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单详情列表接口
     */
    List<AStoreOrderInfo> listOrderDetail();

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：修改订单状态接口
     */
    int updateOrderActive(AStoreOrderInfo storeOrderInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    List<AStoreOrderInfo> listOrderByPage(@Param("orderCode") String orderCode);




}
