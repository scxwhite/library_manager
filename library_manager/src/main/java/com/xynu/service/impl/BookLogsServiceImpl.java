package com.xynu.service.impl;

import com.xynu.entity.Book;
import com.xynu.entity.BorrowLogs;
import com.xynu.entity.ReturnLogs;
import com.xynu.entity.User;
import com.xynu.mapper.BookLogsMapper;
import com.xynu.model.BookLogsVO;
import com.xynu.model.Status;
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

    @Override
    public List<BookLogsVO> fincLogsByUserId(Integer userId) {
        List<BookLogsVO> bookLogsVOS = this.findBorrowLogsByUserId(userId);
        List<ReturnLogs> returnLogs = this.findReturnLogsByUserId(userId);
        List<BookLogsVO> returnBooks = new ArrayList<>(returnLogs.size());
        User user = userService.findUserById(userId);
        String username = user.getUsername();
        returnLogs.forEach(x -> {
            bookLogsVOS.forEach(y -> {
                if (Objects.equals(x.getBorrowId(), y.getId())) {
                    BookLogsVO bookLogsVO = new BookLogsVO();
                    bookLogsVO.setBookName(y.getBookName());
                    bookLogsVO.setOpType("还书");
                    bookLogsVO.setUsername(username);
                    bookLogsVO.setCreateTime(DateUtil.getStringDate("yyyy-MM-dd HH:mm:ss", x.getCreateTime()));
                    returnBooks.add(bookLogsVO);
                }
            });
        });
        bookLogsVOS.addAll(returnBooks);
        bookLogsVOS.sort((x, y) -> -x.getCreateTime().compareTo(y.getCreateTime()));

        return bookLogsVOS;
    }

    @Override
    public List<Status> borrowUserSex() {
        return bookLogsMapper.selectBorrowPeopleType();
    }

    @Override
    public Map logsInWeek() {
        List<Status> borrowLogs = bookLogsMapper.borrowLogsInWeek();
        List<Status> returnLogs = bookLogsMapper.returnLogsInWeek();
        List<String> dateList = new ArrayList<>(7);
        Map<String, String> dateToWeek = new HashMap<>(7);
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_YEAR, -6);
        String curDate;
        while(startDate.compareTo(endDate) <= 0) {
            curDate = DateUtil.getStringDate("yyyy-MM-dd", startDate.getTime());
            dateList.add(curDate);
            dateToWeek.put(curDate ,getWeekOfDate(startDate));
            startDate.add(Calendar.DAY_OF_YEAR, 1);
        }
        Map<String, Object> res = new HashMap<>(3);
        if (borrowLogs != null) {
            res.put("borrow", borrowLogs);
        }
        if (returnLogs != null) {
            res.put("return", returnLogs);

        }
        res.put("legend", dateList);
        res.put("dateToWeek", dateToWeek);

        return res;
    }

    private String getWeekOfDate(Calendar calendar) {
        String [] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int t = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (t < 0) {
            t = 0;
        }
        return weeks[t];
    }

}
