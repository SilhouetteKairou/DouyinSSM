package com.qianfeng.service.impl;

//hsz创建

import com.qianfeng.dao.BusinessVideoDao;
import com.qianfeng.pojo.Video;
import com.qianfeng.service.BusinessVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessVideoServiceImpl implements BusinessVideoService {

    @Autowired
    BusinessVideoDao businessVideoDao;

    /**
     * 查询business_id的视频信息
     * @param business_id
     * @return
     */

    @Override
    public List<Video> getBusinessVideoInfoById(int business_id) {

        return businessVideoDao.selectBusinessVideo(business_id);
    }
}
