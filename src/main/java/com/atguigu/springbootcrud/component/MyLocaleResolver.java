package com.atguigu.springbootcrud.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求参数
        String parameter = httpServletRequest.getParameter("l");
        //获取默认的locale
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(parameter)) {
            String[] strings = parameter.split("_");
            //若请求参数不为空，则根据请求构造一个新的locale
            locale = new Locale(strings[0], strings[1]);
        }

        //否则返回默认的locale
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
