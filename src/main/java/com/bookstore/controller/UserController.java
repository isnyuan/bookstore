package com.bookstore.controller;

import com.bookstore.service.UserService;
import com.bookstore.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findUser")
    public Response findUser(String userCode) {
        System.out.println(userCode);
        try {
            return userService.findUser(userCode);
        } catch (Exception e) {
            //logger.error(e.toString());
            return Response.servers("查询用户详情操作有误！");
        }
    }

    @GetMapping("/findUser/{code}")
    public Response findUser1(@PathVariable("code") String userCode) {
        try {
            return userService.findUser(userCode);
        } catch (Exception e) {
            //logger.error(e.toString());
            return Response.servers("查询用户详情操作有误！");
        }
    }



}
