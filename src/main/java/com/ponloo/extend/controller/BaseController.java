package com.ponloo.extend.controller;

import com.alibaba.fastjson.JSONObject;
import com.ponloo.extend.config.TokenConfig;
import com.ponloo.extend.param.UserParam;
import com.ponloo.extend.utils.JWTUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/18.
 */
@Controller
public class BaseController {
    @Autowired
    TokenConfig tokenConfig;

    public UserParam getTokenUser(HttpServletRequest request){
        String token = request.getHeader(tokenConfig.getrHeard());
        Claims claims = JWTUtil.parseJWT(token, tokenConfig.getSecret());
        JSONObject jsonObject = (JSONObject) JSONObject.parse(claims.getSubject());
        String userId = (String) jsonObject.get("userId");
        String userName = (String) jsonObject.get("userName");
        UserParam userParam = new UserParam();
        userParam.setUserId(Long.parseLong(userId));
        userParam.setUserName(userName);
        return userParam;
    }
}
