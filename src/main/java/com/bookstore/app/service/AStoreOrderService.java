package com.bookstore.app.service;

import com.bookstore.app.entity.AStoreOrderDTO;
import com.bookstore.app.entity.AStoreOrderInfo;
import com.bookstore.utils.Response;

/**
 * 功能描述: 商店订单接口
 * @Author: lihuizong
 * @Date: 2020/10/19 15:14
 */
public interface AStoreOrderService {

    /**
     * 功能描述: 查询订单列表接口
     * @Author: lihuizong
     * @Date: 2020/10/19 15:14
     */
    public Response listManagerOrders(AStoreOrderDTO storeOrderDTO);

    /**
     * 功能描述: 修改店长订单状态接口
     * @Author: lihuizong
     * @Date: 2020/10/19 15:14
     */
    public Response updateManangerOrderState(AStoreOrderInfo storeOrderInfo);

    /**
     * 功能描述: 修改店长订单状态接口
     * @Author: lihuizong
     * @Date: 2020/10/19 15:14
     */
    public Response orderDetail(String orderCode);

}
