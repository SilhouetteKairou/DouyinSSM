package com.qianfeng.dao;

import com.qianfeng.pojo.BusinessUserInfo;
import com.qianfeng.pojo.Businessinfo;

import java.util.List;

public interface BusinessinfoDao {

    /*<!--##开辟账户商家信息-->*/

    /**
     *
     * @param business_id
     * @return
     */
    int insertBusinessInfo(int business_id);


    /*---------------------------------------------*/



    /**
     * 根据id查出用户信息
     * @param business_id
     * @return
     */
    BusinessUserInfo selectBusinessUserByID(int business_id);

    /**
     * 修改商户信息
     * @param businessinfo
     * @return
     */
    int updateBusinessAllData(Businessinfo businessinfo);


    /*--------------------------------郑安峰------------------------------------------*/



    /*------------------------------胡斯哲-----------------------------------------*/
    /**
     * 查询所有商户信息
     * @return
     */
     List<BusinessUserInfo> selectBusinessUserAllInfo();





}
