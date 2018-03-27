package com.xynu.service.impl;

import com.xynu.entity.Book;
import com.xynu.mapper.BookMapper;
import com.xynu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public boolean addBook (Book book) {
        return false;
    }

    @Override
    public boolean updateBook (Book book) {
        return false;
    }
}
