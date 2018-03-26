package com.xynu.mapper;


import com.xynu.model.User;

/**
 * @author Administrator
 */
public interface UserMapper {

    /**
     * 用户登录校验
     * @param user  用户信息
     * @return
     */
    Integer check(User user);


}
