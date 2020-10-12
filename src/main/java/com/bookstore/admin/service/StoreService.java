package com.bookstore.admin.service;

import com.bookstore.admin.entity.StoreDTO;
import com.bookstore.admin.entity.StoreInfo;
import com.bookstore.utils.Response;

/**
 * 功能描述: 门店管理service接口
 * @Author: lihuizong
 * @Date: 2020/10/12 14:37
 */
public interface StoreService {

    /**
     * 功能描述: 新增门店信息接口
     * @Author: lihuizong
     * @Date: 2020/10/12 14:38
     */
    public Response addStore(StoreInfo storeInfo);

    /**
     * 功能描述: 查询门店信息详情接口
     * @Author: lihuizong
     * @Date: 2020/10/12 14:39
     */
    public Response findStore(String storeCode);

    /**
     * 功能描述: 分页查询门店信息
     * @Author: lihuizong
     * @Date: 2020/10/12 14:39
     */
    public Response listStore(StoreInfo storeInfo);

    /**
     * 功能描述: 修改门店信息接口
     * @Author: lihuizong
     * @Date: 2020/10/12 14:39
     */
    public Response updateStore(StoreInfo storeInfo);

    /**
     * 功能描述: 删除门店信息接口
     * @Author: lihuizong
     * @Date: 2020/10/12 14:39
     */
    public Response deleteStore(StoreDTO storeDTO);

}
