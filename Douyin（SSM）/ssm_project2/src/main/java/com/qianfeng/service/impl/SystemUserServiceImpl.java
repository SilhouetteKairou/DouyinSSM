package com.qianfeng.service.impl;

import com.qianfeng.dao.*;
import com.qianfeng.pojo.LoginPass;
import com.qianfeng.pojo.LoginUser;
import com.qianfeng.pojo.SystemUser;
import com.qianfeng.pojo.SystemUserAndUsername;
import com.qianfeng.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


import com.qianfeng.pojo.BusinessUserInfo;
import com.qianfeng.pojo.Business;

import javax.servlet.http.HttpSession;


@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    BusinessinfoDao businessinfoDao;
    @Autowired
    BusinessDao businessDao;
    @Autowired
    SystemUserDao systemUserDao;
    @Autowired
    LoginUserDao loginUserDao;
    @Autowired
    LoginPassDao loginPassDao;
    @Override
    public List<SystemUserAndUsername> getSystemUserAllInfo() {
        return systemUserDao.selectSystemUserAllInfo();
    }

    @Override
    public SystemUserAndUsername selectSystemUserById(int login_user_id) {
        return systemUserDao.selectSystemUserById(login_user_id);
    }

    @Override
    @Transactional
    public boolean updateSystemUser(SystemUserAndUsername systemUserAndUsername, HttpServletRequest request) {

        //0  获取session
        int login_user_id = ((LoginUser)request.getSession().getAttribute("loginUser")).getLogin_user_id();

        //1 修改用户名
        LoginUser loginUser = new LoginUser();
        loginUser.setLogin_user_id(login_user_id);
//        String a="\n=======================================================\n";
//        System.out.println(a+systemUserAndUsername.getLogin_user_name()+a);
        loginUser.setLogin_user_name(systemUserAndUsername.getLogin_user_name());
        int res1 = loginUserDao.updateUserName(loginUser);
        //2 修改密码
        LoginPass loginPass = new LoginPass();
        loginPass.setLogin_pass_word(systemUserAndUsername.getLogin_pass_word());
        loginPass.setLogin_user_id(login_user_id);
        int res2 = loginPassDao.updatePassWord(loginPass);
        //3 修改个人信息
        SystemUser systemUser = new SystemUser();
        systemUser.setLogin_user_id(login_user_id);
        systemUser.setUser_true_name(systemUserAndUsername.getUser_true_name());
        systemUser.setUser_tel(systemUserAndUsername.getUser_tel());
        systemUser.setUser_sex(systemUserAndUsername.getUser_sex());
        int res3 = systemUserDao.updateAllData(systemUser);

        if(res1>0 && res2>0 && res3>0){
            return true;
        }else{
            return false;
        }

    }

    /*--------------------------胡斯哲--------------------------------------*/
    @Override
    public String freezeBusinessUser(HttpServletRequest request) {//status=1被冻结,=0可登录

        //获取session
        HttpSession session = request.getSession();

        Business business = new Business();


//        business.setBusiness_id(Integer.parseInt(business_id));
//        business.setBusiness_status(1);


        int r1 = businessDao.updateBusinessStatus(business);
        if(r1==1){//执行成功
            System.out.println("冻结成功");
            return "冻结成功";
        }else{//执行失败
            System.out.println("冻结失败");
            return "冻结失败";
        }

    }


    @Override
    public List<BusinessUserInfo> getBusinessUserAllInfo() {

        return businessinfoDao.selectBusinessUserAllInfo();
    }



}
