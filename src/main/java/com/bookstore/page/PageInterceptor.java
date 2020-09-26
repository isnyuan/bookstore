package com.bookstore.page;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能描述: 分页拦截器
 * @Author: lihuizong
 * @Date: 2020/9/26 12:06
 */
@Component
public class PageInterceptor implements HandlerInterceptor {

    /**
     * 功能描述: 拦截
     * @Author: lihuizong
     * @Date: 2020/9/26 12:19
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int pageNum, pageSize;
        String pageNumStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");
        if ((pageNumStr != null || "".equals(pageNumStr)) && (pageSizeStr != null || "".equals(pageSizeStr))) {
            pageNum = Integer.parseInt(pageNumStr);
            pageSize = Integer.parseInt(pageSizeStr);
            PaginationContext.setPageNum(pageNum);
            PaginationContext.setPageSize(pageSize);
            PaginationContext.setIsPage(true);
        } else {
            PaginationContext.setIsPage(false);
        }

        return true;
    }

    /**
     * 功能描述: 请求之后清空参数
     * @Author: lihuizong
     * @Date: 2020/9/26 12:18
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        PaginationContext.clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
