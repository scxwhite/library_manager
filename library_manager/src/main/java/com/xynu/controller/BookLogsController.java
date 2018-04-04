package com.xynu.controller;

import com.xynu.model.BookLogsVO;
import com.xynu.service.BookLogsService;
import com.xynu.util.RequestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
        return bookLogsService.findBorrowLogsByUserId(userId);
    }


    @RequestMapping("notReturn")
    @ResponseBody
    public List<BookLogsVO> getNotReturnBooks(HttpServletRequest request) {
        String userId = RequestUtils.getCookie("id", request);
        if (StringUtils.isBlank(userId)) {
            return null;
        }
        return bookLogsService.getNotReturnBooks(Integer.parseInt(userId));
    }
}
