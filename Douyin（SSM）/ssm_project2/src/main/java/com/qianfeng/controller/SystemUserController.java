package com.qianfeng.controller;

import com.qianfeng.pojo.LoginUser;
import com.qianfeng.pojo.SystemUserAndUsername;
import com.qianfeng.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.BusinessUserInfo;



@Controller
@RequestMapping("/SystemUserController")
public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;

    @RequestMapping("/getSystemUserAllInfo")
    public String getSystemUserAllInfo(HttpServletRequest request){
        List<SystemUserAndUsername> list = systemUserService.getSystemUserAllInfo();
        request.setAttribute("list",list);
        return "../page/system/systemoper.jsp";
    }

    @RequestMapping("/getSystemUserById")
    @ResponseBody
    public SystemUserAndUsername getSystemUserById(HttpServletRequest request){
        HttpSession session = request.getSession();
        int login_user_id = ((LoginUser)session.getAttribute("loginUser")).getLogin_user_id();
        return systemUserService.selectSystemUserById(login_user_id);
    }
    @RequestMapping("/updateSystemUser")
    public String updateSystemUser(SystemUserAndUsername systemUserAndUsername,HttpServletRequest request){
        boolean b = systemUserService.updateSystemUser(systemUserAndUsername,request);
        if(b){
            request.setAttribute("msg","修改成功");
        }else{
            request.setAttribute("msg","修改失败");
        }
        return "../page/system/addSystemoper.jsp";
    }

    /*-------------------------------胡斯哲-------------------------------------------------*/

    @RequestMapping("/getBusinessUserAllInfo")

    public String getBusinessUserAllInfo(HttpServletRequest request){

        List<BusinessUserInfo> list = systemUserService.getBusinessUserAllInfo();
        request.setAttribute("businessList",list);
        return "../page/system/businessuser.jsp";
    }




    @RequestMapping("/freezeBusinessUser")
    @ResponseBody
    public String freezeBusinessUser(HttpServletRequest request){
//    public boolean freezeBusinessUser(@RequestParam("business_id") String business_id, HttpServletRequest request){
        //================================这个有传参bug===================================================
        HttpSession session = request.getSession();
//        business_id = ((Business)session.getAttribute("business")).getBusiness_id();
//        List<BusinessUserInfo> list = systemUserService.getBusinessUserAllInfo();
//        request.setAttribute("businessList",list);

        String s = systemUserService.freezeBusinessUser(request);
        if(s!=null){
//            request.setAttribute("msg","冻结成功");
//            return true;

        }else{
//            request.setAttribute("msg","冻结失败");
//            return false;
        }
        return "../page/system/freezeBusinessUser.jsp";
    }








}
