package com.xynu.controller;

import com.xynu.entity.User;
import com.xynu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author Administrator
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获得所有学生信息
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<User> getUserList() {
        return userService.findAllUser();
    }


    @RequestMapping("/addUser")
    @ResponseBody
    public boolean addUser(User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public boolean updateUser(User user) {
        return userService.updateUser(user);
    }

    @RequestMapping("/delUser")
    @ResponseBody
    public boolean delUser(Integer id) {
        return userService.delUser(id);
    }
}
