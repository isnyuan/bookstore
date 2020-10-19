package com.bookstore.app.controller;

import com.bookstore.app.entity.AUserInfo;
import com.bookstore.app.service.AUserService;
import com.bookstore.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 功能描述: 用户个人信息
 * @Author: lihuizong
 * @Date: 2020/10/19 11:39
 */

@RestController
@RequestMapping("/app/user")
@Validated
public class AUserController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(AUserController.class);

    //注入UserSevice类
    @Resource
    private AUserService aUserService;

    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨02：41分
     * 功能：查询个人信息
     */
    @PostMapping("/findUser")
    public Response findUser(){
        try {
            return aUserService.findUser();
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询个人信息有误！");
        }
    }

    /**
     * 作者：李丹涛
     * 时间：2020/04/19凌晨02：43分
     * 功能：修改密码
     */
    @PostMapping("/updateUserPassword")
    public Response updateUserPassword(AUserInfo userInfo) {
        try {
            return aUserService.updateUserPassword(userInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("修改密码操作有误！");
        }
    }

}
