package com.qianfeng.controller;


import com.qianfeng.service.BusinessLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 商户登录注册一体化相关
 */
@RestController
@RequestMapping("/BusinessLoginController")
public class BusinessLoginController {

    @Autowired
    BusinessLoginService businessLoginService;
    /**
     *
     * @param business_username
     * @param business_pass_word
     * @return
     */
    @RequestMapping("/login")
    public Map<String,Object> login(String business_username, String business_pass_word, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //接收数据
        map.put("business_username",business_username);
        map.put("business_pass_word",business_pass_word);

        //找人办事
        Map<String,Object> returnmap = businessLoginService.businessLogin(map,request);
        //反馈数据


        return returnmap;
    }

    /**
     *
     * @param business_username
     * @param business_pass_word
     * @return
     */
    @RequestMapping("/register")
    public  Map<String,Object> register(String business_username,String business_pass_word,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //接收数据
        map.put("business_username",business_username);
        map.put("business_pass_word",business_pass_word);
        //处理数据
        Map<String,Object> returnmap = businessLoginService.businessRegister(map,request);
        //反馈数据
        return returnmap;
    }





}
