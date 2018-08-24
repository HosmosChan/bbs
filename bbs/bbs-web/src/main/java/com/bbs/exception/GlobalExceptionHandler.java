package com.bbs.exception;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    public static final String DEFAULT_ERROR_VIEW = "error";
    
    @ExceptionHandler(value = Exception.class)
    public ModelAndView businessExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", e.getMessage());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
    
    
}