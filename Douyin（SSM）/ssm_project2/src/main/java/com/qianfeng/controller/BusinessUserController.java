package com.qianfeng.controller;


import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.BusinessUserInfo;
import com.qianfeng.service.BusinessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/BusinessUserController")
public class BusinessUserController {
    @Autowired
    BusinessUserService businessUserService;

    @RequestMapping("/getBusinessUserInfo")
    @ResponseBody
    public BusinessUserInfo getBusinessUserInfo(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();
        System.out.println("business_id:"+business_id);
        return  businessUserService.selectBusinessUserByID(business_id);
    }

//    @RequestMapping("/updateBusinessUser")
//    public String updateBusinessUser(BusinessUserInfo businessUserInfo, HttpServletRequest request){
//
//        boolean b = businessUserService.updateBusinessUser(businessUserInfo,request);
//        if(b){
//            request.setAttribute("msg","修改成功");
//
//        }else{
//
//            request.setAttribute("msg","修改失败");
//        }
//
//        return "../page/business/addBusinessUser.jsp";
//    }



}
