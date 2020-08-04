package com.qianfeng.dao;

import com.qianfeng.pojo.Businesspass;

public interface BusinesspassDao {


    /**
     *
     * @param businesspass
     * @return
     */
    Businesspass selectBusinessPass(Businesspass businesspass);

    /**
     *
     * @param businesspass
     * @return
     */
    int insertBusinessPass(Businesspass businesspass);

    /*---------------------------------------------------------------------------------*/


    /*修改用户密码*/
    int updateBusinessPassword(Businesspass businesspass);


    /*--------------------------------郑安峰------------------------------------------*/





}
