package com.xynu.mapper;

import com.xynu.entity.BookLog;

import java.util.List;

/**
 * Created by wyr on 2018/4/1.
 */
public interface BookLogMapper {
    List<BookLog> selectLogsByUserId (Integer userId);
}
