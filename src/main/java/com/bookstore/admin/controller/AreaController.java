package com.bookstore.admin.controller;

import com.bookstore.admin.entity.UserInfo;
import com.bookstore.admin.service.AreaService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pc/area")
@Validated
public class AreaController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(AreaController.class);

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
        System.out.println(parentCode);
        try {
            return areaService.listArea(parentCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询省市区操作有误！");
        }
    }

    @GetMapping("/test")
    public UserInfo test() {
        System.out.println("hello...");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserCode("12300");
        userInfo.setUserPassword("123456");
        return userInfo;
    }

}
