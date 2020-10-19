package com.bookstore.app.service;

import com.bookstore.app.entity.AGoodsInfo;
import com.bookstore.utils.Response;

/**
 * 功能描述: 商品管理Service接口
 * @Author: lihuizong
 * @Date: 2020/10/19 14:37
 */
public interface AGoodsService {

    /**
     * 功能描述: 查询商品信息详情接口
     * @Author: lihuizong
     * @Date: 2020/10/19 14:38
     */
    public Response findGoods(String goodsCode);

    /**
     * 功能描述: 查询商品评价列表接口
     * @Author: lihuizong
     * @Date: 2020/10/19 14:38
     */
    public <T> Response listGoodsEvaluates(AGoodsInfo goodsInfo);

    /**
     * 功能描述: 查询一级商品分类列表接口
     * @Author: lihuizong
     * @Date: 2020/10/19 14:38
     */
    public Response listFirstGoodsCate();

    /**
     * 功能描述: 查询二级商品分类以及商品接口，goodsCateCode为一级商品分类编号
     * @Author: lihuizong
     * @Date: 2020/10/19 14:39
     */
    public  Response listCateGoods(String goodsCateCode);
}
