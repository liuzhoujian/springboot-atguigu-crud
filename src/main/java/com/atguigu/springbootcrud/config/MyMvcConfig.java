package com.atguigu.springbootcrud.config;

import com.atguigu.springbootcrud.component.LoginHandlerInterceptor;
import com.atguigu.springbootcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
  /*  @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }*/

    //扩展springMVC功能，根据请求路径，映射到对应的视图
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/", "/index.html", "/user/login", "/webjars/**", "/asserts/**",  "/js/**", "/css/**");
                //排除的访问路径： 访问登录页面的路径 /  /index.html， 登录的动作： /user/login
                //静态资源 :  "/static/**", "/js/**", "/css/**", "/webjars/**"

            }
        };

        return webMvcConfigurer;
    }


    //将自定义组件注入springboot中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
