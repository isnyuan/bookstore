package com.bookstore.app.service;

import com.alibaba.fastjson.JSONObject;
import com.bookstore.app.entity.AOrderDTO;
import com.bookstore.app.entity.AOrderInfo;
import com.bookstore.utils.Response;

public interface AOrderService {

    /**
     * 功能描述: 新增订单接口
     *      * 1.判断库存是否满足购买商品数
     *      * 2.判断是否购物车来的，是则要清空购物车对应商品
     *      * 3.下单完成，改变库存
     *      * 4.检查商品购买后数量书否为0，是则改变商品状态为已售完
     * @Author: lihuizong
     * @Date: 2020/10/19 16:11
     */
    public Response addOrder(AOrderDTO orderDTO);

    /**
     * 功能描述: 查询订单列表
     * @Author: lihuizong
     * @Date: 2020/10/19 16:12
     */
    public Response listOrder(AOrderDTO orderDTO);

    /**
     * 功能描述: 修改订单状态
     * @Author: lihuizong
     * @Date: 2020/10/19 16:12
     */
    public Response updateOrderActive(AOrderInfo orderInfo);

    /**
     * 功能描述: 查询订单详情
     * @Author: lihuizong
     * @Date: 2020/10/19 16:12
     */
    public Response orderDetail(String orderCode);

    /**
     * 功能描述: 查询订单评价商品信息列表
     * @Author: lihuizong
     * @Date: 2020/10/19 16:12
     */
    public Response listGoodsForEvaluate(String orderCode);

    /**
     * 功能描述: 新增订单商品评价
     * @Author: lihuizong
     * @Date: 2020/10/19 16:13
     */
    public Response addGoodsEvaluate(JSONObject obj);




}
