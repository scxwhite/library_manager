package com.xynu.controller;

import com.xynu.model.BookLogsVO;
import com.xynu.service.BookLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * @author xiaosuda
 * @date 2018/3/29
 */
@Controller
@RequestMapping("/logs/")
public class BookLogsController {

    @Autowired
    private BookLogsService bookLogsService;

    @RequestMapping("find")
    @ResponseBody
    public List<BookLogsVO> findLogsByUserId(Integer userId) {
        return bookLogsService.findLogsByUserId(userId);
    }

    @RequestMapping("add")
    @ResponseBody
    public boolean addLog(Integer bookId,Integer userId) {
        return bookLogsService.addLog(bookId, userId);
    }
}