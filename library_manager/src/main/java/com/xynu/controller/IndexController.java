package com.xynu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/index/")
public class IndexController {


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
}
