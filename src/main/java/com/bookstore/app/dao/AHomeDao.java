package com.bookstore.app.dao;

import com.bookstore.app.entity.AHomeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/14
 * 功能：首页轮播图dao接口、热门商品dao接口
 */

@Mapper
public interface AHomeDao {


    /**
     * 作者：李丹涛
     * 时间：2020/04/14晚上19：54
     * 功能：查询首页轮播图接口
     */
    List<AHomeInfo> listRotate(String rotateActive);

    /**
     * 作者：李丹涛
     * 时间：2020/04/14晚上19：54
     * 功能：分页查询热门商品接口
     */
    List<AHomeInfo> listHotGoods();


    /**
     * 作者：李丹涛
     * 时间：2020/04/14晚上19：54
     * 功能：轮播图展示数量
     */
    AHomeInfo findHotGoodsShowNum();

}
