package com.bookstore.admin.controller;

import com.bookstore.admin.service.TopService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pc/top")
@Validated
public class TopController {

    // 日志处理
    private final Logger logger = LoggerFactory.getLogger(TopController.class);

    @Autowired
    private TopService topService;

    @PostMapping("/getTop")
    public Response getTop(){
        try{
            Response response = topService.getTop();
            return response;
        }catch (Exception e){
            logger.error(e.toString());
            return Response.servers("查询顶部栏操作有误！");
        }
    }

}
