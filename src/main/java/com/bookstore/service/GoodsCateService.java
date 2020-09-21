package com.bookstore.service;

import com.bookstore.entity.GoodsCateInfo;
import com.bookstore.utils.Response;

public interface GoodsCateService {

    /**
     * 功能描述: 新增商品分类
     * @Author: lihuizong
     * @Date: 2020/9/21 16:38
     */
    public Response addGoodsCate(GoodsCateInfo goodsCateInfo);

    /**
     * 功能描述: 查询商品分类详情
     * @Author: lihuizong
     * @Date: 2020/9/21 16:39
     */
    public Response findGoodsCate(String goodsCateCode);

    /**
     * 功能描述: 查询商品分类列表
     * @Author: lihuizong
     * @Date: 2020/9/21 16:39
     */
    public Response listGoodsCate();

    /**
     * 功能描述: 修改商品分类
     * @Author: lihuizong
     * @Date: 2020/9/21 16:40
     */
    public Response updateGoodsCate(GoodsCateInfo goodsCateInfo);

    /**
     * 功能描述: 删除商品分类
     * @Author: lihuizong
     * @Date: 2020/9/21 16:40
     */
    public Response deleteGoodsCate(GoodsCateInfo goodsCateInfo);



}
