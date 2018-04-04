package com.xynu.service.impl;

import com.xynu.entity.Book;
import com.xynu.entity.BookLogs;
import com.xynu.mapper.BookMapper;
import com.xynu.service.BookLogsService;
import com.xynu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyr on 2018/3/27.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookLogsService bookLogsService;

    @Override
    public List<Book> findAllBook () {
        List<Book> books = bookMapper.selectAllBook();
        if (books == null) {
            return new ArrayList<>(0);
        }
        return books;
    }

    @Override
    public boolean addBook (Book book) {
        Integer x = bookMapper.insertBook(book);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBook (Book book) {
        Integer x = bookMapper.updateBook(book);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delBook (Integer id) {
        Integer x = bookMapper.deleteBook(id);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Book findBookById(Integer bookId) {
        return bookMapper.selectBookById(bookId);
    }

    @Override
    public List<Book> findCanBorrowBooks () {
        List<Book> books = bookMapper.selectCanBorrowBooks();
        if (books == null) {
            return new ArrayList<>(0);
        }
        return books;
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized boolean borrowBook (Integer userId, Integer bookId) {
        Book book = this.findBookById(bookId);
        if (book.getStocks() < 1) {
            return false;
        }
        //准备借书
        book.setStocks(book.getStocks() - 1);
        this.updateBook(book);
        BookLogs bookLogs = new BookLogs();
        bookLogs.setBookId(bookId);
        bookLogs.setUserId(userId);
        bookLogs.setOpType(0);
        Integer x = bookLogsService.insertLog(bookLogs);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean returnBook(Integer userId, Integer bookId) {

        Book book = this.findBookById(bookId);
        //准备还书
        book.setStocks(book.getStocks() + 1);
        this.updateBook(book);
        BookLogs bookLogs = new BookLogs();
        bookLogs.setBookId(bookId);
        bookLogs.setUserId(userId);
        bookLogs.setOpType(1);
        Integer x = bookLogsService.insertLog(bookLogs);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }
}
