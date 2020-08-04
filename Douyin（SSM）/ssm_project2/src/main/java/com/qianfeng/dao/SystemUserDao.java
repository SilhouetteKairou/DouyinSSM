package com.qianfeng.dao;

import com.qianfeng.pojo.SystemUser;
import com.qianfeng.pojo.SystemUserAndUsername;

import java.util.List;

public interface SystemUserDao {

    /*--------------------------------郑安峰------------------------------------------*/

    /**
     * 查询所有系统用户信息
     * @return
     */
    List<SystemUserAndUsername> selectSystemUserAllInfo();

    /**
     * 根据id查询系统用户信息
     * @param login_user_id
     * @return
     */
    SystemUserAndUsername selectSystemUserById(int login_user_id);

    /**
     * 修改个人信息
     * @param systemUser
     * @return
     */
    int updateAllData(SystemUser systemUser);


}
