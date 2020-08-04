package com.qianfeng.controller;

import com.qianfeng.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *  登录控制器
 */
@Controller
@RequestMapping("/LoginController")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String Login(String login_user_name, String login_pass_word, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        map.put("login_user_name",login_user_name);
        map.put("login_pass_word",login_pass_word);
        Map<String,Object> returnmap = loginService.login(map,request);
        if((boolean)returnmap.get("result")){
        //登陆成功
            return "../page/main.jsp";
        }else {
            //登录失败
            System.out.println("\n"+returnmap.get("msg")+"\n============================================================");
            request.setAttribute("msg",returnmap.get("msg"));
            return "../index.jsp";
        }
    }
}
