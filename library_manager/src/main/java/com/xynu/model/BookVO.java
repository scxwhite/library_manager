package com.xynu.model;

import lombok.Data;

/**
 * Created by wyr on 2018/3/28.
 */
@Data
public class BookVO {
    private Integer bookId;
    private String typeName;
    private String title;
    private String publish;
    private String publishYear;
    private String author;
    private Double price;
    private Integer number;
    private Integer stocks;
}
