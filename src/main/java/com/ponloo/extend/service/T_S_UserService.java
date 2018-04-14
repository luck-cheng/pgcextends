package com.ponloo.extend.service;

import com.ponloo.extend.model.T_S_User;

/**
 * Created by Administrator on 2017/7/17.
 */
public interface T_S_UserService {
    T_S_User findOne(String username);
}
