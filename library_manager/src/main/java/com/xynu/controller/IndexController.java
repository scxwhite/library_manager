package com.xynu.controller;


import com.xynu.entity.Book;
import com.xynu.entity.BookType;
import com.xynu.model.BookVO;
import com.xynu.service.BookService;
import com.xynu.service.BookTypeService;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private BookTypeService bookTypeService;

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
        List<Book> allBook = bookService.findCanBorrowBooks();
        if (allBook != null) {
            modelAndView.addObject("books", allBook);
        }
        return modelAndView;
    }

    @RequestMapping("model/bookDetail")
    public ModelAndView toBookDetail(Integer id) {
        ModelAndView modelAndView = new ModelAndView("bookDetail");
        Book bookById = bookService.findBookById(id);
        BookVO bookVO = new BookVO();
        BeanUtils.copyProperties(bookById, bookVO);
        BookType bookType = bookTypeService.findById(bookById.getTypeId());
        if (bookType != null) {
            bookVO.setTypeName(bookType.getTypeName());
        }

        modelAndView.addObject("book", bookVO);
        return modelAndView;
    }
}
