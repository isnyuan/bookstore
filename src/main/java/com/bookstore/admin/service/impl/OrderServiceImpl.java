package com.bookstore.admin.service.impl;

import com.bookstore.admin.dao.OrderDao;
import com.bookstore.admin.entity.OrderInfo;
import com.bookstore.page.PageUtils;
import com.bookstore.admin.service.OrderService;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    /**
     * 用户角色（店长编号为1）
     */
    private static final String ROLE = "1";


    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：查询订单详情接口,orderDTO为用户form传递的参数接送实体类信息
     */
    @Override
    public Response findOrder(String orderCode) {
        List<OrderInfo> list = orderDao.findOrder(orderCode);
        if (list.size() == 0) {
            return Response.error("未查询到相关订单信息！");
        } else {
            return Response.success("查询成功！", PageUtils.getPageInfo(list));
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：分页查询订单接口，orderInfo为订单实体类信息
     */
    @Override
    public Response listOrder(OrderInfo orderInfo) {
        if(orderInfo.getRole().equals(ROLE)){
            //角色为店长，只查询自己门店下的客户
            orderInfo.setUserCode(SecurityUtils.getCurrentUserCode());
            List<OrderInfo> list = orderDao.listOrderStoreByPage(orderInfo);
            if (list.size() == 0) {
                return Response.error("未查询到订单列表相关信息！");
            } else {
                return Response.success("查询成功！", PageUtils.getPageInfo(list));
            }
        } else {
            //角色为管理员查全部客户
            List<OrderInfo> list = orderDao.listOrderByPage(orderInfo);
            if (list.size() == 0) {
                return Response.error("未查询到订单列表相关信息！");
            } else {
                return Response.success("查询成功！", PageUtils.getPageInfo(list));
            }
        }

    }



    /**
     * 作者：李丹涛
     * 时间：2020/04/13凌晨00：39分
     * 功能：修改订单状态接口，orderDTO为用户form传递的参数接送实体类信息
     */
    @Override
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateOrderActive(String orderCode,String version, String orderActive) {
        List<String> oderCodeList = Arrays.asList(orderCode.split(","));
        List<String> versionList = Arrays.asList(version.split(","));
        //new一个订单实体类用于传参
        OrderInfo orderInfo = new OrderInfo();
        //设置修改者
        orderInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //设置修改成什么订单状态
        orderInfo.setOrderActive(orderActive);
        //new一个mapList
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < oderCodeList.size(); i++) {
            Map map = new HashMap();
            map.put("orderCode",oderCodeList.get(i));
            map.put("version",versionList.get(i));
            mapList.add(map);
        }
        orderInfo.setMapList(mapList);
        int count = orderDao.updateOrderActive(orderInfo);
        if (count > 0) {
            return Response.success("修改订单状态成功！");
        } else {
            return Response.error("修改订单状态有误！");
        }
    }
}
