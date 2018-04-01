package com.xynu.service.impl;

import com.xynu.entity.Book;
import com.xynu.entity.BookLog;
import com.xynu.entity.User;
import com.xynu.mapper.BookLogMapper;
import com.xynu.model.BookLogsVO;
import com.xynu.service.BookLogService;
import com.xynu.service.BookService;
import com.xynu.service.UserService;
import com.xynu.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wyr on 2018/4/1.
 */
public class BookLogServiceImpl implements BookLogService {

    @Autowired
    private BookLogMapper bookLogMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @Override
    public List<BookLogsVO> findLogsByUserId(Integer userId) {
        List<BookLog> bookLogs = bookLogMapper.selectLogsByUserId(userId);
        if (bookLogs == null ) {
            return new ArrayList<>(0);
        }
        List<BookLogsVO> bookLogsVOS = new ArrayList<>(bookLogs.size());
        User user = userService.findUserById(userId);
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
}
