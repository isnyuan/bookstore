package com.bookstore.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 功能描述: 接受前端多参信息
 * @Author: lihuizong
 * @Date: 2020/10/19 16:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AShopCarDTO {

    /**
     * 购物车编号列表
     */
    List<String> shopCarCodeList;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 最后一次修改者的用户编号
     */
    private String lastUpdateUser;

}
