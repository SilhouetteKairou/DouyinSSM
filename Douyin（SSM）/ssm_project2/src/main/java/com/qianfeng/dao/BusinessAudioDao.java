package com.qianfeng.dao;

import com.qianfeng.pojo.Audio;

import java.util.List;

//hsz添加

public interface BusinessAudioDao {
    /**
     * 查询视频信息
     * @param business_id
     * @return
     */

    List<Audio> selectBusinessAudio(int business_id);
}