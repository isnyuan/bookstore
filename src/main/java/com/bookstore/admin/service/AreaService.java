package com.bookstore.admin.service;

import com.bookstore.utils.Response;

public interface AreaService {

    /**
     * 功能描述: 查询省市区下拉框
     * @Author: lihuizong
     * @Date: 2020/9/22 12:03
     */
    public Response listArea(String parentCode);

}
