package com.bookstore.controller;

import com.bookstore.entity.UserDTO;
import com.bookstore.entity.UserInfo;
import com.bookstore.service.UserService;
import com.bookstore.utils.Response;
import com.bookstore.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pc/user")
@Validated
public class UserController {

    //日志
    private final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private UserService userService;

    /**
     * 功能描述: 通过用户编号查询用户
     * @Author: lihuizong
     * @Date: 2020/9/20 13:35
     */
    @PostMapping("/findUser")
    public Response findUser(String userCode) {
        System.out.println(userCode);
        try {
            return userService.findUser(userCode);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("查询用户详情操作有误！");
        }
    }

    /**
     * 功能描述: 添加用户
     * @Author: lihuizong
     * @Date: 2020/9/20 13:43
     */
    @PostMapping("/addUser")
    public Response addUser(UserInfo userInfo) {
        try {
            return userService.addUser(userInfo);
        } catch (Exception e) {
            logger.error(e.toString());
            return Response.servers("新增用户操作有误！");
        }
    }

    /**
     * 功能描述: 查询用户信息
     * @Author: lihuizong
     * @Date: 2020/9/20 13:45
     */
    @PostMapping("/listUser")
    public Response listUser(UserInfo userInfo) {
        try {
            return userService.listUser(userInfo);
        } catch (Exception e) {
            return Response.servers("查询用户分页列表信息操作有误！");
        }
    }

    /**
     * 功能描述: 更新用户信息
     * @Author: lihuizong
     * @Date: 2020/9/20 13:48
     */
    @PostMapping("/updateUser")
    public Response updateUser(UserInfo userInfo) {
        try {
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            return Response.servers("修改用户操作有误！");
        }
    }

    /**
     * 功能描述: 删除用户
     * @Author: lihuizong
     * @Date: 2020/9/20 13:51
     */
    @PostMapping("/deleteUser")
    public Response deleteUser(UserDTO userDTO) {
        try {
            return userService.deleteUser(userDTO);
        } catch (Exception e) {
            return Response.servers("删除用户操作有误！");
        }
    }

    @GetMapping("/test")
    public void test() {
        System.out.println(SecurityUtils.getCurrentUserCode());
        System.out.println(SecurityUtils.getCurrentUserAccount());
    }

}
