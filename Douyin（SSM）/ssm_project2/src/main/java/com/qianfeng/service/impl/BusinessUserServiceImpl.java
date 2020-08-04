package com.qianfeng.service.impl;



import com.qianfeng.dao.BusinessDao;
import com.qianfeng.dao.BusinessinfoDao;
import com.qianfeng.dao.BusinesspassDao;
import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.BusinessUserInfo;
import com.qianfeng.pojo.Businessinfo;
import com.qianfeng.pojo.Businesspass;
import com.qianfeng.service.BusinessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class BusinessUserServiceImpl implements BusinessUserService {

    @Autowired
    BusinessDao businessDao;
    @Autowired
    BusinesspassDao businesspassDao;
    @Autowired
    BusinessinfoDao businessinfoDao;

    @Override
    public BusinessUserInfo selectBusinessUserByID(int business_id) {

        BusinessUserInfo businessUserInfo = businessinfoDao.selectBusinessUserByID(business_id);
        if(businessUserInfo != null)
        {
            System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddd");
        }
        return businessUserInfo;
    }

    @Override
    public boolean updateBusinessUser(BusinessUserInfo businessUserInfo, HttpServletRequest request) {
        //获取session
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();

        Business businessTemp = new Business();
        businessTemp = businessDao.selectByUsername(businessUserInfo.getBusiness_username());

        //判断用户名是否重复
        if(businessTemp != null){
            System.out.println("用户名已存在");
            return false;
        }

        //修改登录名
        Business business = new Business();
        business.setBusiness_id(business_id);
        business.setBusiness_username(businessUserInfo.getBusiness_username());
        int r1 = businessDao.updateBusinessUserName(business);
        //修改密码
        Businesspass businesspass = new Businesspass();
        businesspass.setBusiness_id(business_id);
        businesspass.setBusiness_pass_word(businessUserInfo.getBusiness_pass_word());
        int r2 = businesspassDao.updateBusinessPassword(businesspass);
        //修改商户信息
        Businessinfo businessinfo = new Businessinfo();
        businessinfo.setBusiness_id(business_id);
        businessinfo.setBusiness_info_name(businessUserInfo.getBusiness_info_name());
        businessinfo.setBusiness_info_legal_persion(businessUserInfo.getBusiness_info_legal_persion());
        businessinfo.setBusiness_info_legal_persion_tel(businessUserInfo.getBusiness_info_legal_persion_tel());
        int r3 = businessinfoDao.updateBusinessAllData(businessinfo);
        //

        if(r1 > 0 && r2 > 0 && r3 >0){
            System.out.println("修改成功");
            return true;
        }else{
            System.out.println("修改失败");
            return false;
        }


    }
}
