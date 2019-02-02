package com.bbs.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbs.domain.Point;
import com.bbs.point.service.UserPointService;
import com.bbs.utils.MD5Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bbs.data.service.DataService;
import com.bbs.domain.User1;
import com.bbs.domain.UserVo1;
import com.bbs.user.service.User1Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "user1")
public class User1Controller {
    @Autowired
    private User1Service user1serviceImp;
    @Autowired
    private DataService dataserviceImpl;
    @Autowired
    private UserPointService userPointService;

    // 访问登录页面
    // @RequestMapping(value = "/login2")
    // public String login1() {
    //
    // return "user/login2";
    // }
    // 登录提交
    @ResponseBody
    @SuppressWarnings("finally")
    @RequestMapping(value = "/login1Submit")
    public String login1Submit(String account, String password, HttpSession session, HttpServletRequest request)
            throws Exception {
        password = MD5Utils.MD5Encode(password, "UTF-8");
        UserVo1 userVo1 = user1serviceImp.anthentionUser(account, password);
        if (userVo1.getUser1() != null) {
            session.setAttribute("user1", userVo1.getUser1());
            // 默认登录超级版块 更新用户登录活跃度
            String loginModuleId = "0";
            String time = dataserviceImpl.getnewtime();
            dataserviceImpl.updateUserLogintimes(account, time, loginModuleId);
            //获取当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Point pointRecord = new Point();
            pointRecord.setAccount(account);
            pointRecord.setReason("登录积分奖励");
            pointRecord.setCreateTime(sdf.parse(time));
            List<Point> pointChange = userPointService.getPointRecord(pointRecord);
            if (pointChange.size() == 0) {
                pointRecord.setPointChange(5);
                pointRecord.setStatus(Point.statusEnum.increase.getCode());
                userPointService.updatePoint(pointRecord);
            }
        } else {
            userVo1.setMessage("3");
        }
        return userVo1.getMessage();
    }

    // 访问主界面页面
    @RequestMapping(value = "/homePage")
    public String homePage() {
        return "user/homePage";
    }

    // 注册界面
    @RequestMapping(value = "/success")
    public String success() {
        return "user/success";
    }

    // 注册成功界面
    @RequestMapping(value = "/regist")
    public String regist() {
        return "user/regist";
    }

    // 注册提交
    @ResponseBody
    @RequestMapping(value = "/registSubmit")
    public String registSubmit(User1 user1, String password2, HttpServletResponse response) throws Exception {
        password2 = MD5Utils.MD5Encode(password2, "UTF-8");
        user1.setPassword(MD5Utils.MD5Encode(user1.getPassword(), "UTF-8"));
        String str = user1serviceImp.addUser(user1, password2);
        Cookie account = new Cookie("account", user1.getAccount());
        response.addCookie(account);
        Cookie password = new Cookie("password", user1.getAccount());
        response.addCookie(password);
        return str;
    }

    // 用户注销
    @RequestMapping(value = "/logOut")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/post/index";
    }

    // 后台
    @RequestMapping(value = "/index")
    public String index() {
        return "user/index";
    }

    // demo登录
    @RequestMapping(value = "/demo")
    public String demo() throws Exception {
        return "user/demo";
    }

    // UserRegister注册
    @RequestMapping(value = "/UserRegister")
    public String UserRegist() throws Exception {
        return "user/UserRegister";
    }

    // UserRegister
    @RequestMapping(value = "/tiaozhuang")
    public String tiaozhuang() throws Exception {
        return "user/tiaozhuang";
    }
}