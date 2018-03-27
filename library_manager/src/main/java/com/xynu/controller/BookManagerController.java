package com.xynu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 *  图书管理控制层
 * @author Administrator
 */
@Controller
@RequestMapping("/bookManager/")
public class BookManagerController {



    @RequestMapping
    public List getAllBook() {
        return null;
    }
}
