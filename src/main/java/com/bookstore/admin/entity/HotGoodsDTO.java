package com.bookstore.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * 作者：李丹涛
 * 时间：2020/04/13中午10：31分
 * 功能：接受用户form传递的多参数实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotGoodsDTO {

    /**
     * 设置最后更新者
     */
    private String lastUpdateUser;

    /**
     * 设置热门商品编号列表
     */
    private List<String> hotGoodsCodeList;


    public String GoodsDTO() {
        return lastUpdateUser;
    }

    /**
     * 热门商品展示数量字典编号
     */
    private String dictionaryCode;

}
