package com.bookstore.admin.dao;

import com.bookstore.admin.entity.GoodsCateInfo;
import com.bookstore.admin.entity.GoodsDTO;
import com.bookstore.admin.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/11晚上19：52
 * 功能：商品管理GoodsDao类
 */

@Mapper
public interface GoodsDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：48分
     * 功能：检查ISBN书号是否存在
     */
    int checkIsbn(String isbn);

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：查询商品分类下拉框接口，goodsCateInfo为商品分类实体类信息
     */
    List<GoodsCateInfo> listGoodsCate(GoodsCateInfo goodsCateInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：新增商品接口，goodsInfo商品信息
     */
    int addGoods(GoodsInfo goodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：查询商品详情接口，goodsCode商品编号
     */
    GoodsInfo findGoods(String goodsCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：分页查询商品列表接口，goodsInfo商品信息
     */
    List<GoodsInfo> listGoodsByPage(GoodsInfo goodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：修改商品接口，goodsInfo商品信息
     */
    int updateGoods(GoodsInfo goodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：修改商品状态接口
     */
    int updateGoodsActive(GoodsInfo goodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：删除商品
     */
    int deleteGoods(GoodsDTO goodsDTO);

    /**
     * 作者：李丹涛
     * 时间：2020/04/11晚上22：49分
     * 功能：检查删除关联是否存在
     */
    int checkHotGoods(GoodsDTO goodsDTO);
    int checkRotateGoods(GoodsDTO goodsDTO);

}
