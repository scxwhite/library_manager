package com.xynu.service;

import com.xynu.entity.BorrowLogs;
import com.xynu.entity.ReturnLogs;
import com.xynu.model.BookLogsVO;
import com.xynu.model.Status;

import java.util.List;
import java.util.Map;

public interface BookLogsService {

    List<BookLogsVO> findBorrowLogsByUserId(Integer userId);

    List<ReturnLogs> findReturnLogsByUserId(Integer userId);


    Integer insertBorrowLogs(BorrowLogs borrowLogs);


    List<BookLogsVO> getNotReturnBooks(Integer userId);

    Integer insertReturnLogs(ReturnLogs returnLogs);

    List<BookLogsVO> fincLogsByUserId(Integer userId);

    List<Status> borrowUserSex();

    Map logsInWeek();

}
