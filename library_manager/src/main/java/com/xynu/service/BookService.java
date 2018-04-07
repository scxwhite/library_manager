package com.xynu.service;


import com.xynu.entity.Book;
import com.xynu.model.Status;

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

    boolean borrowBook (Integer userId, Integer bookId);

    boolean returnBook(Integer userId, Integer bookId, Integer borrowId);

    List<Status> bookTypeStatus();

}
