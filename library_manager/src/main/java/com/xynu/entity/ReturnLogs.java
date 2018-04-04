package com.xynu.entity;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wyr
 * @date 2018/3/29
 */
@Data
public class ReturnLogs {

    private Integer id;
    private Integer borrowId;
    private String  message;
    private Date    createTime;
    private Integer userId;
}
