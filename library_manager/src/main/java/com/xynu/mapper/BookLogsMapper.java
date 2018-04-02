package com.xynu.mapper;

import com.xynu.entity.BookLogs;

import java.util.List;

public interface BookLogsMapper {


    /**
     * 根据用户ID查找日志
     * @param userId
     * @return
     */
    List<BookLogs> selectLogsByUserId(Integer userId);

    Integer insertLog(BookLogs bookLogs);
}
