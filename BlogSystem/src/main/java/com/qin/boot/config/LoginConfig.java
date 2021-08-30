package com.qin.boot.config;

import com.qin.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类，配置拦截器路径
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoginInterceptor())
               .addPathPatterns("/**").excludePathPatterns("/","/login","/register","/favicon.ico");
    }
}
