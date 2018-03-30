package com.xynu.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @author ch
 */
@Data
@ToString
@NoArgsConstructor
public class Book {
    private Integer bookId;
    private Integer typeId;
    private String title;
    private String publish;
    private Integer publishYear;
    private String author;
    private Double price;
    private Integer number;
    private Integer stocks;
    private String url;
    private String introduce;
}
