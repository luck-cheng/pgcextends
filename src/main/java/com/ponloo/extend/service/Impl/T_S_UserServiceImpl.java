package com.ponloo.extend.service.Impl;

import com.ponloo.extend.model.T_S_User;
import com.ponloo.extend.repository.UserRepository;
import com.ponloo.extend.service.T_S_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/7/17.
 */
@Service
public class T_S_UserServiceImpl implements T_S_UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public T_S_User findOne(String username) {
        T_S_User user = userRepository.findUserByUName(username);
        return user;
    }
}
