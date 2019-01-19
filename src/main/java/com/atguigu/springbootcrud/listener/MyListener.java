package com.atguigu.springbootcrud.listener;

import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("项目启动...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("项目停止...");
    }
}
