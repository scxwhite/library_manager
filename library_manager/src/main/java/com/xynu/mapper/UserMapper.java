package com.xynu.mapper;


import com.xynu.entity.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserMapper {

    /**
     * 用户登录校验
     * @param user  用户信息
     * @return 数量
     */
    Integer check(User user);

    /**
     * 查询所有用户
     * @return Users
     */
    List<User> selectAllUser ();
}
