package com.bookstore.admin.dao;


import com.bookstore.admin.entity.HotGoodsDTO;
import com.bookstore.admin.entity.HotGoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/13中午10：31分
 * 功能：热门商品管理dao接口
 */

@Mapper
public interface HotGoodsDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：检查添加此热门商品或排序是否存在
     */
    int checkHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：新增热门商品接口,hotGoodsInfo是热门商品实体类信息
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：查询热门商品详情接口,hotGoodsInfo是热门商品实体类信息
     */
    HotGoodsInfo findHotGoods(String hotGoodsCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：分页查询热门商品接口,hotGoodsInfo是热门商品实体类信息
     */
    List<HotGoodsInfo> listHotGoodsByPage(HotGoodsInfo hotGoodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：修改热门商品接口,hotGoodsInfo是热门商品实体类信息
     */
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：查询热门商品展示数量接口
     */
    HotGoodsInfo findHotGoodsShowNum();

    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：修改热门商品数量展示接口,hotGoodsInfo是热门商品实体类信息
     */
    int updateHotGoodsShowNum(HotGoodsInfo hotGoodsInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13中午10：31分
     * 功能：删除热门商品接口,hotGoodsDTO是前端传递多参数接收的实体类信息
     */
    int deleteHotGoods(HotGoodsDTO hotGoodsDTO);
}
