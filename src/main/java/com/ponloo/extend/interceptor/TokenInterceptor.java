package com.ponloo.extend.interceptor;

import com.ponloo.extend.annotation.Token;
import com.ponloo.extend.config.TokenConfig;
import com.ponloo.extend.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/18.
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

//    private static final String DEFAULT_TOKEN_NAME = "XToken";
    @Autowired
    TokenConfig tokenConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token tokenAnnotaion = method.getAnnotation(Token.class);
            if (tokenAnnotaion == null) {
                return true;
            } else {
                String token = request.getHeader(tokenConfig.getrHeard());
                if (token == null || token.isEmpty()) {
                    String ip = request.getRemoteAddr();
                    String uri = request.getRequestURI();
                    throw new Exception("缺少token参数, " + ip + ", 请求了：" + uri);
                }

                    Claims claims = JWTUtil.parseJWT(token, tokenConfig.getSecret());
                    if(claims == null){
                        throw new Exception("解析token失败。");
                    }

            }
        }
        return true;
    }
}