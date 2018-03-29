package com.xynu.service.impl;

import com.xynu.entity.BookType;
import com.xynu.mapper.BookTypeMapper;
import com.xynu.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wyr on 2018/3/27.
 */
@Service
public class BookTypeServiceImpl implements BookTypeService {

    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public List<BookType> findAllBookType () {
        return bookTypeMapper.selectAllBookType();
    }

    @Override
    public boolean addBookType (BookType book) {
        Integer x = bookTypeMapper.insertBookType(book);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBookType (BookType book) {
        Integer x = bookTypeMapper.updateBookType(book);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteBookType(Integer typeId) {
        Integer x = bookTypeMapper.deleteById(typeId);
        if (x == null || x == 0) {
            return false;
        }
        return true;
    }
}
