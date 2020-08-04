package com.qianfeng.service;

import com.qianfeng.pojo.BusinessUserInfo;

import javax.servlet.http.HttpServletRequest;

public interface BusinessUserService {

    BusinessUserInfo selectBusinessUserByID(int business_id);


    boolean updateBusinessUser(BusinessUserInfo businessUserInfo, HttpServletRequest request);
}
