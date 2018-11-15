package com.bbs.section.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:tanglei
 * @Create time:2018年7月23日
 * @ClassName:
 * @Description:
 */
@Controller
@RequestMapping(value = "section")
public class sectionController {
    //section文件夹中界面的入口
    @RequestMapping(value = "/{page}")
    public String top(@PathVariable String page) throws Exception {
        return "Moderator/" + page;
    }
}