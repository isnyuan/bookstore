package com.bookstore.service;

import com.bookstore.entity.OrderInfo;
import com.bookstore.utils.Response;

/**
 * 功能描述: 订单管理dao接口
 * @Author: lihuizong
 * @Date: 2020/10/10 16:59
 */
public interface OrderService {

    /**
     * 功能描述: 查询订单详情接口,orderDTO为用户form传递的参数接送实体类信息
     * @Author: lihuizong
     * @Date: 2020/10/10 17:00
     */
    public Response findOrder(String orderCode);

    /**
     * 功能描述: 分页查询订单接口，orderInfo为订单实体类信息
     * @Author: lihuizong
     * @Date: 2020/10/10 17:00
     */
    public Response listOrder(OrderInfo orderInfo);

    /**
     * 功能描述: 修改订单状态接口，orderDTO为用户form传递的参数接送实体类信息
     * @Author: lihuizong
     * @Date: 2020/10/10 17:00
     */
    public Response updateOrderActive(String orderCode, String version, String orderActive);

}
