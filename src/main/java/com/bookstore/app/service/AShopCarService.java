package com.bookstore.app.service;

import com.bookstore.app.entity.AShopCarDTO;
import com.bookstore.app.entity.AShopCarInfo;
import com.bookstore.utils.Response;

/**
 * 功能描述: 购物车Service接口
 * @Author: lihuizong
 * @Date: 2020/10/19 16:50
 */
public interface AShopCarService {

    /**
     * 功能描述: 新增购物车
     * @Author: lihuizong
     * @Date: 2020/10/19 16:50
     */
    public Response addShopCar(AShopCarInfo shopCarInfo);

    /**
     * 功能描述: 查询购物车
     * @Author: lihuizong
     * @Date: 2020/10/19 16:50
     */
    public Response listShopCar();

    /**
     * 功能描述: 修改购物车信息
     * @Author: lihuizong
     * @Date: 2020/10/19 16:50
     */
    public Response updateShopCar(AShopCarInfo shopCarInfo);

    /**
     * 功能描述: 删除购物车
     * @Author: lihuizong
     * @Date: 2020/10/19 16:51
     */
    public Response deleteShopCar(AShopCarDTO shopCarDTO);

}
