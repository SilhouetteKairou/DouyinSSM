package com.qianfeng.service.impl;

//hsz创建

import com.qianfeng.dao.BusinessAudioDao;
import com.qianfeng.pojo.Audio;
import com.qianfeng.service.BusinessAudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessAudioServiceImpl implements BusinessAudioService {

    @Autowired
    BusinessAudioDao businessAudioDao;

    /**
     * 查询business_id的音频信息
     * @param business_id
     * @return
     */

    @Override
    public List<Audio> getBusinessAudioInfoById(int business_id) {

        return businessAudioDao.selectBusinessAudio(business_id);
    }
}
