package com.bookstore.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 功能描述: 分页工具类
 * @Author: lihuizong
 * @Date: 2020/9/26 12:17
 */
public class PageUtils {

    public static Object getPageInfo(Object obj) {
        if (obj instanceof Page) {
            return new PageInfo<>((List) obj);
        }
        return obj;
    }

}
