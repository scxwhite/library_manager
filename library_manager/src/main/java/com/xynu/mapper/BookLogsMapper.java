package com.xynu.mapper;

import com.xynu.entity.BorrowLogs;
import com.xynu.entity.ReturnLogs;
import com.xynu.model.Status;

import java.util.List;

public interface BookLogsMapper {


    /**
     * 根据用户ID查找日志
     * @param userId
     * @return
     */
    List<BorrowLogs> selectBorrowLogsByUserId(Integer userId);

    List<ReturnLogs> selectReturnLogsByUserId(Integer userId);

    Integer insertBorrowLogs(BorrowLogs borrowLogs);

    Integer insertReturnLogs(ReturnLogs returnLogs);

    List<Status> selectBorrowPeopleType();

    List<Status> borrowLogsInWeek();

    List<Status> returnLogsInWeek();

}
