package com.xynu.service;

import com.xynu.entity.BorrowLogs;
import com.xynu.entity.ReturnLogs;
import com.xynu.model.BookLogsVO;

import java.util.List;

public interface BookLogsService {

    List<BookLogsVO> findBorrowLogsByUserId(Integer userId);

    List<ReturnLogs> findReturnLogsByUserId(Integer userId);


    Integer insertBorrowLogs(BorrowLogs borrowLogs);


    List<BookLogsVO> getNotReturnBooks(Integer userId);

    Integer insertReturnLogs(ReturnLogs returnLogs);
}
