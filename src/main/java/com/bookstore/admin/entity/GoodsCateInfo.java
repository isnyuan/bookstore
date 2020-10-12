package com.bookstore.admin.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述: 商品分类
 * @Author: lihuizong
 * @Date: 2020/9/21 16:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCateInfo {

    /**
     * 商品分类编号
     */
    private String goodsCateCode;

    /**
     * 商品分类名称
     */
    private String goodsCateName;

    /**
     * 商品分类备注
     */
    private String goodsCateRemark;

    /**
     * 分类父类编号（一级分类传0，二级分类传一级分类编号）
     */
    private String cateParentCode;

    /**
     * 删除标记（1删除、0不删除）
     */
    private String isDelete;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 最后一次更新者
     */
    private String lastUpdateUser;

    /**
     * 最后一次更新时间
     */
    private String lastUpdateTime;

    /**
     * 版本
     */
    private String version;

}
