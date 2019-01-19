package com.atguigu.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {
        //简化登录流程
        if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
            //登录成功，避免表单重复提交，使用重定向到主页

            //将用户存入到session中
            session.setAttribute("loginUser", username);

            return "redirect:/main.html";
        }

        //登录失败，返回登录页面
        model.addAttribute("msg", "用户名或密码错误！");
        return "login";
    }
}


/*将index1.html放在
        templates下，直接访问不到。 http://localhost:8080/index1.html
        static下，可以直接访问到
        public下，可以直接访问到
        resources下，可以直接访问到
        在src/main/resources下，直接访问不到*/


