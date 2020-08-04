package com.qianfeng.service;

import com.qianfeng.pojo.Video;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface VideoServiceNHL {

    boolean upload(Video video, MultipartFile multipartFile, HttpServletRequest request) throws IOException;

    List<Video> getVideoInfoById(int business_id);

    boolean deleteVideo(int video_id,HttpServletRequest request);

    List<Video> getRecycleVideoInfoById(int business_id);

    boolean restoreVideo(int video_id,HttpServletRequest request);

    boolean deleteRecycleVideo(int video_id,String video_src,HttpServletRequest request);

    List<Video> getVideoByTitleAndBusinessID(Video video);

    List<Video> getForbiddenVideoInfoById(int business_id);

}
