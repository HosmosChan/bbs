package com.bbs.post.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bbs.domain.PostVo;
import com.bbs.domain.User1;
import com.bbs.privateMessage.service.SelectMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.bbs.data.service.DataService;
import com.bbs.domain.Comment;
import com.bbs.domain.Module;
import com.bbs.domain.PostClass;
import com.bbs.post.service.AboutPostService;
import com.bbs.post.service.PostService;
import com.bbs.post.umeditor.Uploader;
import com.bbs.utils.GETuuid;
import com.github.pagehelper.Page;

@Controller
@RequestMapping(value = "/post")
public class PostController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private PostService postService;
    @Autowired
    private AboutPostService aboutPostService;
    @Autowired
    private DataService dataserviceImpl;
    String getname;
    @Autowired
    private Uploader uploader;
    @Autowired
    private ImageUploader imageUploader;
    @Autowired
    private SelectMessageService selectMessageService;

    @RequestMapping(value = "/fileupload")
    @ResponseBody
    public String config(HttpServletRequest request) {
        // 项目根目录
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        return rootPath;
    }

    /* sitong */
    @RequestMapping(value = "/updatePost")
    public String updatePost(Model model, HttpServletRequest request, String name) {
        // 更新信息
    	 HttpSession session = request.getSession();
        User1 user = (User1) session.getAttribute("user1");
        String moduleId = postService.getmoduleCodebyAccount(user.getAccount());// 查询该用户所管理的模块Id
        if (name == null) {
            name = getname;
            String error="该帖子分类已存在，请重新命名";
        	model.addAttribute("errorexit",error);
        }
        PostClass postclass = postService.getpostclassByname(moduleId,name);// 通过名字获得帖子类信息
        model.addAttribute("postclass", postclass);
        return "module/editorpostClass";
    }

    @RequestMapping(value = "/updatePostClass")
    public String updatePostClass(Model model,PostClass postclass, HttpServletRequest request) {
    	HttpSession session = request.getSession();
        User1 user = (User1) session.getAttribute("user1");
        String moduleId = postService.getmoduleCodebyAccount(user.getAccount());// 查询该用户所管理的模块Id
        
        PostClass postClassexit = postService.getpostclassByname(moduleId,postclass.getClassName());// 通过名字获得帖子类信息
        if (postClassexit != null) {
            if (postclass.getCode() == null) {
                //新增分类失败 该分类已存在
            	String error="该帖子分类已存在，请重新命名";
            	model.addAttribute("errornull",error);
                return "module/addnewpostClass";
            } else {
                //修改分类失败
                getname = postclass.getCode();
                return "redirect:updatePost";
            }
        } else {
            if (postclass.getCode() == null) {
                // 新增一个新的分类
                if (moduleId == null)
                    moduleId = "0";
               String msg = postService.addPostClass(moduleId,postclass.getClassName());
            }
            postService.updatePostByname(postclass.getClassName(), postclass.getCode());
            return "redirect:getPostClassNum";
        }
    }

    @RequestMapping(value = "/getPostClassNum")
    public String getPostClassNum(String name, HttpServletRequest request, Model model) {
        if (name != null) {
            try {
                dataserviceImpl.deletepostclass(name);
            } catch (Exception e) {
                logger.info(e);
                throw e;
            }
        }
        HttpSession session = request.getSession();
        User1 user = (User1) session.getAttribute("user1");
        String moduleId = postService.getmoduleCodebyAccount(user.getAccount());// 查询该用户所管理的模块Id
        if (moduleId == null) moduleId = "0";
        List<PostClass> postclasslist = postService.getModulePostclassList(moduleId);
        List<PostVo> postlist = postService.getModulePostList(moduleId);// 全部的帖子列表
        String[][] data = getPostData(postlist, postclasslist);
        /*
         * 获取版块帖子详细信息（存储在二维数组中 a【size】【2】） 第一行存储帖子code 第二行存储帖子数量
         * 重新定义postclass列表里的moduleCode代表的是历史发帖量
         */
        for (int i = 0; i < postclasslist.size(); i++) {
            PostClass postclass = postclasslist.get(i);
            postclass.setModuleCode(String.valueOf(data[i][1]));
        }
        model.addAttribute("postclasslist", postclasslist);
        return "module/postClassType";
    }

    public String[][] getPostData(List<PostVo> postlist, List<PostClass> postclasslist) {
        int postclassnum = postclasslist.size();
        int postnum = postlist.size();
        String[][] data = new String[postclassnum][2];
        if (postlist != null || postclasslist != null) {
            for (int i = 0; i < postclassnum; i++) {
                data[i][0] = postclasslist.get(i).getCode();
                data[i][1] = "0";
            }
            for (int j = 0; j < postnum; j++) {
                String code = postlist.get(j).getPostClassCode();
                for (int i = 0; i < postclassnum; i++) {
                    if (code.equals(data[i][0])) {
                        int test = Integer.valueOf(data[i][1]);
                        data[i][1] = String.valueOf(test + 1);
                    }
                }
            }
        }
        return data;
    }

    public String addLivenessbypost(PostVo postVo, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User1 user1 = (User1) session.getAttribute("user1");
        String postclassId = postVo.getPostClassCode();
        String ModuleId = postVo.getModuleCode();
        String userID = user1.getAccount();
        String time = dataserviceImpl.getnewtime();
        boolean statue = true;
        // 更新用户发帖次数 增加活跃度
        dataserviceImpl.updateUserPublishtimes(userID, time, postclassId);
        // 更新当前模块的发帖数量
        dataserviceImpl.updatePostData(time, statue, ModuleId);
        return null;
    }

    /**
     * 获取当前用户的帖子 author: wangshixu 2018/7/9 修改 wanghsixu 2018/7/23
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/savePost")
    public String savePost(PostVo postVo, HttpServletRequest request, @RequestParam("filename") MultipartFile file) {
        ModelAndView postDetail = new ModelAndView();
        //设置帖子的发帖Account
        HttpSession session = request.getSession();
        User1 user1 = (User1) session.getAttribute("user1");
        try {
            // 如果帖子带有图片，处理图片上传问题
            if (!file.isEmpty()) {
                // 获取文件名
                String fileName = GETuuid.getUUID() + file.getOriginalFilename();
                // 获取文件的后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                String icon = imageUploader.uploadImage(file);
                postVo.setIcon(icon);
            }
            postVo.setHostAccount(user1.getAccount());
            postVo.setCode(GETuuid.getUUID());
            postService.savePost(postVo);
            try {
                addLivenessbypost(postVo, request);// writebysitong
            } finally {
                return "redirect:/post/getPostByCode?code=" + postVo.getCode();
            }
        } catch (Exception e) {
            logger.info(e);
            return "redirect:post/getPostByCode?code=" + postVo.getCode();
        } finally {
        }
    }

    /**
     * umeditor的图片上传
     *
     * @author wangshixu
     * @time 2018/9/15
     */
    @ResponseBody
    @RequestMapping("/uploadUMImage")
    public String uploadUEImage(MultipartFile upfile, HttpServletRequest request) throws Exception {
        uploader.setSavePath("upload");
        String[] fileType = {".gif", ".png", ".jpg", ".jpeg", ".bmp"};
        uploader.setAllowFiles(fileType);
        uploader.setMaxSize(10000); //单位KB
        uploader.upload(upfile);
        String callback = request.getParameter("callback");
        String result = "{\"name\":\"" + uploader.getFileName() + "\", \"originalName\": \"" + uploader.getOriginalName() + "\", \"size\": " + uploader.getSize()
                + ", \"state\": \"" + uploader.getState() + "\", \"type\": \"" + uploader.getType() + "\", \"url\": \"" + uploader.getUrl() + "\"}";
        // System.out.println(up.getUrl());
        result = result.replaceAll("\\\\", "\\\\");
        if (callback == null) {
            return result;
        } else {
            return "<script>" + callback + "(" + result + ")</script>";
        }
    }
    /**
     * 根据code删除帖子！！ author: wangshixu 2018/7/24
     *
     */
    /*
     * @ResponseBody
     *
     * @RequestMapping(value = "/deletePost") public String deletePostByCode(String
     * postCode) { try { postService.deletePostByCode(postCode);
     * aboutPostService.deleteCommentByPostCode(postCode); return "success"; } catch
     * (Exception e) { e.printStackTrace(); return "error"; } }
     */

    /**
     * 获取当前用户的帖子 author: wangshixu 2018/8/9 修改：wangshixu 2018/8/13
     */
    @ResponseBody
    @RequestMapping(value = "/myPost")
    public ModelAndView MyPost(String account, HttpServletRequest request) {
        selectMessageService.getNewMessageCount(request);
        try {
            // account = "0"; // 暂且让account = 0；
            HttpSession session = request.getSession();
            User1 user1 = (User1) session.getAttribute("user1");
            account = user1.getAccount();
            Integer currentPage = 1;
            Page<Object> page = postService.getMyPost(account, currentPage);
            ModelAndView myPostPageModelAndView = new ModelAndView();
            myPostPageModelAndView.setViewName("bbs/myPost");
            myPostPageModelAndView.addObject("page", page);
            return myPostPageModelAndView;
        } catch (Exception e) {
            logger.info(e);
            throw e;
        }
    }

    /**
     * 获取当前用户的帖子 author: wangshixu 2018/8/13
     */
    @ResponseBody
    @RequestMapping(value = "/myPostforJson")
    public List<Object> MyPostforJson(String account, Integer currentPage) {
        try {
            if (currentPage == null)
                currentPage = 1;
            Page<Object> page = postService.getMyPost(account, currentPage);
            return page.getResult();
        } catch (Exception e) {
            logger.info(e);
            throw e;
        }
    }

    /**
     * 根据帖子编码获取帖子(用于帖子详情页)
     *
     * @author chenhuayang
     * @version 2018/7/20
     * @modify 王世旭
     * @version 2018/7/23 17:35
     */
    @RequestMapping(value = "/getPostByCode")
    public ModelAndView getPostByCode(String code, HttpServletRequest request) {
        selectMessageService.getNewMessageCount(request);
        try {
            ModelAndView postDetail = new ModelAndView();
            PostVo postVo = new PostVo();
            postVo.setCode(code);
            postVo = postService.getPostbyCode(postVo);
            /**
             * 添加阅读量统计
             *
             * @author chenhuayang
             * @version 2018/8/9 16:19
             */
            Integer reading = postVo.getReadingAmount();
            reading += 1;
            postService.addReadingAmount(code, reading);
            Integer currentPage = 1;
            Integer pageSize = 8;
            Page<Object> page = aboutPostService.getOnePostComments(code, currentPage, pageSize);
            postDetail.addObject("page", page);
            postDetail.addObject("post", postVo);
            postDetail.setViewName("bbs/post");
            return postDetail;
        } catch (Exception e) {
            logger.info(e);
            throw e;
        }
    }

    /**
     * 通过code进入帖子
     */
    @RequestMapping(value = "/code")
    public String IntoPost(String code) {
        return "data/login";
    }

    /*
     * 对当前的帖子进行评论。 author:wangshixu 2018/7/17
     */
    @ResponseBody
    @RequestMapping(value = "/commentPublish")
    public String commentPublish(String postCode, String content, HttpServletRequest request) {
        try {
            Comment comment = new Comment();
            HttpSession session = request.getSession();
            User1 user1 = (User1) session.getAttribute("user1");
            comment.setUserAccount(user1.getAccount());
            comment.setContent(content);
            comment.setPostCode(postCode);
            PostVo postVo = postService.getPostByCode(postCode);
            postVo.setReplyAmount(postVo.getReplyAmount() + 1);
            Integer tid = aboutPostService.saveComment(comment);
            postService.updatePost(postVo);
            return "" + postVo.getReplyAmount();
        } catch (Exception e) {
            logger.info(e);
            return "error";
        }
    }

    /**
     * 搜索帖子
     *
     * @author chenhuayang
     * @version 2018/7/19
     * @version 2018/9/1
     */
    @RequestMapping(value = "/searchingPostInfo")
    public ModelAndView searchingPostInfo(String searchingDetails, Integer searchingType, Integer currentPage, HttpServletRequest request) {
        selectMessageService.getNewMessageCount(request);
        try {
            if (currentPage == null) {
                currentPage = 1;
            }
            Integer pageSize = 10;
            Page<Object> page = postService.searchingPostInfo(searchingDetails, searchingType, currentPage, pageSize);
            ModelAndView searchingPost = new ModelAndView();
            searchingPost.setViewName("post/searchingPost");
            searchingPost.addObject("page", page);
            searchingPost.addObject("searchingDetails", searchingDetails);
            searchingPost.addObject("searchingType", searchingType);
            return searchingPost;
        } catch (Exception e) {
            logger.info(e);
            throw e;
        }
    }

    /**
     * 帖子搜索数据返回前台
     *
     * @author chenhuayang
     * @version 2018/7/19
     */
    @RequestMapping(value = "/searchingPost")
    public String searchingPost() {
        return "post/searchingPost";
    }

    /**
     * 进入论坛首页 author: wangshixu 2018/8/9
     */
    @RequestMapping(value = "/index")
    public ModelAndView indexPage(HttpServletRequest request) {
        selectMessageService.getNewMessageCount(request);
        ModelAndView indexPageModelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        Integer currentPage = 1;
        Integer pageSize = 10;
        Page<Object> page = postService.getAllPostPage(currentPage, pageSize);
        indexPageModelAndView.addObject("page", page);
        // 获取板块信息
        List<Module> moduleList = aboutPostService.getAllModule();
        moduleList.remove(0);// 去掉第一个超级版块的模块 第一个Sitong专用 不用来具体版块
        session.setAttribute("moduleList", moduleList);
        //获取bbs的所有帖子类别用户发帖的时候的下拉菜单
        /*List<PostClass> allPostClassList = aboutPostService.getAllPostClass();
        session.setAttribute("allPostClassList", allPostClassList);*/
        List<PostVo> PostOrderByList = postService.selectPostOrderBy6();
        session.setAttribute("PostOrderByList", PostOrderByList);
        PostVo PostOrderByReadingAmount1 = postService.PostOrderByReadingAmount1();//根据阅读量获取阅读量前5的帖子
        session.setAttribute("PostOrderByReadingAmount1", PostOrderByReadingAmount1);//根据阅读量获取阅读量前5的帖子
        PostVo PostOrderByReadingAmount2 = postService.PostOrderByReadingAmount2();//根据阅读量获取阅读量前5的帖子
        session.setAttribute("PostOrderByReadingAmount2", PostOrderByReadingAmount2);//根据阅读量获取阅读量前5的帖子
        PostVo PostOrderByReadingAmount3 = postService.PostOrderByReadingAmount3();//根据阅读量获取阅读量前5的帖子
        session.setAttribute("PostOrderByReadingAmount3", PostOrderByReadingAmount3);//根据阅读量获取阅读量前5的帖子
        PostVo PostOrderByReadingAmount4 = postService.PostOrderByReadingAmount4();//根据阅读量获取阅读量前5的帖子
        session.setAttribute("PostOrderByReadingAmount4", PostOrderByReadingAmount4);//根据阅读量获取阅读量前5的帖子
        PostVo PostOrderByReadingAmount5 = postService.PostOrderByReadingAmount5();//根据阅读量获取阅读量前5的帖子
        session.setAttribute("PostOrderByReadingAmount5", PostOrderByReadingAmount5);//根据阅读量获取阅读量前5的帖子
        indexPageModelAndView.addObject("moduleList", moduleList);
        indexPageModelAndView.setViewName("bbs/index");
        return indexPageModelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/moudelPost")
    public String moudelPost(HttpServletRequest request, String code) {
//		ModelAndView moudelPost = new ModelAndView();
//		HttpSession session = request.getSession();
        List<PostClass> postClassList = aboutPostService.selectALlClass(code);
		/*Integer currentPage = 1;
		Integer pageSize = 10;*/
        if (!postClassList.isEmpty()) {
			/*session.setAttribute("postClass", postClassList);
			Page<Object> page = aboutPostService.selectAllPostClassByCode(postClassList.get(0).getCode(), currentPage, pageSize);
			moudelPost.addObject("page", page);
			moudelPost.addObject("code", code);
			moudelPost.addObject("currentClassCode", postClassList.get(0).getCode());
			moudelPost.setViewName("bbs/moudelPost");*/
            return "1";
        } else {
            return "2";
        }
    }

    @RequestMapping(value = "/PostRediect")
    public ModelAndView moudelPost2(HttpServletRequest request, String code) {
        selectMessageService.getNewMessageCount(request);
        ModelAndView moudelPost = new ModelAndView();
        HttpSession session = request.getSession();
        List<PostClass> postClassList = aboutPostService.selectALlClass(code);
        Integer currentPage = 1;
        Integer pageSize = 10;
        // 获取板块信息
        List<Module> moduleList = aboutPostService.getAllModule();
        moduleList.remove(0);// 去掉第一个超级版块的模块 第一个Sitong专用 不用来具体版块
        session.setAttribute("moduleList", moduleList);
        //获取bbs的所有帖子类别用户发帖的时候的下拉菜单
        /*List<PostClass> allPostClassList = aboutPostService.getAllPostClass();
        session.setAttribute("allPostClassList", allPostClassList);*/
        session.setAttribute("postClass", postClassList);
        Page<Object> page = aboutPostService.selectAllPostClassByCode(postClassList.get(0).getCode(), currentPage, pageSize);
        moudelPost.addObject("page", page);
        moudelPost.addObject("code", code);
        moudelPost.addObject("currentClassCode", postClassList.get(0).getCode());
        moudelPost.setViewName("bbs/moudelPost");
        return moudelPost;
    }

    @RequestMapping(value = "/listPostByClassCode")
    public ModelAndView listPostByClassCode(HttpServletRequest request, String code, String classCode) {
        selectMessageService.getNewMessageCount(request);
        ModelAndView moudelPost = new ModelAndView();
        Integer currentPage = 1;
        Integer pageSize = 10;
        Page<Object> page = aboutPostService.selectAllPostClassByCode(classCode, currentPage, pageSize);
        moudelPost.setViewName("bbs/moudelPost");
        moudelPost.addObject("page", page);
        moudelPost.addObject("code", code);
        moudelPost.addObject("currentClassCode", classCode);
        return moudelPost;
    }
}