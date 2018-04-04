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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class BookLogsServiceImpl implements BookLogsService {

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
    public Integer insertLog(BookLogs bookLogs) {
        return bookLogsMapper.insertLog(bookLogs);
    }


    @Override
    public List<BookLogsVO> getNotReturnBooks(Integer userId) {
        List<BookLogsVO> bookLogsVOS = this.findLogsByUserId(userId);
        bookLogsVOS.sort((book1, book2) -> {
            int x = book1.getCreateTime().compareTo(book2.getCreateTime());
            return x;
        });
        List<BookLogsVO> borrowList = new ArrayList<>();
        List<BookLogsVO> returnList = new ArrayList<>();
        for (BookLogsVO bookLogsVO : bookLogsVOS) {
            if (bookLogsVO.getOpType().equals("借阅")){
                borrowList.add(bookLogsVO);
            } else {
                returnList.add(bookLogsVO);
            }
        }
        returnList.forEach(bookLogsVO -> {
            borrowList.remove(bookLogsVO);
        });

        return borrowList;
    }

}
