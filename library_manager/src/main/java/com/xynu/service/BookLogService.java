package com.xynu.service;

import com.xynu.model.BookLogsVO;

import java.util.List;

/**
 * Created by wyr on 2018/4/1.
 */
public interface BookLogService {

    List<BookLogsVO> findLogsByUserId(Integer userId);
}
