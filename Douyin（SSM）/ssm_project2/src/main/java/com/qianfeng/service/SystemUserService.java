package com.qianfeng.service;

import com.qianfeng.pojo.SystemUserAndUsername;
import com.qianfeng.pojo.BusinessUserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SystemUserService {

    List<SystemUserAndUsername> getSystemUserAllInfo();

    /**
     * 根据id查询系统用户信息
     * @param login_user_id
     * @return
     */
    SystemUserAndUsername selectSystemUserById(int login_user_id);

    /**
     * 修改系统用户数据
     * @param systemUserAndUsername
     * @param request
     * @return
     */
    boolean updateSystemUser(SystemUserAndUsername systemUserAndUsername, HttpServletRequest request);

    /*------------------胡斯哲----------------------------------*/
    /**
     * 冻结商户账户
     * @param request
     * @return
     */
    String freezeBusinessUser(HttpServletRequest request);

        /**
     * 查询所有商户的信息
     * @return
     */
    List<BusinessUserInfo> getBusinessUserAllInfo();

}
