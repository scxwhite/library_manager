package com.xynu.mapper;


import com.xynu.entity.Book;
import com.xynu.entity.User;

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
}
