package com.bookstore.dao;

import com.bookstore.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerDao {

    /**
     * 功能描述: 管理员查询所有顾客信息
     * @Author: lihuizong
     * @Date: 2020/9/21 15:29
     */
    List<CustomerInfo> listCustomerByPage(CustomerInfo customerInfo);

    /**
     * 功能描述: 店长查询自己店铺的顾客信息
     * @Author: lihuizong
     * @Date: 2020/9/21 15:29
     */
    List<CustomerInfo> listCustomerStoreByPage(CustomerInfo customerInfo);

}
