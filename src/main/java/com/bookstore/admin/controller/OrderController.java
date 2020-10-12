package com.bookstore.admin.controller;

import com.bookstore.admin.entity.OrderInfo;
import com.bookstore.admin.service.OrderService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/13凌晨00：39分
 * 功能：订单管理dao接口
 */

@RestController
@RequestMapping("/pc/order")
@Validated
public class OrderController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    //注入OrderService类
    @Resource
    private OrderService orderService;



    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：查询订单详情接口,orderDTO为用户form传递的参数接送实体类信息
     */
    @PostMapping("/findOrder")
    public Response findOrder(String orderCode) {
        try {
            return orderService.findOrder(orderCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询订单详情有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：分页查询订单接口，orderInfo为订单实体类信息
     */
    @PostMapping("/listOrder")
    public Response listOrder(OrderInfo orderInfo) {
        try {
            return orderService.listOrder(orderInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("分页查询订单有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：修改订单状态接口，orderDTO为用户form传递的参数接送实体类信息
     */
    @PostMapping("/updateOrderActive")
    public Response updateOrderActive(String orderCodeList,String versionList, String orderActive) {
        try {
            return orderService.updateOrderActive(orderCodeList,versionList,orderActive);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改订单状态有误！");
        }
    }

}
