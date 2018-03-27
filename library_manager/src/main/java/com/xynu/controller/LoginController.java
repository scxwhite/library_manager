package com.xynu.controller;

import com.xynu.model.User;
import com.xynu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "check", method = RequestMethod.POST)
    @ResponseBody
    public boolean check(User user, HttpServletResponse response) {
        boolean login = userService.login(user);
        //如果登录成功
        if (login) {
            Cookie usernameCookie = new Cookie("username", user.getUsername());
            Cookie infoCookie = new Cookie("info", String.valueOf(user.getInfo()));
            usernameCookie.setMaxAge(3 * 60 * 60);
            infoCookie.setMaxAge(3 * 60 * 60);
            usernameCookie.setPath("/");
            infoCookie.setPath("/");
            response.addCookie(infoCookie);
            response.addCookie(usernameCookie);
            return true;
        } else {
            return false;
        }
    }
}
