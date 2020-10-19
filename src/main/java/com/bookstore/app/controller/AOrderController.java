package com.bookstore.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.bookstore.app.entity.AOrderDTO;
import com.bookstore.app.entity.AOrderInfo;
import com.bookstore.app.service.AOrderService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：42分
 * 功能：app订单接口
 */

@RestController
@RequestMapping("/app/order")
@Validated
public class AOrderController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(AOrderController.class);

    //注入orderService类
    @Resource
    private AOrderService aOrderService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：新增订单接口
     */
    @PostMapping("/addOrder")
    public Response addOrder(AOrderDTO orderDTO){
        try {
            return aOrderService.addOrder(orderDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增订单操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    @PostMapping("/listOrder")
    public Response listOrder(AOrderDTO orderDTO){
        try {
            return aOrderService.listOrder(orderDTO);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询订单列表有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：修改订单状态接口
     */
    @PostMapping("/updateOrderActive")
    public Response updateOrderActive(AOrderInfo orderInfo){
        try {
            return aOrderService.updateOrderActive(orderInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改订单状态操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单详情接口
     */
    @PostMapping("/orderDetail")
    public Response orderDetail(String orderCode){
        try {
            return aOrderService.orderDetail(orderCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询订单详情操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单评价商品信息列表接口
     */
    @PostMapping("/listGoodsForEvaluate")
    public Response listGoodsForEvaluate(String orderCode){
        try {
            return aOrderService.listGoodsForEvaluate(orderCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询订单评价商品信息列表有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：新增订单商品评价接口
     */
    @PostMapping("/addGoodsEvaluate")
    public Response addGoodsEvaluate(@RequestBody JSONObject obj) {
        try {
            return aOrderService.addGoodsEvaluate(obj);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增订单商品评价接口有误！");
        }
    }
}
