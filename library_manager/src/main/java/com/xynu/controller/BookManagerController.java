package com.xynu.controller;

import com.xynu.entity.Book;
import com.xynu.entity.BookType;
import com.xynu.service.BookService;
import com.xynu.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 *  图书管理控制层
 * @author Administrator
 */
@Controller
@RequestMapping("/bookManager/")
public class BookManagerController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookTypeService bookTypeService;

    @RequestMapping(value = "bookList", method = RequestMethod.GET)
    @ResponseBody
    public List bookList() {
        return bookService.findAllBook();
    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    @ResponseBody
    public boolean addBook(Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping(value = "updateBook", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateBook(Book book) {
        return bookService.updateBook(book);
    }

    @RequestMapping(value = "delBook", method = RequestMethod.GET)
    @ResponseBody
    public boolean delBook(Integer id) {
        return bookService.delBook(id);
    }

    @RequestMapping(value = "bookTypeList", method = RequestMethod.GET)
    @ResponseBody
    public List<BookType> bookTypeList() {
        return bookTypeService.findAllBookType();
    }

    @RequestMapping(value = "addBookType", method = RequestMethod.POST)
    @ResponseBody
    public boolean addBookType(BookType bookType) {
        return bookTypeService.addBookType(bookType);
    }

    @RequestMapping(value = "updateBookType", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateBookType(BookType bookType) {
        return bookTypeService.updateBookType(bookType);
    }

    @RequestMapping(value = "delBookType", method = RequestMethod.POST)
    @ResponseBody
    public boolean delBookType(Integer id) {
        return bookTypeService.deleteBookType(id);
    }

    @RequestMapping(value = "borrow", method = RequestMethod.POST)
    @ResponseBody
    public boolean borrowBook(Integer userId, Integer bookId){
        return bookService.borrowBook(userId, bookId);
    }

    @RequestMapping(value = "return", method = RequestMethod.POST)
    @ResponseBody
    public boolean returnBook(Integer userId, Integer bookId){
        return bookService.returnBook(userId, bookId);
    }


}
