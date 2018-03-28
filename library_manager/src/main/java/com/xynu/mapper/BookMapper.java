package com.xynu.mapper;


import com.xynu.entity.Book;
import com.xynu.model.BookVO;

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
}
