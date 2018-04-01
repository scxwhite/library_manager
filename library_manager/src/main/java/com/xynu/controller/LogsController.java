package com.xynu.controller;

import com.xynu.model.BookLogsVO;
import com.xynu.service.BookLogService;
import com.xynu.service.UserService;
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
public class LogsController {

    @Autowired
    private BookLogService bookLogService;

    @RequestMapping("find")
    @ResponseBody
    public List<BookLogsVO> findLogsByUserId(Integer userId) {
        return bookLogService.findLogsByUserId(userId);
    }
}
