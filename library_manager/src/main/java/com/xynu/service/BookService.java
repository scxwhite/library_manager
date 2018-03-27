package com.xynu.service;


import com.xynu.entity.Book;

import java.util.List;

/**
 * @author Administrator
 */
public interface BookService {

    List<Book> findAllBook();

    boolean addBook(Book book);

    boolean updateBook(Book book);
}
