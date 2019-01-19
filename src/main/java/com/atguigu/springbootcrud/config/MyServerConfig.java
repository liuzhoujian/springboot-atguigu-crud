package com.atguigu.springbootcrud.config;

import com.atguigu.springbootcrud.filter.MyFilter;
import com.atguigu.springbootcrud.listener.MyListener;
import com.atguigu.springbootcrud.servlet.MyServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;
import java.util.Arrays;

@Configuration
public class MyServerConfig {

    //定制嵌入式容器相关参数
   /* @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(8081);
        factory.setUriEncoding(Charset.forName("UTF-8"));
        return factory;
    }*/

   /* //注册自己的Servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new MyServlet());
        servletRegistrationBean.setUrlMappings(Arrays.asList("/hello", "/aaa"));
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    //注册自己的filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        myFilterFilterRegistrationBean.setFilter(new MyFilter());
        //对 "/hello", "/aaa" 进行过滤
        myFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/aaa"));
        return myFilterFilterRegistrationBean;
    }


    //注册自己的监听器
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }*/
}
