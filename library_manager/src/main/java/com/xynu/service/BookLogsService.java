package com.xynu.service;

import com.xynu.entity.BookLogs;
import com.xynu.model.BookLogsVO;

import java.util.List;

public interface BookLogsService {

    List<BookLogsVO> findLogsByUserId(Integer userId);


    Integer insertLog(BookLogs bookLogs);


    List<BookLogsVO> getNotReturnBooks(Integer userId);
}
