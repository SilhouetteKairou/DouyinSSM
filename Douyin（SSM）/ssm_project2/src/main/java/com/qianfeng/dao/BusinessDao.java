package com.qianfeng.dao;

import com.qianfeng.pojo.Business;

public interface BusinessDao {

    /**
     *
     * @param business_username
     * @return
     */
    Business selectByUsername(String business_username);

    /**
     *
     * @param business_username
     * @return
     */
    Business isActive(String business_username);

    /**
     *
     * @param business_username
     * @return
     */
    int insertBusiness(String business_username);

    /*---------------------------------------------------------------------*/


    /**
     * 修改商户登录名
     * @param business
     * @return
     */
    int updateBusinessUserName(Business business);

    /*--------------------------------胡斯哲------------------------------------------*/
    /**
     * 修改商户状态
     * @param business
     * @return
     */
    int updateBusinessStatus(Business business);






}
