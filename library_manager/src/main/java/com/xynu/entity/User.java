package com.xynu.entity;

import lombok.*;

/**
 * @author Administrator
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    private String password;
    /**
     * 0    :学生
     * 1    ：教师
     */
    private Integer info;

    private Integer isValid;
    private Integer sex;

}
