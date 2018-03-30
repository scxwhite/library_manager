package com.xynu.controller;


import com.xynu.entity.Book;
import com.xynu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/page/")
public class IndexController {

    @Autowired
    private BookService bookService;

    /**
     * 页面跳转控制
     * @param page  要跳转的页面
     * @return
     */
    @RequestMapping("{page}")
    public ModelAndView toIndex(@PathVariable("page") String page) {
        ModelAndView modelAndView = new ModelAndView(page);
        return modelAndView;

    }

    @RequestMapping("model/borrow")
    public ModelAndView toBorrow() {
        ModelAndView modelAndView = new ModelAndView("borrow");
        //TODO  分页
        List<Book> allBook = bookService.findAllBook();
        if (allBook != null) {
            modelAndView.addObject("books", allBook);
        }
        return modelAndView;
    }
}
