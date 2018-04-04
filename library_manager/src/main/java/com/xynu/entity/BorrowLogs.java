package com.xynu.entity;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wyr
 * @date 2018/3/29
 */
@Data
public class BorrowLogs {

    private Integer id;
    private Integer userId;
    private Integer bookId;
    private String  message;
    private Date    createTime;
}
