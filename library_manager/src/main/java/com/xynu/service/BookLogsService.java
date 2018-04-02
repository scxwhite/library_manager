package com.xynu.service;

import com.xynu.model.BookLogsVO;

import java.util.List;

public interface BookLogsService {

    List<BookLogsVO> findLogsByUserId(Integer userId);

    boolean addLog(Integer bookId, Integer userId);
}
