package com.qianfeng.dao;

import com.qianfeng.pojo.Video;

import java.util.List;

//hsz添加

public interface BusinessVideoDao {
    /**
     * 查询视频信息
     * @param business_id
     * @return
     */

    List<Video> selectBusinessVideo(int business_id);



}
