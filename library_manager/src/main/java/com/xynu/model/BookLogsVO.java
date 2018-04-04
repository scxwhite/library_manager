package com.xynu.model;

import lombok.Data;


/**
 *
 * @author wyr
 * @date 2018/3/29
 */
@Data
public class BookLogsVO {
    private Integer id;
    private String bookName;
    private String username;
    private String opType;
    private String message;
    private String createTime;
    private Integer bookId;


}
