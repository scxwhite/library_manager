package com.xynu.service.impl;

import com.xynu.entity.Book;
import com.xynu.entity.BookLogs;
import com.xynu.entity.User;
import com.xynu.mapper.BookLogsMapper;
import com.xynu.model.BookLogsVO;
import com.xynu.service.BookService;
import com.xynu.service.BookLogsService;
import com.xynu.service.UserService;
import com.xynu.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BookBookLogsServiceImpl implements BookLogsService {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @Autowired
    private BookLogsMapper bookLogsMapper;

    @Override
    public List<BookLogsVO> findLogsByUserId(Integer userId) {
        List<BookLogs> bookLogs = bookLogsMapper.selectLogsByUserId(userId);
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addLog(Integer bookId, Integer userId) {
        Book book = bookService.findBookById(bookId);
        if (book.getStocks() < 1) {
            return false;
        }
        //准备借书
        book.setStocks(book.getStocks() - 1);
        bookService.updateBook(book);
        BookLogs bookLogs = new BookLogs();
        bookLogs.setBookId(bookId);
        bookLogs.setUserId(userId);
        bookLogs.setOpType(0);
        Integer x = bookLogsMapper.insertLog(bookLogs);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }

}
