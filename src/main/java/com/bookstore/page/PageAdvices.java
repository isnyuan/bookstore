package com.bookstore.page;

import com.github.pagehelper.PageHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 功能描述: AOP实现分页
 * @Author: lihuizong
 * @Date: 2020/9/26 12:16
 */
@Component
@Aspect
public class PageAdvices {
    
    @Before("execution(* *ByPage(..))")
    public void before(JoinPoint jp) {
        if (PaginationContext.isPage() != null && PaginationContext.isPage()) {
            int pageNum = PaginationContext.getPageNum();
            int pageSize = PaginationContext.getPageSize();
            PageHelper.startPage(pageNum, pageSize);
        }
    }

}
