package com.qianfeng.service;


import com.qianfeng.pojo.Audio;

import java.util.List;

public interface AudioServiceGJH {
    List<Audio> selectAudio();//显示所有音频信息

    Audio selectAudioByUserID(int business_id);//根据用户id查找
}
