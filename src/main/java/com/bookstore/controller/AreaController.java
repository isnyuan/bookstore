package com.bookstore.controller;

import com.bookstore.service.AreaService;
import com.bookstore.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
@Validated
public class AreaController {

    @Autowired
    private AreaService areaService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/13晚上22：27分
     * 功能：查询省市区下拉框接口
     * areaCode：区域编号（省传0，市传省编号，区传市编号）
     */
    @PostMapping("/listArea")
    public Response listArea(String parentCode) {
        try {
            return areaService.listArea(parentCode);
        } catch (Exception e) {
            //logger.error(e.toString());
            return Response.servers("查询省市区操作有误！");
        }
    }

}
