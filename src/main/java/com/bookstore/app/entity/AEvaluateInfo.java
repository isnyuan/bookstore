package com.bookstore.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AEvaluateInfo {

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 评价内容
     */
    private String evaluateContent;

    /**
     * 评价等级
     */
    private String evaluateScore;

    /**
     * 评价图片序号
     */
    private String imageSortNum;

    /**
     * 评价图片路径
     */
    private String goodsEvaluateImage;

    /**
     * 平均星级
     */
    private Double avgScore;

    /**
     * 商品list
     */
    private List<AEvaluateInfo> list;

    /**
     * 评价图片list
     */
    private List<AEvaluateInfo> imageList;

}
