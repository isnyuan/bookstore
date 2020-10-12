package com.bookstore.admin.service;

import com.bookstore.admin.entity.CustomerInfo;
import com.bookstore.utils.Response;

    public interface CustomerService {

    /**
     * 功能描述: 查询用户分页列表信息
     * @Author: lihuizong
     * @Date: 2020/9/21 15:42
     */
    public Response listCustomer(CustomerInfo customerInfo);

}
