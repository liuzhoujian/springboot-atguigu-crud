package com.atguigu.springbootcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@ServletComponentScan //开启servlet扫描
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}

