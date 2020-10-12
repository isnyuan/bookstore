package com.bookstore.dao;

import com.bookstore.entity.StoreDTO;
import com.bookstore.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/13晚上22：33分
 * 功能：门店管理DAO接口
 */

@Mapper
public interface StoreDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：29分
     * 功能：检查填写的店长编号是否已在用户表等级信息（行走书店是否有这个人）
     */
    int checkUserCode(String userCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：29分
     * 功能：查询门店信息,自己的信息不返回,修改校验重复信息用
     */
    List<StoreInfo> checkStoreInfoByUpdate(String storeCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：29分
     * 功能：查询门店相关信息，新增用
     */
    List<StoreInfo> checkStoreInfo();


    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：29分
     * 功能：新增门店信息接口
     * storeInfo：门店实体类信息
     */
    int addStore(StoreInfo storeInfo);


    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：33分
     * 功能：查询门店信息详情接口
     * storeCode：门店编号
     */
    StoreInfo findStore(String storeCode);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：36分
     * 功能：分页查询门店信息
     * storeInfo：门店实体类信息
     */
    List<StoreInfo> listStoreByPage(StoreInfo storeInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：39分
     * 功能：修改门店信息接口
     * storeInfo：门店实体类信息
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：42分
     * 功能：删除门店信息接口
     * storeDTO：用于用户传递多参数使用的实体类信息
     */
    int deleteStore(StoreDTO storeDTO);

}
