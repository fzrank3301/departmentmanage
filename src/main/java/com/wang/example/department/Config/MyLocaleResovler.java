package com.wang.example.department.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;



public class MyLocaleResovler implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("l");

        Locale aDefault = Locale.getDefault(); //拿到默认的

        //如果请求连接携带了国际化的参数，
        if (!StringUtils.isEmpty(language))
        {
            String[] s = language.split("_");
            //zh_CN
           aDefault = new Locale(s[0], s[1]);
            //国家，地区
        }

        return aDefault;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
