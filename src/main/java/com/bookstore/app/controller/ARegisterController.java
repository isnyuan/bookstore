package com.bookstore.app.controller;

import com.bookstore.app.entity.ARegisterInfo;
import com.bookstore.app.service.ARegisterService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 作者：李丹涛
 * 时间：2020/04/15下午14：44分
 * 功能：注册用户Controller类
 */

@RestController
@RequestMapping("/app/register")
@Validated
public class ARegisterController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(ARegisterController.class);

    //注入RegisterService类
    @Resource
    private ARegisterService aRegisterService;


    /**
     * 作者：李丹涛
     * 时间：2020/04/15下午14：44分
     * 功能：注册用户
     */
    @PostMapping("/clientRegister")
    public Response clientRegister(ARegisterInfo registerInfo){
        try {
            return aRegisterService.clientRegister(registerInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("注册客户操作有误！");
        }
    }

}
