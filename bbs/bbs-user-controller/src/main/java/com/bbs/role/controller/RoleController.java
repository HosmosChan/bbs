package com.bbs.role.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.domain.Role;
import com.bbs.domain.User1;
import com.bbs.role.service.RoleService;
import com.bbs.user.service.User1Service;

/**
* @author:tanglei
* @Create time:2018年7月17日
* @ClassName:
* @Description:
*/

@Controller
@RequestMapping(value = "role")
public class RoleController {
	
	@Autowired
	private RoleService roleServiceImp;
	
	@Autowired
	private User1Service user1serviceImp;
	
//		@RequestMapping(value = "/roleIndex")
//		public String roleIndex(Model model, HttpServletRequest request) throws Exception {
//			
//			List<Role> roleList = roleServiceImp.selectRole();
//			model.addAttribute("roleList", roleList);
//			
//			return "user/role";
//			
//		}
		// 显示所有的用户
		@RequestMapping(value = "/main_list")
		public String selectAllUser(Model model, HttpServletRequest request) throws Exception {
			
			List<User1>  rolelist = user1serviceImp.selectAllUser1();
			model.addAttribute("rolelist", rolelist);
			
			return "role/main_list";
		}
		
		// 单条用户删除页面
		@RequestMapping(value = "/delete")
		public String deleteUser(Integer id) throws Exception {
			user1serviceImp.deleteUser1ById(id);
			return "redirect:main_list";
		}
		
		// 显示单条修改数据页面
		@RequestMapping(value = "/editor")
		public String editorUser(Model model, Integer id) throws Exception {

			User1 editUser = user1serviceImp.findUser1ById(id);

			model.addAttribute("editUser", editUser);

			return "role/editor";
		}
		
		// 单条数据修改提交
		@RequestMapping(value = "/editorSubmit")
		public String editUserSubmit(User1 user1) throws Exception {
			user1serviceImp.updateuser1ById(user1);
			return "redirect:main_list";
		}
		
		//role添加
		@RequestMapping(value = "/roleUseSubmit")
		public String roleUseSubmit(User1 roleUser, String password2, HttpSession session) throws Exception {
			roleServiceImp.addRoleUser(roleUser, password2);
			return "role/main_list";
		}
		

		//role文件夹中界面的入口
		@RequestMapping(value = "/{page}")
		public String top(@PathVariable String page) throws Exception {
			return "role/"+page;
		}
		//后台主页框架
		@RequestMapping(value = "/roleindex")
		public String roleindex() throws Exception{
			return "role/index";
			
		}
		
		//后台系统的登录页面
		@RequestMapping(value = "/login")
		public String login() throws Exception{
			return "role/login";	
		}
		
		//后台登录页面的身份验证
		@RequestMapping(value = "/loginAttest")
		public String loginAttes(HttpServletRequest  request,String account, String password, HttpSession session) throws Exception{
			User1 userRole1 = roleServiceImp.roleAnthentionUser(account, password);			
			session.setAttribute("userRole1", userRole1);
			
			return "role/index";	
		}
		//用户注销
		@RequestMapping(value = "/logOut")
		public String logOut(HttpSession session) {
			
//			session.invalidate();
			
			return "user/demo";
		}
		//后台用户的模糊查询
		
		@RequestMapping(value = "/FuzzyQueryUserSumit")
		public String FuzzyQueryUser(User1 user1,Model model) throws Exception{
			List<User1> rolelist = user1serviceImp.FuzzyQueryUser(user1);
			model.addAttribute("rolelist", rolelist);
			return "role/main_list";	
		}
		
//		//bbs文件夹中界面的入口
//				@RequestMapping(value = "/{page}")
//				public String jiemian(@PathVariable String page) throws Exception {
//					return "bbs/"+page;
//				}
//				
//				// 显示所有的用户
//				@RequestMapping(value = "/main_list2")
//				public String selectAllUser2(Model model, HttpServletRequest request) throws Exception {
//					
//					List<User1>  rolelist = user1serviceImp.selectAllUser1();
//					model.addAttribute("rolelist", rolelist);
//					
//					return "bbs/mangerUser";
//				}
			  
				
				@RequestMapping(value = "mangerUser")
				public ModelAndView mangerUser(String account,HttpServletRequest request) throws Exception {
					HttpSession session = request.getSession();
		            User1 user1 = (User1) session.getAttribute("user1");
		            account = user1.getAccount();
		            User1 editUser = user1serviceImp.findUser1ByAccount(account);
					 ModelAndView myPostPageModelAndView = new ModelAndView();
					 myPostPageModelAndView.addObject("editUser",editUser);
			            myPostPageModelAndView.setViewName("bbs/userBase");
			            return myPostPageModelAndView;
					
				}
				
				// 单条数据修改提交
				@ResponseBody
				@RequestMapping(value = "/mangerUserSubmit")
				public String mangerUserSubmit(User1 user1) throws Exception {
					user1serviceImp.updateuser1ByAccount(user1);
					return "修改成功";
					//return "redirect:/role/mangerUser";
				}
				
				

}
