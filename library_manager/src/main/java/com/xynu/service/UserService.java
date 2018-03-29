package com.xynu.service;

import com.xynu.entity.User;
import com.xynu.model.BookLogsVO;

import java.util.List;


/**
 * @author Administrator
 */
public interface UserService {

    boolean login(User user);

    List<User> findAllUser ();

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean delUser(Integer id);

    List<BookLogsVO> findLogsByUserId(Integer userId);

    User findUserById(Integer id);
}
