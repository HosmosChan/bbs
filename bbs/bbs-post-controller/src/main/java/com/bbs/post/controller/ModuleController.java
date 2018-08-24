package com.bbs.post.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.data.service.DataService;
import com.bbs.domain.Data;
import com.bbs.domain.Module;
import com.bbs.domain.PostClass;
import com.bbs.domain.PostVo;
import com.bbs.domain.User1;
import com.bbs.exception.BusinessRunException;
import com.bbs.post.service.AboutPostService;
import com.bbs.post.service.PostService;
import com.bbs.role.service.RoleService;
import com.github.pagehelper.Page;
/*
 * 管理板块的控制
 * autor：wangshixu  2018/7/18
*/
@Controller
@RequestMapping(value="/module")
public class ModuleController {
	@Autowired
	private DataService dataserviceImpl;
	@Autowired
    private PostService postService;
	@Autowired
	private AboutPostService aboutPostService;
	@Autowired
	private RoleService  roleServiceImp;
	
	/*sitong
	 * */
	@RequestMapping(value="/ModuleData")
	public String ModuleMessage(String account,Model model,String year,String month,HttpServletRequest request) {
		  HttpSession session = request.getSession();
          User1 user= (User1) session.getAttribute("user1");
		 try {
				Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
				year=String.valueOf(c.get(Calendar.YEAR));
				month=String.valueOf(c.get(Calendar.MONTH)+1);
			    if(month.length()<2)
	    			month="0"+month;
			    String moduleId=postService.getmoduleCodebyAccount(user.getAccount());//查询该用户所管理的模块Id
			    if(moduleId==null)
			    	moduleId="0";	    
		        List<Data> listdata=dataserviceImpl.listData(year,month,moduleId);
				model.addAttribute("listdata",listdata);
				String[] listWeek=dataserviceImpl.getlistWeek(listdata);
				model.addAttribute("listWeek",listWeek);

				return "data/DataShow";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	}
	 @RequestMapping(value="/addnewPostClass")
		public String addnewPostClass(Model model) {	
		    PostClass postclass=null;
	 		model.addAttribute("postclass",postclass);
		   return "module/addnewpostClass";
		}
	
	/*sitong
	 * */
	 @RequestMapping(value="/addPostClass")
		public String addPostClass(String moduleCode,Model model) {	
		    //PostClass postclass=null;
	 		model.addAttribute("postclass",moduleCode);
		   
		   return "module/addPostClass";
		}
	@RequestMapping(value = "/{page}")
	public String top(@PathVariable String page) throws Exception {
		return "module/"+page;
	}
	@RequestMapping(value = "moduleAdd")
	public String moduleAdd(Module module,Model model) throws Exception {
		List<User1> listUser=roleServiceImp.listUserByRole();
		model.addAttribute("listUser", listUser);
		return "module/moduleAdd";
	}
	@RequestMapping(value="selectAllModule")
	public String selectAllModule(Model model, HttpServletRequest request) {
		
		List<Module> listModule = aboutPostService.selectAllModule();
		model.addAttribute("listModule", listModule);
		return "module/moduleType";
	}
	
	
	@RequestMapping(value="updateModule")
	public String updateModule(Module module) throws Exception {
		aboutPostService.updateModel(module);
		return "redirect:selectAllModule";
	}
	
	@RequestMapping(value="insertModule")
	@ResponseBody
	public String insertModule(Module module,HttpSession httpSession) throws Exception {
		User1 user1=(User1) httpSession.getAttribute("user1");
		String admin = user1.getUserName();
		module.setCreateBy(admin);
		aboutPostService.insertModule(module);
		return "";
		
		
		}
	
	@RequestMapping(value="selectByIdModule")
	public String selectByIdModule(Model model, HttpServletRequest request,String code) {
		
	    Module Module = aboutPostService.selectByIdModule(code);
		model.addAttribute("Module", Module);
		return "module/editormodule";
	}
	
	@RequestMapping(value="selectAllClass")
	
	public String selectAllClass(Model model,HttpServletRequest request,String code) {
		
		List<PostClass> postClass = aboutPostService.selectALlClass(code);
		model.addAttribute("postClass", postClass);
		model.addAttribute("moduleCode",code);
		
		return "module/postClass";
	}
	
	 @RequestMapping(value="editorClass")
		
		public String editorClass(Model model,HttpServletRequest request,String code) {
			
		   PostClass post = aboutPostService.selectByIdPostClass(code);
			if(post==null) {
				post=new PostClass();
			}
			model.addAttribute("post", post);
			
			return "module/editorClass";
		}
		
	   @RequestMapping(value="editorClassSubmit")
	 	public String editorClassSubmit(HttpServletRequest request,PostClass post,String code) {	
	 	    aboutPostService.updatePostClass(post);
	 	   PostClass postClass = aboutPostService.selectByIdPostClass(code);
	 	  
	 	   return "redirect:selectAllClass?code="+postClass.getModuleCode();
	   }
  
   @RequestMapping(value="insertPostClasss")
   public String insertPostClasss(HttpServletRequest request,PostClass postClass) throws BusinessRunException {
	   postClass.setCreateBy("admin");
	   aboutPostService.insertPostClasss(postClass);
	   return "redirect:selectAllClass?code="+postClass.getModuleCode();
	   
   }
   
   @RequestMapping(value="selectPostClassByCode")
   public String selectPostClassByCode(HttpServletRequest request,String classCode,Model model) {
	   List<PostVo> PostVoList = aboutPostService.selectPostClassByCode(classCode);	 
	   model.addAttribute("PostVoList", PostVoList);
	   return "module/PostClassInfo";
   }
   @RequestMapping(value="deletePostClassByCode")
   public String deletePostClassByCode(HttpServletRequest request,String code) {
	   aboutPostService.deletePostClassByCode(code);
	   return "null";
   }
   
}
