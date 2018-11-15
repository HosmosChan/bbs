package com.bbs.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bbs.domain.User;
import com.bbs.domain.UserVo;
import com.bbs.user.service.UserService;

/**
 * Hello world!
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/getUser")
    public String getUser(UserVo userVo) {
        User user = userServiceImpl.getUser(userVo);
        if (user == null) {
            return "";
        }
        return user.getAccount();
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/addUserUI")
    public String addUserUI(User user) {
        return "user/userDetail";
    }

    /***
     * 查询所有用户
     */
    @RequestMapping(value = "/listUser")
    public String listUser(UserVo userVo, Model model) {
        List<User> listUser = userServiceImpl.listUser(userVo);
        model.addAttribute("listUser", listUser);
        return "user/listUser";
    }

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveUser")
    public String saveUser(User user) {
        try {
            Integer tid = userServiceImpl.saveUser(user);
            return "" + tid;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}