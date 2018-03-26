package com.xynu.service.impl;

import com.xynu.mapper.UserMapper;
import com.xynu.model.User;
import com.xynu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录校验
     * @param user  登录用户
     * @return  结果
     */
    @Override
    public boolean login (User user) {
        Integer check = userMapper.check(user);
        if (check == null || check == 0) {
            return false;
        }
        return true;
    }
}
