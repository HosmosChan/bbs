package com.bbs.user.controller;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.data.service.DataService;
import com.bbs.domain.User1;
import com.bbs.domain.UserVo1;
import com.bbs.user.service.User1Service;

@Controller
@RequestMapping(value = "user1")
public class User1Controller {

	@Autowired
	private User1Service user1serviceImp;
	@Autowired
	private DataService dataserviceImpl;
	// 访问登录页面
//	@RequestMapping(value = "/login2")
//	public String login1() {
//
//		return "user/login2";
//	}

	// 登录提交
	@ResponseBody
	@SuppressWarnings("finally")
	@RequestMapping(value = "/login1Submit")
	public String login1Submit(String account, String password, HttpSession session) throws Exception {

		UserVo1 userVo1 =  user1serviceImp.anthentionUser(account, password);
		session.setAttribute("user1", userVo1.getUser1());
		//默认登录超级版块 更新用户登录活跃度
        String loginModuleId="0";
		String time=dataserviceImpl.getnewtime();
		try {
			dataserviceImpl.updateUserLogintimes(account, time,loginModuleId);
		} finally {
			return userVo1.getMessage();
		}
		
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
	public String registSubmit(User1 user1, String password2) throws Exception {
		String str=user1serviceImp.addUser(user1, password2);
		return str;
		
	}

//	// 显示所有的用户
//	@RequestMapping(value = "/admin")
//	public String selectAllUser(Model model, HttpServletRequest request) throws Exception {
//		
//		List<User1> list = user1serviceImp.selectAllUser1();
//		model.addAttribute("list", list);
//		return "user/adminList";
//	}

//	// 显示单条修改数据页面
//	@RequestMapping(value = "/editUser")
//	public String editorUser(Model model, Integer id) throws Exception {
//
//		User1 user1 = user1serviceImp.findUser1ById(id);
//
//		System.out.println(user1);
//
//		model.addAttribute("user1", user1);
//		System.out.println(user1);
//
//		return "user/editorUser";
//	}
//
//	// 单条数据修改提交
//	@RequestMapping(value = "/editUserSubmit")
//	public String editUserSubmit(User1 user1) throws Exception {
//		user1serviceImp.updateuser1ById(user1);
//		return "redirect:admin";
//	}
//
//	// 单条用户删除页面
//	@RequestMapping(value = "/deleteUser")
//	public String deleteUser(Integer id) throws Exception {
//		user1serviceImp.deleteUser1ById(id);
//		System.out.println(id);
//		return "redirect:admin";
//	}
	
	//用户注销
	@RequestMapping(value = "/logOut")
	public String logOut(HttpSession session) {
		
		session.invalidate();
		return "redirect:/post/index";
	}
	
	// Jquery
		@RequestMapping(value = "/jquery")
		public String jquery() {

			return "user/JqueryTest";
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
