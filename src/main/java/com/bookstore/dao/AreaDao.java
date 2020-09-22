package com.bookstore.dao;

import com.bookstore.entity.AreaInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 作者：李丹涛
 * 时间：2020/04/13晚上22：27分
 * 功能：查询省市区下拉框Dao接口
 */

@Mapper
public interface AreaDao {

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：27分
     * 功能：查询省市区下拉框接口
     * areaCode：区域编号（省传0，市传省编号，区传市编号）
     */
    List<AreaInfo> listArea(String parentCode);
}
