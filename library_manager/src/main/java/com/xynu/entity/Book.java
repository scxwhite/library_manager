package com.xynu.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author suchengxiang
 * @version 创建时间：2018/3/27 22:09
 */
@Data
@ToString
@NoArgsConstructor
public class Book {
    private Integer bookId;
    private Integer typeId;
    private String title;
    private String publish;
    private String publishYear;
    private String author;
    private Double price;
    private Integer number;
    private Integer stocks;
}
