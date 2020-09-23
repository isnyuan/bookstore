package com.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 功能描述: 用于接收使用用户输入的Form数据
 * @Author: lihuizong
 * @Date: 2020/9/23 19:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDTO {

    /**
     * 商品编号列表
     */
    List<String> goodsCodeList;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品状态
     */
    private String goodsActive;

    /**
     * 最后一次修改者的用户编号
     */
    private String lastUpdateUser;

}
