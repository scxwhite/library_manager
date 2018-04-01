package com.xynu.service;


import com.xynu.entity.Book;
import com.xynu.model.BookVO;

import java.util.List;

/**
 * @author Administrator
 */
public interface BookService {

    List<Book> findAllBook();

    boolean addBook(Book book);

    boolean updateBook(Book book);

    boolean delBook (Integer id);

    Book findBookById(Integer bookId);

    List<Book> findCanBorrowBooks ();

    boolean borrowBook (Integer bookId);
}
