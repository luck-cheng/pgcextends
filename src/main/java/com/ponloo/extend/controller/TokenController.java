package com.ponloo.extend.controller;

import com.ponloo.extend.config.TokenConfig;
import com.ponloo.extend.model.T_S_User;
import com.ponloo.extend.param.LoginParam;
import com.ponloo.extend.service.T_S_UserService;
import com.ponloo.extend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/7/17.
 */
@Controller
public class TokenController {
    @Autowired
    TokenConfig tokenConfig;
    @Autowired
    T_S_UserService userService;

    @RequestMapping(name = "/getToken", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> getToken(LoginParam loginParam){
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();

        T_S_User user = userService.findOne(username);
        HashMap<String, Object> hashMap = new HashMap<>();
        String token = null;
        if(user != null && (password).equals(user.getPassword())){
            token = JWTUtil.createJWT(loginParam.getUsername(), user.getId().toString(), "client", "server", tokenConfig.getExptime(), tokenConfig.getSecret());
            hashMap.put("XToken", token);
            hashMap.put("code", 200);
            hashMap.put("data", "success");
            return hashMap;
        }
        hashMap.put("XToken", null);
        hashMap.put("code", 500);
        hashMap.put("data", "failure");
        return hashMap;
    }
}
