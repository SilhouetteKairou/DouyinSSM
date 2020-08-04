package com.qianfeng.dao;

import com.qianfeng.pojo.LoginUser;

import java.util.List;

/**
 * 用户表dao层
 */
public interface LoginUserDao {

    /*--------------------------------郑安峰------------------------------------------*/

    /**
     * 给定login_user_name 返回查询结果
     * @param login_user_name
     * @return
     */
    List<LoginUser> selectByUserName(String login_user_name);

    /**
     * 修改 用户名
     * @param loginUser
     * @return
     */
    int updateUserName(LoginUser loginUser);


}
