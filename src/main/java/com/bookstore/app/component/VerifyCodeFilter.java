package com.bookstore.app.component;

import com.alibaba.druid.util.StringUtils;
import com.bookstore.utils.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 功能描述: 验证码验证拦截器
 * @Author: lihuizong
 * @Date: 2020/10/12 20:01
 */
@Component
public class VerifyCodeFilter extends GenericFilterBean {

    private String defaultFilterProcessUrl = "/login";

    /**
     *  model 对象（类和结构体）和 JSON 之间的转换。
     */
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if ("POST".equalsIgnoreCase(request.getMethod()) && defaultFilterProcessUrl.equals(request.getServletPath())) {
            // 验证码验证
            String requestCaptcha = request.getParameter("imageCode");
            String genCaptcha = (String) request.getSession().getAttribute("imageCode");

            if (genCaptcha != null && "".equals(requestCaptcha)) {
                String token = null;
                HashMap<String, String> access_token = new HashMap<>();
                access_token.put("access_token", token);
                access_token.put("role", null);
                Response failure = new Response(6001+"", "验证码不能为空！", access_token);
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write(objectMapper.writeValueAsString(failure));
                out.flush();
                out.close();
            }
            if (genCaptcha != null && !genCaptcha.equals(requestCaptcha)) {
                String token = null;
                HashMap<String, String> access_token = new HashMap<>();
                access_token.put("access_token", token);
                access_token.put("role", null);
                Response failure = new Response(6000+"", "请输入正确的验证码！", access_token);
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write(objectMapper.writeValueAsString(failure));
                out.flush();
                out.close();
            }
        }
        chain.doFilter(request, response);
    }
}