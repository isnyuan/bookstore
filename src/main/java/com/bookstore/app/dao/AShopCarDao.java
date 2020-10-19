package com.bookstore.app.dao;

import com.bookstore.app.entity.AShopCarDTO;
import com.bookstore.app.entity.AShopCarInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/15中午11：37分
 * 功能：购物车Dao接口
 */

@Mapper
public interface AShopCarDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午16：49分
     * 功能：查询商品库存
     */
    String findGoodsStock(AShopCarInfo shopCarInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午16：49分
     * 功能：查询购物车是否存在此商品
     */
    int checkShopCar(AShopCarInfo shopCarInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/19下午16：49分
     * 功能：该商品存在购物车数量+1
     */
    int updateShopCarCount(AShopCarInfo shopCarInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：新增购物车接口，ShopCarInfo为购物车实体类信息
     */
    int addShopCar(AShopCarInfo shopCarInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：查询购物车接口
     */
    List<AShopCarInfo> listShopCarByPage();

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：修改购物车接口，ShopCarInfo为购物车实体类信息
     */
    int updateShopCar(AShopCarInfo shopCarInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/15中午11：33分
     * 功能：删除购物车接口，shopCarDTO为接受前端多参信息
     */
    int deleteShopCar(AShopCarDTO shopCarDTO);
}
