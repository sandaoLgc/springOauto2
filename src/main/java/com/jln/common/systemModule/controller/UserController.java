package com.jln.common.systemModule.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2019-12-22
 */
@Controller
@RequestMapping("/user")
public class UserController {
    //测试首页
    @GetMapping("/getTest")
    public String getTest(){
        return "/test";
    }

    //添加用户页面
    @GetMapping("/getAddUser")
    public String getAddUser(){
        return "/addUser";
    }
    //更新用户页面
    @GetMapping("/getupdate")
    public String getupdate(){
        return "/update";
    }

    //登录页面
    @GetMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }

    @GetMapping("/toShrioError")
    public String toShrioError(){
        return "ShrioError";
    }

    //登录业务逻辑
    @PostMapping("/login")
    public String login(String name, String password, Model model){
        /**
         * 使用shrio编写认证操作
         */
        //1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        //执行登录方法
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "/login";
        }

        return "/test";
    }
}
