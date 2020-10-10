package com.bookstore.dao;

import com.bookstore.entity.TopInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 功能描述: 查询顶部栏信息dao接口
 * @Author: lihuizong
 * @Date: 2020/10/10 14:59
 */
@Mapper
public interface TopDao {

    TopInfo getTop(@Param("userCode") String userCode);

}
