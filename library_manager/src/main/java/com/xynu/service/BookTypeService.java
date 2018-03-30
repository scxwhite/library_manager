package com.xynu.service;


import com.xynu.entity.BookType;

import java.util.List;

/**
 * @author Administrator
 */
public interface BookTypeService {

    List<BookType> findAllBookType ();

    boolean addBookType (BookType book);

    boolean updateBookType (BookType book);

    boolean deleteBookType(Integer typeId);

    BookType findById (Integer typeId);
}
