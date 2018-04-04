package com.xynu.service.impl;

import com.xynu.entity.Book;
import com.xynu.entity.BorrowLogs;
import com.xynu.entity.ReturnLogs;
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

import java.util.*;

@Service
public class BookLogsServiceImpl implements BookLogsService {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @Autowired
    private BookLogsMapper bookLogsMapper;

    @Override
    public List<BookLogsVO> findBorrowLogsByUserId(Integer userId) {
        List<BorrowLogs> borrowLogs = bookLogsMapper.selectBorrowLogsByUserId(userId);
        if (borrowLogs == null ) {
            return new ArrayList<>(0);
        }
        List<BookLogsVO> bookLogsVOS = new ArrayList<>(borrowLogs.size());
        User user = userService.findUserById(userId);
        Map<Integer, String> bookNameCache = new HashMap<>();
        borrowLogs.forEach(x -> {
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
            bookLogsVO.setOpType("借阅");
            bookLogsVOS.add(bookLogsVO);
        });
        return bookLogsVOS;
    }

    @Override
    public List<ReturnLogs> findReturnLogsByUserId(Integer userId) {
        return bookLogsMapper.selectReturnLogsByUserId(userId);
    }

    @Override
    public Integer insertBorrowLogs(BorrowLogs borrowLogs) {
        return bookLogsMapper.insertBorrowLogs(borrowLogs);
    }


    @Override
    public List<BookLogsVO> getNotReturnBooks(Integer userId) {
        List<BookLogsVO> bookLogsVOS = this.findBorrowLogsByUserId(userId);
        List<ReturnLogs> returnLogs = this.findReturnLogsByUserId(userId);
        Set<BookLogsVO> voSet = new HashSet<>();
        int size = bookLogsVOS.size();
        returnLogs.forEach(returnLog -> {
            for (int i = 0; i< size; i++) {
                BookLogsVO bookLogsVO = bookLogsVOS.get(i);
                if (Objects.equals(bookLogsVO.getId(), returnLog.getBorrowId())) {
                    voSet.add(bookLogsVO);
                }
            }
        });
        voSet.forEach(vo ->  bookLogsVOS.remove(vo));

        return bookLogsVOS;
    }

    @Override
    public Integer insertReturnLogs(ReturnLogs returnLogs) {
        return bookLogsMapper.insertReturnLogs(returnLogs);
    }

}
