package com.xynu.mapper;


import com.xynu.entity.BookLogs;
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

    /**
     * 根据ID删除用户
     * @param id    id
     * @return  Integer
     */
    Integer deleteUser(Integer id);

    /**
     * 根据ID更新用户
     * @param user  用户
     * @return  Integer
     */
    Integer updateUser(User user);

    /**
     * 插入用户
     * @param user  用户
     * @return Integer
     */
    Integer insertUser(User user);

    /**
     * 根据用户ID查找日志
     * @param userId
     * @return
     */
    List<BookLogs> selectLogsByUserId(Integer userId);

    User selectUserById(Integer id);
}
