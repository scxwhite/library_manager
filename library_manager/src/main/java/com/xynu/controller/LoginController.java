package com.xynu.controller;

import com.xynu.model.User;
import com.xynu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("check")
    @ResponseBody
    public boolean check(User user, HttpServletResponse response) throws IOException {
        boolean login = userService.login(user);
        //如果登录成功
        if (login) {
            Cookie cookie = new Cookie("username", user.getUsername());
            cookie.setMaxAge(3 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect("/index/");
            return true;
        } else {
            return false;
        }
    }
}
