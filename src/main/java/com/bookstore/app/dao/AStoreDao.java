package com.bookstore.app.dao;



import com.bookstore.app.entity.AStoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/15分下午14：16分
 * 功能：店长个人信息之查询司机信息管理Dao类
 */
@Mapper
public interface AStoreDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：44分
     * 功能：店长个人信息之查询司机信息
     */
    List<AStoreInfo> listManangerDriver(@Param("userCode") String userCode);
}
