package com.felix.springbootdemo.config.web;

import com.felix.springbootdemo.interceptors.LimitRequestsInterceptor;
import com.felix.springbootdemo.interceptors.LoginInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource(name = "loginInterceptor")
    private LoginInterceptor loginInterceptor;

    @Resource(name = "limitRequestsInterceptor")
    private LimitRequestsInterceptor limitRequestsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(limitRequestsInterceptor);
        /*registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login/**", "/user/info", "/test/**");*/
    }
}
