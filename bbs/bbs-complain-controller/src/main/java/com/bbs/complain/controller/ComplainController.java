package com.bbs.complain.controller;

import com.bbs.complain.service.ComplainService;
import com.bbs.domain.ComplainVo;
import com.bbs.domain.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户投诉发表控制层
 *
 * @author chenhuayang
 * @version 2018/7/19
 */
@Controller
@RequestMapping(value = "/complain")
public class ComplainController {
    @Autowired
    private ComplainService complainService;

    /**
     * 保存举报信息
     *
     * @author chenhuayang
     * @version 2018/8/9
     */
    @ResponseBody
    @RequestMapping(value="/saveComplain")
    public String saveComplain(ComplainVo complainVo){
        try{
            Integer tid=complainService.saveComplain(complainVo);
            return ""+tid;
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    /**
     * 获取帖子信息，传送到前端
     *
     * @author chenhuayang
     * @version 2018/7/26
     */
    @RequestMapping(value = "/addComplain")
    public ModelAndView addComplain(String code) {
        ModelAndView complainPublication  = new ModelAndView();
        PostVo postInfo = complainService.postInfo(code);
        complainPublication.setViewName("complain/complainPublication");
        complainPublication.addObject("postInfo", postInfo);
        return complainPublication;
    }
}