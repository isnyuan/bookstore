package com.bookstore.security;

import com.bookstore.utils.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@Aspect
public class AuthTokenAspect {

    /// @Around注解 改变controller返回值的
    @Around("execution(* org.springframework.security.oauth2.provider.endpoint.TokenEndpoint.postAccessToken(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        // 放行
        Response response = new Response();
        Object proceed = pjp.proceed();
        if (proceed != null) {
            ResponseEntity<OAuth2AccessToken> responseEntity = (ResponseEntity<OAuth2AccessToken>) proceed;
            OAuth2AccessToken body = responseEntity.getBody();

            HashMap<String, Object> data = new HashMap<>();
            data.put("access_token", body.getValue());
            data.put("token_type", body.getTokenType());
            data.put("refresh_token", body.getRefreshToken().getValue());
            data.put("expires_in", body.getExpiresIn());
            data.put("scope", new ArrayList<String>(body.getScope()).get(0));
            //data.put("jit", body.getAdditionalInformation().get("jit").toString());
            Response success = Response.success("登录成功！", data);

            return ResponseEntity.status(200).body(success);
        }
        return ResponseEntity.status(200).body(response);
    }
}
