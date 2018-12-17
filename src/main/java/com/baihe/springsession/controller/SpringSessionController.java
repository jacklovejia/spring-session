package com.baihe.springsession.controller;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/v1/spring")
public class SpringSessionController {
    @RequestMapping("setSession")
    public String setSession(HttpServletRequest request, HttpServletResponse response){
        System.out.println("设置session");
        HttpSession session = request.getSession();
        String name = "jack";
        session.setAttribute("admin", name);

        return "好嘞"+name;
    }

    @RequestMapping("getSession")
    public String getSession(HttpServletRequest request){
        System.out.println(UUID.randomUUID() +"获取session");
        String admin = request.getSession().getAttribute("admin").toString();
        return admin;
    }
}
