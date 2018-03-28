package com.xynu.service.impl;

import com.xynu.entity.Book;
import com.xynu.mapper.BookMapper;
import com.xynu.model.BookVO;
import com.xynu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyr on 2018/3/27.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


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
}
