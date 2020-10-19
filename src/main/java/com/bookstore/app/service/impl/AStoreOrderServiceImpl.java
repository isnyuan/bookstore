package com.bookstore.app.service.impl;


import com.bookstore.app.dao.AStoreOrderDao;
import com.bookstore.app.entity.AStoreOrderDTO;
import com.bookstore.app.entity.AStoreOrderInfo;
import com.bookstore.app.service.AStoreOrderService;
import com.bookstore.page.PageUtils;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AStoreOrderServiceImpl implements AStoreOrderService {

    //注入Dao接口
    @Resource
    private AStoreOrderDao aStoreOrderDao;

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    @Override
    public Response listManagerOrders(AStoreOrderDTO storeOrderDTO) {
        PageHelper.startPage(storeOrderDTO.getPageNum(), storeOrderDTO.getPageSize());
        //查看该店长的门店编号
        String storeCode = aStoreOrderDao.findStoreCode(SecurityUtils.getCurrentUserCode());
        String orderActive = storeOrderDTO.getOrderActive();
        //查询订单列表，orderDTO.getOrderActive()：订单状态，SecurityUtils.getCurrentUserId()：当前登录者
        List<AStoreOrderInfo> orderInfoList = aStoreOrderDao.listManagerOrdersByPage(orderActive, storeCode);
        //查询订单详情列表
        List<AStoreOrderInfo> orderInfoDetailList = aStoreOrderDao.listOrderDetail();
        for (int i = 0; i < orderInfoList.size(); i++) {
            //new一个List存对应商品详情
            List<AStoreOrderInfo> list = new ArrayList<>();
            for (int i1 = 0; i1 < orderInfoDetailList.size(); i1++) {
                //同个订单归类list
                if (orderInfoDetailList.get(i1).getOrderCode().equals(orderInfoList.get(i).getOrderCode())) {
                    list.add(orderInfoDetailList.get(i1));
                }
            }
            //对应的商品详情信息丢进入list整合
            orderInfoList.get(i).setOrderDetailList(list);
        }
        if (orderInfoList.size() == 0) {
            return Response.error("未查询到相关列表订单信息!");
        } else {
            return Response.success("查询成功!", PageUtils.getPageInfo(orderInfoList));
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/25下午15：48分
     * 功能：修改店长订单状态接口
     */
    @Override
    public Response updateManangerOrderState(AStoreOrderInfo storeOrderInfo){
        //设置当前修改者编码
        storeOrderInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int count = aStoreOrderDao.updateOrderActive(storeOrderInfo);
        if (count > 0) {
            return Response.success("修改订单状态成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("提供的修改订单状态信息有误！");
        }
    }


    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单详情接口
     */
    @Override
    public Response orderDetail(String orderCode) {
        //查询订单列表
        List<AStoreOrderInfo> orderInfoList = aStoreOrderDao.listOrderByPage(orderCode);
        //查询订单详情列表
        List<AStoreOrderInfo> orderInfoDetailList = aStoreOrderDao.listOrderDetail();
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < orderInfoList.size(); i++) {
            Map map = new HashMap();
            map.put("storeName", orderInfoList.get(i).getStoreName());
            String address = orderInfoList.get(i).getProvinceName()
                    + orderInfoList.get(i).getCityName()
                    + orderInfoList.get(i).getAreaName()
                    + orderInfoList.get(i).getAddress();
            map.put("address", address);
            map.put("userName", orderInfoList.get(i).getUserName());
            map.put("phone", orderInfoList.get(i).getPhone());
            map.put("storeName", orderInfoList.get(i).getStoreName());
            map.put("orderCode", orderInfoList.get(i).getOrderCode());
            map.put("orderActive", orderInfoList.get(i).getOrderActive());
            map.put("sumPrice", orderInfoList.get(i).getSumPrice());
            map.put("payTime", orderInfoList.get(i).getPayTime());
            map.put("pucharNum", orderInfoList.get(i).getPucharNum());
            map.put("version", orderInfoList.get(i).getVersion());
            List<Map> list = new ArrayList<>();
            Map map1 = new HashMap();
            for (int i1 = 0; i1 < orderInfoDetailList.size(); i1++) {
                if (orderInfoDetailList.get(i1).getOrderCode().equals(orderInfoList.get(i).getOrderCode())) {
                    map1.put("goodsName", orderInfoDetailList.get(i1).getGoodsName());
                    map1.put("goodsImagePath", orderInfoDetailList.get(i1).getGoodsImagePath());
                    map1.put("goodsIntroduce", orderInfoDetailList.get(i1).getGoodsIntroduce());
                    map1.put("goodsPrice", orderInfoDetailList.get(i1).getGoodsPrice());
                    map1.put("goodsCount", orderInfoDetailList.get(i1).getGoodsCount());
                    map1.put("goodsCode", orderInfoDetailList.get(i1).getGoodsCode());
                    list.add(map1);
                }
            }
            map.put("goodsList", list);
            mapList.add(map);
        }
        if (mapList.size() == 0) {
            return Response.error("未查询到相关订单详情信息!");
        } else {
            return Response.success("查询成功!", mapList);
        }
    }


}
