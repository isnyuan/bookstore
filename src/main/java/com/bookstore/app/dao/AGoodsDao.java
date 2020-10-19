package com.bookstore.app.dao;

import com.bookstore.app.entity.AGoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/15中午10：29分
 * 功能：商品管理Dao接口
 */

@Mapper
public interface AGoodsDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：29分
     * 功能：查询商品信息详情接口，goodsCode为商品编号
     */
    AGoodsInfo findGoods(@Param("goodsCode") String goodsCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：31分
     * 功能：查询商品评价列表接口，GoodsInfo为商品实体类信息
     */
    List<AGoodsInfo> listGoodsEvaluates(AGoodsInfo goodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：31分
     * 功能：查询商品评价图片列表信息，GoodsInfo为商品实体类信息
     */
    List<AGoodsInfo> ListEvaluateImage(AGoodsInfo goodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午10：32分
     * 功能：查询一级商品分类列接口
     */
    List<AGoodsInfo> firstListGoodsCate();

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午：10：33分
     * 功能：查询全部二级商品分类列表接口
     */
    List<AGoodsInfo> secondListGoodsCate(String goodsCateCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午：10：33分
     * 功能：查询全部商品接口
     */
    List<AGoodsInfo> listGoods();

}
