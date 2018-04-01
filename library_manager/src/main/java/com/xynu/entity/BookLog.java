package com.xynu.entity;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author wyr
 * @date 2018/3/29
 */
@Data
public class BookLog {

    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer opType;
    private String  message;
    private Date    createTime;
}
