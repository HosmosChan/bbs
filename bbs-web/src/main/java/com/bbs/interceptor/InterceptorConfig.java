package com.bbs.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Bean
    public HandlerInterceptor getMyInterceptor() {
        return new LoginInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePathPatternsList = new ArrayList<String>();
        excludePathPatternsList.add("/img/read");
        excludePathPatternsList.add("/role/login");
        excludePathPatternsList.add("/user1/demo");
        excludePathPatternsList.add("/user1/UserRegister");
        excludePathPatternsList.add("/user1//success");
        excludePathPatternsList.add("/user1/registSubmit");
        excludePathPatternsList.add("/post/index");
        excludePathPatternsList.add("/post/getPostByCode");
        excludePathPatternsList.add("/post/moudelPost");
        excludePathPatternsList.add("/user1/login1Submit");
        excludePathPatternsList.add("/post/moudelPost");
        excludePathPatternsList.add("/post/PostRediect");
        excludePathPatternsList.add("/post/listPostByClassCode");
        excludePathPatternsList.add("/index/PostByClassCodeForJson");
        excludePathPatternsList.add("/user1/logOut");
        excludePathPatternsList.add("/post/getPostByCode/");
        excludePathPatternsList.add("/index/postForJson");
        excludePathPatternsList.add("/about/praise");
        //把不要登录就可以操作的URL地址加上
        excludePathPatternsList.add("/post/img/**");
        excludePathPatternsList.add("/bbs/**");
        excludePathPatternsList.add("/css/**");
        excludePathPatternsList.add("/fonts/**");
        excludePathPatternsList.add("/images/**");
        excludePathPatternsList.add("/js/**");
        excludePathPatternsList.add("/myplugs/**");
        excludePathPatternsList.add("/upload/**");
        excludePathPatternsList.add("/post/searchingPostInfo");
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePathPatternsList);
    }
}
