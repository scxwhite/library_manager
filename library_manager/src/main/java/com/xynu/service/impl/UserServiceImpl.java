package com.xynu.service.impl;

import com.xynu.mapper.UserMapper;
import com.xynu.entity.User;
import com.xynu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    @Override
    public List<User> findAllUser () {
        List<User> users = userMapper.selectAllUser();
        if (users == null) {
            return new ArrayList<>();
        }
        return users;
    }

    @Override
    public boolean addUser(User user) {
        Integer x = userMapper.insertUser(user);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        Integer x = userMapper.updateUser(user);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delUser(Integer id) {
        Integer x = userMapper.deleteUser(id);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }
}
