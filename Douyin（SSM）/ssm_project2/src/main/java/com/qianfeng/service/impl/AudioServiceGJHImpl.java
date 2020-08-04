package com.qianfeng.service.impl;

import com.qianfeng.dao.AudioDao;
import com.qianfeng.pojo.Audio;
import com.qianfeng.service.AudioServiceGJH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudioServiceGJHImpl implements AudioServiceGJH {
@Autowired
    AudioDao audioDao;
    @Override
    public List<Audio> selectAudio() {
        return audioDao.selectAudioGJH();
    }//查看所有音频

    @Override
    public Audio selectAudioByUserID(int business_id) {
        return audioDao.selectAudioByIDGJH(business_id);
    }
}
