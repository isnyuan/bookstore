package com.bookstore.app.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bookstore.app.dao.AOrderDao;
import com.bookstore.app.entity.AEvaluateInfo;
import com.bookstore.app.entity.AGoodsInfo;
import com.bookstore.app.entity.AOrderDTO;
import com.bookstore.app.entity.AOrderInfo;
import com.bookstore.app.service.AOrderService;
import com.bookstore.page.PageUtils;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import com.bookstore.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;


/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：42分
 * 功能：app订单接口
 */

@Service
public class AOrderServiceImpl implements AOrderService {

    //注入OrderDao接口
    @Resource
    private AOrderDao aOrderDao;

    /**
     * 支付状态,0已支付,1未支付
     */
    private static final String PAYACTIVE = "0";

    /**
     * 订单状态编号：0已下单，1已取消，2已到货，3已取货，4已完成未评价，5已完成已评价
     */
    private static final String ORDERACTIVE = "0";
    private static final String EVALUATE = "5";

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：新增订单接口
     * 细节注意：
     * 1.判断库存是否满足购买商品数
     * 2.判断是否购物车来的，是则要清空购物车对应商品
     * 3.下单完成，改变库存
     * 4.检查商品购买后数量书否为0，是则改变商品状态为已售完
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response addOrder(AOrderDTO orderDTO) {
//        if ("".equals(orderDTO.getStoreCode()) || orderDTO.getStoreCode() == null) {
//            return Response.error("门店编号为空，请先绑定门店！");
//        }

        // 获取商品编号和数量
        List<String> listCode = Arrays.asList(orderDTO.getGoodsCode().split(","));
        List<String> listCount = Arrays.asList(orderDTO.getGoodsCount().split(","));
        orderDTO.setGoodsCodeList(listCode);
        orderDTO.setGoodsCountList(listCount);

        // 通过商品编号查询商品信息
        ArrayList<AGoodsInfo> aGoodsInfos = new ArrayList<>();
        for (int i = 0; i < listCode.size(); i++) {
            AGoodsInfo aGoodsInfo = aOrderDao.queryGoodsInfo(listCode.get(i));
            aGoodsInfos.add(aGoodsInfo);
        }

        //设置购物车编号列表为null,避免空指针异常
        orderDTO.setShopCarCodeList(null);
        //查看订单中商品的库存
        List<String> goodsStockList = aOrderDao.findGoodsStock(orderDTO);
        //new一个购买后的商品库存列表，用于更新库存用
        List<Map> stockMapList = new ArrayList<>();
        //查看是否有库存不足的商品，new一个List收集不足库存的商品
        List<String> lessGoodsList = new ArrayList<>();
        //new一个购买后库存为0的列表，用于更新商品库存为0，商品状态改为0（已售完）
        List<Map> zeroStockMapList = new ArrayList<>();
        for (int i = 0; i < goodsStockList.size(); i++) {
            //new一个小map放list给mybatis映射用
            Map map = new HashMap();
            int stock = Integer.parseInt(goodsStockList.get(i)) - Integer.parseInt(orderDTO.getGoodsCountList().get(i));
            //库存小于用户购买商品的数量，收集库存不足商品
            if (stock < 0) {
                lessGoodsList.add(String.valueOf(i + 1));
            }
            if (stock == 0) {
                //new一个小map装修改商品状态的
                Map map1 = new HashMap();
                map1.put("goodsCode", orderDTO.getGoodsCodeList().get(i));
                map1.put("lastUpdateUser", SecurityUtils.getCurrentUserCode());
                zeroStockMapList.add(map1);
            }
            map.put("lastUpdateUser", SecurityUtils.getCurrentUserCode());
            map.put("goodsStock", stock);
            map.put("goodsCode", orderDTO.getGoodsCodeList().get(i));
            stockMapList.add(map);
        }
        if (lessGoodsList.size() > 0) {
            return Response.error("下单失败，选中的第" + lessGoodsList.toString() + "个商品库存不足！");
        }
        //更新库存
        orderDTO.setStockMapList(stockMapList);
        int update = aOrderDao.updateGoodsStock(orderDTO);
        if (update == 0) {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("商品库存与销量更新失败！");
        }
        //有商品已售完的，更新下商品状态为0（已售完）
        if (zeroStockMapList.size() > 0) {
            int update1 = aOrderDao.updateGoodsActice(zeroStockMapList);
            if (update1 == 0) {
                return Response.error("更新商品状态为已售完失败！");
            }
        }
        //设置修改者
        orderDTO.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        //查看是否是从购物车过来的,是则先清空购物车
        if (!"".equals(orderDTO.getShopCarCodeList()) && orderDTO.getShopCarCodeList() != null && orderDTO.getShopCarCodeList().size() != 0) {
            int delete1 = aOrderDao.deleteShopCar(orderDTO);
            if (delete1 < 0) {
                //删除失败,事务回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return Response.error("删除对应购物车商品失败！");
            }
        }
        //new一个实体类用于mybatis
        AOrderInfo orderInfo = new AOrderInfo();
        //随机生成订单编号,返回数据:时间戳+3为随机数
        orderInfo.setOrderCode(StringUtil.getCommonCode(3));
        //删除标记：未删除0
        orderInfo.setIsDelete("0");
        //商品总数量 pucharNum
        int pucharNum = 0;
        //商品总价格
        double sumPrice = 0.0;
        //对齐属性
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < orderDTO.getGoodsCodeList().size(); i++) {
            //new一个小map将其对应属性收集起来
            Map map = new HashMap<>();
            //随机生成订单详情编号,返回数据:时间戳+3为随机数
            String orderDetailCode = StringUtil.getCommonCode(3);
            map.put("orderDetailCode", orderDetailCode);
            map.put("goodsCode", orderDTO.getGoodsCodeList().get(i));
            map.put("goodsCount", orderDTO.getGoodsCountList().get(i));
//            map.put("goodsPrice", orderDTO.getGoodsPriceList().get(i));
            map.put("goodsPrice", aGoodsInfos.get(i).getGoodsPrice());
            map.put("createUser", SecurityUtils.getCurrentUserCode());
            map.put("lastUpdateUser", SecurityUtils.getCurrentUserCode());
            map.put("userCode", SecurityUtils.getCurrentUserCode());
            map.put("orderCode", orderInfo.getOrderCode());
            pucharNum += Integer.parseInt(orderDTO.getGoodsCountList().get(i));
            sumPrice += Double.parseDouble(aGoodsInfos.get(i).getGoodsPrice()) * Double.parseDouble(orderDTO.getGoodsCountList().get(i));
            System.out.println(sumPrice);
            mapList.add(map);
        }
        orderInfo.setMapList(mapList);
        orderInfo.setPucharNum(pucharNum);
        orderInfo.setSumPrice(sumPrice);
        //设置门店编号
//        orderInfo.setStoreCode(orderDTO.getStoreCode());
        //orderInfo.setStoreCode(aGoodsInfos.get(0).getStoreCode());
        //设置支付状态
        orderInfo.setPayActive(PAYACTIVE);
        //设置订单状态
        orderInfo.setOrderActive(ORDERACTIVE);
        //设置创建者和修改者和登录者
        orderInfo.setCreateUser(SecurityUtils.getCurrentUserCode());
        orderInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        orderInfo.setUserCode(SecurityUtils.getCurrentUserCode());
        //添加到订单表
        int add1 = aOrderDao.addOrder(orderInfo);
        //添加到订单详情
        int add2 = aOrderDao.addOrderDetail(orderInfo);
        if (add1 > 0 && add2 > 0) {
            return Response.success("新增订单成功！");
        } else {
            //修改失败,事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Response.error("添加订单操作有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    public Response listOrder(AOrderDTO orderDTO) {
        PageHelper.startPage(orderDTO.getPageNum(), orderDTO.getPageSize());
        //查询订单列表，orderDTO.getOrderActive()：订单状态，SecurityUtils.getCurrentUserId()：当前登录者
        List<AOrderInfo> orderInfoList = aOrderDao.listOrderByPage(orderDTO.getOrderActive(), SecurityUtils.getCurrentUserCode());
        System.out.println(orderInfoList);
        //查询订单详情列表
        List<AOrderInfo> orderInfoDetailList = aOrderDao.listOrderDetail();
        System.out.println(orderInfoDetailList);
        for (int i = 0; i < orderInfoList.size(); i++) {
            //new一个List存对应商品详情
            List<AOrderInfo> list = new ArrayList<>();
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
     * 时间：2020/04/19下午17：45分
     * 功能：修改订单状态接口
     */
    //添加事务
    @Transactional(rollbackFor = Exception.class)
    public Response updateOrderActive(AOrderInfo orderInfo) {
        //订单状态：1为取消订单，此时应该增加库存
        if ("1".equals(orderInfo.getOrderActive())) {
            //查询对应的商品编号与购买数量
            List<String> goodsCodeList = aOrderDao.findGoodsCode(orderInfo.getOrderCode());
            List<String> goodsCountList = aOrderDao.findGoodsCount(orderInfo.getOrderCode());
            //查询商品的库存
            List<String> goodsStockList = aOrderDao.ListGoodsStock(goodsCodeList);
            //new一个list去增加库存
            List<Map> mapList = new ArrayList<>();
            for (int i = 0; i < goodsCodeList.size(); i++) {
                //new每个map装每个商品更新的库存
                Map map = new HashMap();
                map.put("goodsCode", goodsCodeList.get(i));
                int goodsStock = Integer.parseInt(goodsCountList.get(i)) + Integer.parseInt(goodsStockList.get(i));
                map.put("goodsStock", goodsStock);
                map.put("lastUpdateUser", SecurityUtils.getCurrentUserCode());
                mapList.add(map);
            }
            int update = aOrderDao.updateStock(mapList);
            if (update == 0) {
                return Response.error("更新商品库存有误！");
            }
        }
        //订单状态：4为已完成未评价、5为已完成已评价。此时应该增加商品的销量
        if ("4".equals(orderInfo.getOrderActive()) || "5".equals(orderInfo.getOrderActive())) {
            //查询对应的商品编号与购买数量
            List<String> goodsCodeList = aOrderDao.findGoodsCode(orderInfo.getOrderCode());
            List<String> goodsCountList = aOrderDao.findGoodsCount(orderInfo.getOrderCode());
            //查看销量，卖出去要加销量
            List<String> goodsSallNumList = aOrderDao.findGoodsSallNum(goodsCodeList);
            //new一个list去增加销量
            List<Map> mapList = new ArrayList<>();
            for (int i = 0; i < goodsCodeList.size(); i++) {
                //new每个map装每个商品更新的销量
                Map map = new HashMap();
                map.put("goodsCode", goodsCodeList.get(i));
                int goodsSallNum = Integer.parseInt(goodsCountList.get(i)) + Integer.parseInt(goodsSallNumList.get(i));
                map.put("goodsSallNum", goodsSallNum);
                map.put("lastUpdateUser", SecurityUtils.getCurrentUserCode());
                mapList.add(map);
            }
            int update = aOrderDao.updateSallNum(mapList);
            if (update == 0) {
                return Response.error("更新商品销量有误！");
            }
        }
        //设置当前修改者编码
        orderInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
        int count = aOrderDao.updateOrderActive(orderInfo);
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
    public Response orderDetail(String orderCode) {
        //查询订单列表
        List<AOrderInfo> orderInfoList = aOrderDao.findOrder(orderCode);
        //查询订单详情列表
        List<AOrderInfo> orderInfoDetailList = aOrderDao.listOrderDetail();
        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < orderInfoList.size(); i++) {
            Map map = new HashMap();
            map.put("storeName", orderInfoList.get(i).getStoreName());
            String address = orderInfoList.get(i).getProvinceName()
                    + orderInfoList.get(i).getCityName()
                    + orderInfoList.get(i).getAreaName()
                    + orderInfoList.get(i).getAddress();
            map.put("address", address);
            map.put("orderCode", orderInfoList.get(i).getOrderCode());
            map.put("orderActive", orderInfoList.get(i).getOrderActive());
            map.put("sumPrice", orderInfoList.get(i).getSumPrice());
            map.put("payTime", orderInfoList.get(i).getPayTime());
            map.put("pucharNum", orderInfoList.get(i).getPucharNum());
            map.put("version", orderInfoList.get(i).getVersion());
            List<Map> list = new ArrayList<>();
            for (int i1 = 0; i1 < orderInfoDetailList.size(); i1++) {
                Map map1 = new HashMap();
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

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单评价商品信息列表接口
     */
    public Response listGoodsForEvaluate(String orderCode) {
        //查询订单商品评价信息列表
        List<AOrderInfo> goodsEvaluateList = aOrderDao.listGoodsForEvaluate(orderCode);
        List<Map> list = new ArrayList<>();
        for (int i1 = 0; i1 < goodsEvaluateList.size(); i1++) {
            //new一个map收集每一个评价商品信息
            Map map1 = new HashMap();
            map1.put("goodsCode", goodsEvaluateList.get(i1).getGoodsCode());
            map1.put("goodsImagePath", goodsEvaluateList.get(i1).getGoodsImagePath());
            list.add(map1);
        }
        return Response.success("查询成功!", list);
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：新增订单商品评价接口
     */
    public Response addGoodsEvaluate(JSONObject obj) {
        //换java实体类对象
        AEvaluateInfo evaluateInfo = obj.toJavaObject(AEvaluateInfo.class);
        //提取商品评价信息
        List<AEvaluateInfo> evaluateList = evaluateInfo.getList();
        //new一个评价商品信息的列表
        List<Map> orderMapList = new ArrayList<>();
        //new一个list用于存放评价图片
        List<Map> orderImageList = new ArrayList<>();
        for (int i = 0; i < evaluateList.size(); i++) {
            //随机生成评价编号
            String evaluateCode = StringUtil.getCommonCode(3);
            //new一个小map存单个评价
            Map map = new HashMap();
            //存订单编号（从属哪条订单评价的）
            map.put("orderCode", evaluateInfo.getOrderCode());
            //存评价编号
            map.put("evaluateCode", evaluateCode);
            //取商品编号
            map.put("goodsCode", evaluateList.get(i).getGoodsCode());
            //取评价内容
            map.put("evaluateContent", evaluateList.get(i).getEvaluateContent());
            //取评价星级
            map.put("evaluateScore", Integer.parseInt(evaluateList.get(i).getEvaluateScore()));
            //设置未删除状态
            map.put("isDelete", "0");
            //设置创建者与更新者与评价用户与评价者
            map.put("goodsEvaluateUser", SecurityUtils.getCurrentUserCode());
            map.put("createUser", SecurityUtils.getCurrentUserCode());
            map.put("lastUpdateUser", SecurityUtils.getCurrentUserCode());
            map.put("goodsEvaluateUser", SecurityUtils.getCurrentUserCode());
            orderMapList.add(map);
            if (evaluateList.get(i).getImageList() != null && evaluateList.get(i).getImageList().size() > 0) {
                for (int i1 = 0; i1 < evaluateList.get(i).getImageList().size(); i1++) {
                    //new一个map用于存放每个评价图片
                    Map map2 = new HashMap();
                    //设置评价图片编号
                    map2.put("evaluateImageCode", StringUtil.getCommonCode(3));
                    //存放评论编号
                    map2.put("evaluateCode", evaluateCode);
                    //存放评论图片排序
                    map2.put("imageSortNum", evaluateList.get(i).getImageList().get(i1).getImageSortNum());
                    //存放图片路径
                    map2.put("goodsEvaluateImage", evaluateList.get(i).getImageList().get(i1).getGoodsEvaluateImage());
                    //设置未删除状态
                    map2.put("isDelete", "0");
                    //设置创建者与更新者
                    map2.put("createUser", SecurityUtils.getCurrentUserCode());
                    map2.put("lastUpdateUser", SecurityUtils.getCurrentUserCode());
                    orderImageList.add(map2);
                }
            }
        }
        //插入评价表
        int add1 = aOrderDao.addGoodsEvaluate(orderMapList);
        //插入评价图片
        if (orderImageList != null && orderImageList.size() > 0) {
            int add2 = aOrderDao.addGoodsEvaluateImage(orderImageList);
            if (add2 == 0) {
                return Response.error("新增订单评价图片失败！");
            }
        }
        if (add1 > 0) {
            //评价成功，订单状态修改为订单已完成评价
            AOrderInfo orderInfo = new AOrderInfo();
            orderInfo.setLastUpdateUser(SecurityUtils.getCurrentUserCode());
            orderInfo.setOrderCode(evaluateInfo.getOrderCode());
            orderInfo.setOrderActive(EVALUATE);
            int update = aOrderDao.updateOrderEvaluateActive(orderInfo);
            if (update == 0) {
                return Response.error("更新订单商品评价状态有误！");
            }
            //查询各商品的评价星级
            List<AEvaluateInfo> avgScore = aOrderDao.findGoodsScore();
            List<Map> avgStarList = new ArrayList<>();
            for (AEvaluateInfo evaluateInfo1 : avgScore) {
                Map map = new HashMap();
                map.put("goodsCode", evaluateInfo1.getGoodsCode());
                Double avgStar = evaluateInfo1.getAvgScore();
                //取小数点后一位小数即可(四舍五入方式取小数点后一位）
                BigDecimal df = new BigDecimal(avgStar);
                map.put("avgScore", df.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
                map.put("lastUpdateUser", SecurityUtils.getCurrentUserCode());
                avgStarList.add(map);
            }
            //更新商品评价等级
            int update1 = aOrderDao.updateAvgGoodsScore(avgStarList);
            if (update1 == 0) {
                return Response.error("更新商品评价等级失败！");
            }
            return Response.success("评价成功！");
        } else {
            return Response.error("评价信息有误！");
        }
    }
}