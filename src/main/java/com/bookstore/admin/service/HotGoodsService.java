package com.bookstore.admin.service;

import com.bookstore.admin.entity.HotGoodsDTO;
import com.bookstore.admin.entity.HotGoodsInfo;
import com.bookstore.utils.Response;

public interface HotGoodsService {

    public Response addHotGoods(HotGoodsInfo hotGoodsInfo);

    public Response findHotGoods(String hotGoodsCode);

    public Response listHotGoods(HotGoodsInfo hotGoodsInfo);

    public Response updateHotGoods(HotGoodsInfo hotGoodsInfo);

    public Response findHotGoodsShowNum();

    public Response updateHotGoodsShowNum(HotGoodsInfo hotGoodsInfo);

    public Response deleteHotGoods(HotGoodsDTO hotGoodsDTO);

}
