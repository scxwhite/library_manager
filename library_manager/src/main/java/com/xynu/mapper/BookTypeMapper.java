package com.xynu.mapper;


import com.xynu.entity.Book;
import com.xynu.entity.BookType;

import java.util.List;

/**
 * @author Administrator
 */
public interface BookTypeMapper {


    /**
     * 查询所有图书类型
     * @return List
     */
    List<BookType> selectAllBookType ();

    /**
     *  添加图书类型
      * @param book BookType
     * @return Integer
     */
    Integer insertBookType(BookType book);

    /**
     * 根据ID更新
     * @param book  book
     * @return Integer
     */
    Integer updateBookType(BookType book);

    /**
     * 根据ID删除
     * @param typeId
     * @return Integer
     */
    Integer deleteById(Integer typeId);
}
