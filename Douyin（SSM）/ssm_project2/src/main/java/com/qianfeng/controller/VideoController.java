package com.qianfeng.controller;


import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.Video;
import com.qianfeng.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/VideoController")
public class VideoController {

    @Autowired
    VideoService videoService;

    /**
     *商户视频列表 显示已经发布的视频
     * @param request
     * @return
     */
    @RequestMapping("/getVideoPublishedById")
    public String getVideoPublishedById(HttpServletRequest request){
        Business business = (Business)request.getSession().getAttribute("business");
        List<Video> videoList = videoService.getVideoInfoById(business.getBusiness_id());
        request.setAttribute("videoList",videoList);

        return "../page/video/query_Video.jsp";

    }

    /**
     * 管理员视频列表 获取所有发布状态的视频
     * @param request
     * @return
     */
    @RequestMapping("/getAllVideoPublished")
    public String getAllVideoPublished(HttpServletRequest request){
       // Video video = (Video)request.getSession().getAttribute("video");
        List<Video> videoList = videoService.getAllVideo(1);
        request.setAttribute("videoList",videoList);
        return "../page/video/query_Video_admin.jsp";
    }

    /**
     * 获取被管理员所下架的视频
     * @param request
     * @return
     */
    @RequestMapping("/getAllVideoDeletedByAdmin")
    public String getAllVideoDeletedByAdmin(HttpServletRequest request){
        List<Video> videoList = videoService.getAllVideo(-1);
        request.setAttribute("videoList",videoList);
        return "../page/video/recycle_Video_admin.jsp";
    }

    /**
     * 下架视频
     * @param request
     * @return
     */
    @RequestMapping("/deleteVideoByAdmin")
    public String deleteVideoByAdmin(int video_id,HttpServletRequest request){
        boolean b = videoService.deleteVideoByAdmin(video_id,request);
        if(b){
            request.setAttribute("msg","修改成功");
        }else{
            request.setAttribute("msg","修改失败");
        }

        return  "/VideoController/getVideoPublishedById";
    }

    /**
     * 恢复视频
     * @param request
     * @return
     */
    @RequestMapping("/restoreVideoByAdmin")
    public String restoreVideoByAdmin(int video_id,HttpServletRequest request){
        boolean b = videoService.restoreVideoByAdmin(video_id,request);
        if(b){
            request.setAttribute("msg","修改成功");
        }else{
            request.setAttribute("msg","修改失败");
        }

        return  "/VideoController/getVideoPublishedById";
    }
}
