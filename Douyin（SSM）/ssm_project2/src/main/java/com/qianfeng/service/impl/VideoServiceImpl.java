package com.qianfeng.service.impl;

import com.qianfeng.dao.VideoDao;
import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.SystemUser;
import com.qianfeng.pojo.Video;
import com.qianfeng.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoDao videoDao;


    /**
     * 根据id获取视频相关信息
     * @param business_id
     * @return
     */
    @Override
    public List<Video> getVideoInfoById(int business_id) {

        return videoDao.selectVideo(business_id);
    }

    /**
     * 获取所有已上传视频
     * @param video_status
     * @return
     */
    @Override
    public List<Video> getAllVideo(int video_status) {

        return videoDao.selectAllVideo(video_status);
    }

    /**
     * 管理员权限下架视频（放入回收站）
     * @param video_id
     * @param request
     * @return
     */
    @Override
    public boolean deleteVideoByAdmin(int video_id,HttpServletRequest request) {
        int r = videoDao.deleteVideoByAdmin(video_id);
        if(r>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 管理员权限恢复视频（放入视频列表）
     * @param video_id
     * @param request
     * @return
     */
    @Override
    public boolean restoreVideoByAdmin(int video_id,HttpServletRequest request) {
        int r = videoDao.restoreVideoByAdmin(video_id);
        if(r>0){
            return true;
        }else{
            return false;
        }
    }

}
