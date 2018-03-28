package com.xynu.mapper;


import com.xynu.entity.Book;
import com.xynu.entity.BookType;

import java.util.List;

/**
 * @author Administrator
 */
public interface BookTypeMapper {


    /**
     * 查询所有图书
     * @return List
     */
    List<BookType> selectAllBookType ();
}
