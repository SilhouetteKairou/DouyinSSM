package com.qianfeng.dao;

import com.qianfeng.pojo.LoginPass;

import java.util.List;
import java.util.Map;

/**
 * 密码表dao层
 */
public interface LoginPassDao {


    /*--------------------------------郑安峰------------------------------------------*/

    /**
     * 给定map参数，返回查询结果
     * @param map
     * @return
     */
    List<LoginPass>  selectByPasswordAndUserId(Map<String ,Object> map);


    /**
     * 修改 登录密码
     * @param loginPass
     * @return
     */
    int updatePassWord (LoginPass loginPass);



}
