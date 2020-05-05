package com.wang.example.department.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/dashboard").setViewName("dashboard");
        registry.addViewController("/dashboard.html").setViewName("dashboard");
        registry.addViewController("/main").setViewName("dashboard");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/list").setViewName("list");
        registry.addViewController("/list.html").setViewName("list");
        registry.addViewController("/add").setViewName("add");
        registry.addViewController("/add.html").setViewName("add");
        registry.addViewController("/update.html").setViewName("update");
        registry.addViewController("/update").setViewName("update");
    }


//    //添加登陆拦截器
//    @Autowired
//    LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/index","/index.html","/user/login","/css/**","/js/**","/img/**");
    }

    //
    @Bean
    public LocaleResolver localeResolver()
    {
        return new MyLocaleResovler();
    }


}
