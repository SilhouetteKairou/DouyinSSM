package com.qianfeng.service.impl;

import com.qianfeng.dao.BusinessDao;
import com.qianfeng.dao.BusinessinfoDao;
import com.qianfeng.dao.BusinesspassDao;
import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.Businesspass;
import com.qianfeng.service.BusinessLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class BusinessLoginServiceImpl implements BusinessLoginService {

    @Autowired
    BusinessDao businessDao;
    @Autowired
    BusinesspassDao businesspassDao;
    @Autowired
    BusinessinfoDao businessinfoDao;
    /**
     * 登录相关操作
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> businessLogin(Map<String, Object> map, HttpServletRequest request) {
        Map<String,Object> returnmap = new HashMap<>();
        //接收数据
        String business_username = (String)map.get("business_username");
        String business_pass_word =  (String)map.get("business_pass_word");

        //处理登录功能
        Business business = businessDao.selectByUsername(business_username);

        if(business != null){//用户名存在，继续判断密码
            System.out.println("用户名存在");
            Businesspass businesspass = new Businesspass();
            businesspass.setBusiness_id(business.getBusiness_id());
            businesspass.setBusiness_pass_word(business_pass_word);
            Businesspass businesspass1 = businesspassDao.selectBusinessPass(businesspass);
            int bs = business.getBusiness_status();
            if(businesspass1 != null){//密码也没错
                if(bs==0) {//商户冻结状态是0还是1，是0的情况下登录成功


                    returnmap.put("result", true);

                    System.out.println("登录成功");
                    //===================================================================
                    //建立session对象
                    HttpSession session = request.getSession();
                    //将在session空间中保存一份角色类型
                    session.setAttribute("roleType", "2");//普通商户

                    //在session空间中保存一份用户相关信息（LoginUser）
                    session.setAttribute("business", business);
                    //===================================================================
                }else{//商户被冻结
                    returnmap.put("result",false);
                    returnmap.put("msg","账号被冻结，无法登录");
                    returnmap.put("falseType",3);//账号被冻结

                    System.out.println(returnmap.get("msg"));
                }

            }else{
                returnmap.put("result",false);
                returnmap.put("msg","密码有误");
                returnmap.put("falseType",1);//密码错误

                System.out.println(returnmap.get("msg"));
            }


        }else{//反馈信息
            returnmap.put("result",false);
            returnmap.put("msg","账户不存在，是否要直接创建");
            returnmap.put("falseType",2);//用户名不存在

            System.out.println(returnmap.get("msg"));
        }

        return returnmap;
    }

    /**
     * 注册相关操作
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> businessRegister(Map<String, Object> map,HttpServletRequest request) {
        Map<String,Object> returnmap = new HashMap<>();
        //接收数据
        String business_username = (String)map.get("business_username");
        String business_pass_word =  (String)map.get("business_pass_word");

        //创建用户
        int res1 = businessDao.insertBusiness(business_username);
        //查询当前用户的id
        Business business = businessDao.selectByUsername(business_username);
        //创建对应用户的密码
        Businesspass businesspass = new Businesspass();
        businesspass.setBusiness_pass_word(business_pass_word);
        businesspass.setBusiness_id(business.getBusiness_id());
        int res2 = businesspassDao.insertBusinessPass(businesspass);
        //创建商家信息
        int res3 = businessinfoDao.insertBusinessInfo(business.getBusiness_id());

        if(res1>0 && res2>0 && res3>0)
        {
            returnmap.put("result",true);
            returnmap.put("msg","注册成功");

            //===================================================================
            //建立session对象
            HttpSession session = request.getSession();
            //将在session空间中保存一份角色类型
            session.setAttribute("roleType","2");//普通商户

            //在session空间中保存一份用户相关信息（LoginUser）
            session.setAttribute("business",business);
            //===================================================================

            System.out.println(returnmap.get("msg"));
        }else {
            returnmap.put("result",false);
            returnmap.put("msg","注册失败");

            System.out.println(returnmap.get("msg"));
        }

        return returnmap;
    }
}
