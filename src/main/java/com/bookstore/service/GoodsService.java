package com.bookstore.service;

import com.bookstore.entity.GoodsCateInfo;
import com.bookstore.entity.GoodsDTO;
import com.bookstore.entity.GoodsInfo;
import com.bookstore.utils.Response;

/**
 * 功能描述: 商品service层接口
 * @Author: lihuizong
 * @Date: 2020/9/23 19:53
 */
public interface GoodsService {

    /**
     * 功能描述: 查询商品分类下拉框接口
     * @Author: lihuizong
     * @Date: 2020/9/23 19:50
     */
    public Response listGoodsCate(GoodsCateInfo goodsCateInfo);

    /**
     * 功能描述: 新增商品接口商品
     * @Author: lihuizong
     * @Date: 2020/9/23 19:51
     */
    public Response addGoods(GoodsInfo goodsInfo);

    /**
     * 功能描述: 查询商品详情接口通过编号
     * @Author: lihuizong
     * @Date: 2020/9/23 19:51
     */
    public Response findGoods(String goodsCode);

    /**
     * 功能描述: 分页查询商品列表接口
     * @Author: lihuizong
     * @Date: 2020/9/23 19:51
     */
    public Response listGoods(GoodsInfo goodsInfo);

    /**
     * 功能描述: 修改商品信息
     * @Author: lihuizong
     * @Date: 2020/9/23 19:52
     */
    public Response updateGoods(GoodsInfo goodsInfo);

    /**
     * 功能描述: 修改商品状态
     * @Author: lihuizong
     * @Date: 2020/9/23 19:52
     */
    public Response updateGoodsActive(String goodsCode,String version, String goodsActive);

    /**
     * 功能描述: 删除商品信息
     * @Author: lihuizong
     * @Date: 2020/9/23 19:52
     */
    public Response deleteGoods(GoodsDTO goodsDTO);

}
