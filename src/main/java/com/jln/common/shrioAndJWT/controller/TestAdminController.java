package com.jln.common.shrioAndJWT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName:
 * @Description:
 * @Author:三刀 Date:2019/12/26 11:54
 * Version:1.0
 **/
@RestController
@RequestMapping("/admin")
public class TestAdminController {

    @GetMapping("testrole")
    public String Testrole(HttpServletRequest request){
        return "访问角色权限成功!";
    }
}
