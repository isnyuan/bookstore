package com.bookstore.app.dao;

import com.bookstore.app.entity.AEvaluateInfo;
import com.bookstore.app.entity.AGoodsInfo;
import com.bookstore.app.entity.AOrderDTO;
import com.bookstore.app.entity.AOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 作者：李丹涛
 * 时间：2020/04/19下午17：42分
 * 功能：app订单接口
 */

@Mapper
public interface AOrderDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：查询商品编号
     */
    List<String> findGoodsCode(String orderCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：查询商品购买数量
     */
    List<String> findGoodsCount(String orderCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：更新商品状态
     */
    int updateGoodsActice(List<Map> list);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：更新库存
     */
    int updateGoodsStock(AOrderDTO orderDTO);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：更新销量
     */
    int updateSallNum(@Param("mapList") List<Map> mapList);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：删除对应购物车
     */
    int deleteShopCar(AOrderDTO orderDTO);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：查看商品库存，orderDao多参实体类，里面包含商品编号列表
     */
    List<String> findGoodsStock(AOrderDTO orderDTO);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：查看商品销量
     */
    List<String> findGoodsSallNum(@Param("goodsCodeList") List<String> goodsCodeList);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：42分
     * 功能：新增订单接口
     */
    int addOrder(AOrderInfo orderInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：新增订单详情接口
     */
    int addOrderDetail(AOrderInfo orderInfo);


    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    List<AOrderInfo> listOrderByPage(@Param("orderActive") String orderActive, @Param("currentUserCode") String currentUserCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单列表接口
     */
    List<AOrderInfo> findOrder(@Param("orderCode") String orderCode);


    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单详情列表接口
     */
    List<AOrderInfo> listOrderDetail();

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：修改订单状态接口
     */
    int updateOrderActive(AOrderInfo orderInfo);

    /**
     * 查询商品库存
     */
    List<String> ListGoodsStock(@Param("goodsCodeList") List<String> goodsCodeList);
    /**
     * 更新库存
     */
    int updateStock(@Param("mapList") List<Map> mapList);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单详情接口
     */
    List<AOrderInfo> orderDetail();

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：查询订单评价商品信息列表接口
     */
    List<AOrderInfo> listGoodsForEvaluate(String orderCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午17：45分
     * 功能：新增订单商品评价接口
     */
    /**
     * 插入评价内容
     */
     int addGoodsEvaluate(@Param("evaluateListMap") List<Map> evaluateListMap);
    /**
     * 插入评价图片
     */
    int addGoodsEvaluateImage(@Param("evaluateImageListMap") List<Map> evaluateImageListMap);
    /**
     * 修改订单为已评价
     */
    int updateOrderEvaluateActive(AOrderInfo orderInfo);
    /**
     * 查询各个商品平均星级
     */
    List<AEvaluateInfo> findGoodsScore();
    /**
     * 更新产品的评价等级
     */
    int updateAvgGoodsScore(@Param("avgStarList") List<Map> avgStarList);

    /**
     * 功能描述: 查询商品信息
     * @Author: lihuizong
     * @Date: 2020/10/31 22:51
     */
    AGoodsInfo queryGoodsInfo(String goodsCode);

}
