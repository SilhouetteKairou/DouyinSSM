package com.qianfeng.service.impl;

import com.qianfeng.dao.LoginPassDao;
import com.qianfeng.dao.LoginUserDao;
import com.qianfeng.pojo.LoginPass;
import com.qianfeng.pojo.LoginUser;
import com.qianfeng.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginUserDao loginUserDao;
    @Autowired
    LoginPassDao loginPassDao;

    /**
     * 给定用户名和密码
     * 处理数据
     * 返回数据到Map
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> login(Map<String, Object> map, HttpServletRequest request) {

        Map<String,Object> returnmap = new HashMap<>();
        String login_user_name = (String)map.get("login_user_name");
        String login_pass_word = (String)map.get("login_pass_word");

        // 查询当前是否有指定用户存在
        List<LoginUser> list = loginUserDao.selectByUserName(login_user_name);
        int len_1 = list.size();
        if(len_1>0){//用户存在，继续判断密码
            LoginUser loginUser = list.get(0);
            Map<String,Object> paramap = new HashMap<>();
            paramap.put("login_pass_word",login_pass_word);
            paramap.put("login_user_id",loginUser.getLogin_user_id());
            List<LoginPass> loginPasses = loginPassDao.selectByPasswordAndUserId(paramap);

            int len_2 = loginPasses.size();
            if(len_2>0){//登陆成功
                //==================start==================================
                returnmap.put("result",true);

                //0 获取session对象
                HttpSession session = request.getSession();
                //1 在session空间中保存一份角色类型
                session.setAttribute("roleType","1");//1：超级管理员
                //2 在session空间中保存一份用户相关信息（LoginUser）
                session.setAttribute("loginUser",loginUser);



                //===================end===================================
            }else{//登录失败
                returnmap.put("result",false);
                returnmap.put("msg","密码错误");
            }

        }else{//用户不存在，返回结果
            returnmap.put("result",false);
            returnmap.put("msg","用户不存在");
        }
        return returnmap;
    }
}
