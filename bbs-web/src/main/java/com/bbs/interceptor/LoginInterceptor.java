package com.bbs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        int status = response.getStatus();
        Object obj = session.getAttribute("user1");
        String uri = request.getRequestURI();
        if (obj == null) {
            if ("/".equals(uri)) {
                response.sendRedirect("/post/index");
                return false;
            }
            response.sendRedirect("/user1/demo");
            return false;
        }
        if (status == 404) {
            response.sendRedirect("/post/index");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}