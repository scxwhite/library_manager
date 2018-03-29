package com.xynu.service.impl;

import com.xynu.entity.Book;
import com.xynu.entity.BookLogs;
import com.xynu.mapper.UserMapper;
import com.xynu.entity.User;
import com.xynu.model.BookLogsVO;
import com.xynu.service.BookService;
import com.xynu.service.UserService;
import com.xynu.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookService bookService;

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

    @Override
    public List<BookLogsVO> findLogsByUserId(Integer userId) {
        List<BookLogs> bookLogs = userMapper.selectLogsByUserId(userId);
        if (bookLogs == null ) {
            return new ArrayList<>(0);
        }
        List<BookLogsVO> bookLogsVOS = new ArrayList<>(bookLogs.size());
        User user = this.findUserById(userId);
        Map<Integer, String> bookNameCache = new HashMap<>();
        bookLogs.forEach(x -> {
            BookLogsVO bookLogsVO = new BookLogsVO();
            BeanUtils.copyProperties(x, bookLogsVO);
            if (bookNameCache.get(x.getBookId()) != null) {
                bookLogsVO.setBookName(bookNameCache.get(x.getBookId()));
            } else {
                Book book = bookService.findBookById(x.getBookId());
                bookLogsVO.setBookName(book.getTitle());
                bookNameCache.put(x.getBookId(), book.getTitle());
            }
            bookLogsVO.setUsername(user.getUsername());
            bookLogsVO.setCreateTime(DateUtil.getStringDate(null, x.getCreateTime()));
            bookLogsVO.setOpType(x.getOpType() == 1 ? "还书" : "借阅");
            bookLogsVOS.add(bookLogsVO);
        });
        return bookLogsVOS;
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectUserById(id);
    }
}
