package com.qianfeng.service;

import com.qianfeng.pojo.Video;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface VideoService {


    /**
     * @param business_id
     * @return
     */
    List<Video> getVideoInfoById(int business_id);

    /**
     *
     * @param video_status
     * @return
     */
    List<Video> getAllVideo(int video_status);


    boolean deleteVideoByAdmin(int video_id, HttpServletRequest request);

    boolean restoreVideoByAdmin(int video_id, HttpServletRequest request);

   

}
