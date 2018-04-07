package com.xynu.mapper;


import com.xynu.entity.Book;
import com.xynu.model.Status;

import java.util.List;

/**
 * @author Administrator
 */
public interface BookMapper {


    /**
     * 查询所有图书
     * @return List
     */
    List<Book> selectAllBook ();

    Integer updateBook (Book book);

    Integer insertBook (Book book);

    Integer deleteBook (Integer id);

    Book selectBookById(Integer id);

    List<Book> selectCanBorrowBooks ();

    Integer borrowBook ();

    List<Status> selectBookTypeStatus();

}
