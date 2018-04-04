package com.xynu.model;

import lombok.Data;

import java.util.Objects;

/**
 *
 * @author wyr
 * @date 2018/3/29
 */
@Data
public class BookLogsVO {
    private String bookName;
    private String username;
    private String opType;
    private String message;
    private String createTime;
    private Integer bookId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLogsVO that = (BookLogsVO) o;
        return bookName.equals(that.bookName) &&
                username.equals(that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, username);
    }
}
