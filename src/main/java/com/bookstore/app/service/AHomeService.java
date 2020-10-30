package com.bookstore.app.service;

import com.bookstore.utils.Response;

public interface AHomeService {

    /**
     * 功能描述: 查询首页轮播图接口
     * @Author: lihuizong
     * @Date: 2020/10/30 19:49
     */
    public Response listRotate();


    /**
     * 功能描述: 分页查询热门商品接口
     * @Author: lihuizong
     * @Date: 2020/10/30 19:49
     */
    public Response listHotGoods();

}
