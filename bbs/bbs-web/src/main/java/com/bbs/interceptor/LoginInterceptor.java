package com.bbs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.user.service.User1Service;


public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private User1Service user1serviceImp;
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		 //System.out.println("uri="+request.getRequestURI());
	        //登录不做拦截
	        if(request.getRequestURI().equals("/user1/demo") || request.getRequestURI().equals("user1/UserRegister"))
	        {
	            return true;
	        }
	        //验证session是否存在
	        Object obj = session.getAttribute("user1");
	        if(obj == null)
	        {
	            response.sendRedirect("/user1/demo");
	            return false;
	        }
	        return true;
	    }
	


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {  
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }


}
