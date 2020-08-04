package com.qianfeng.controller;

import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.Video;
import com.qianfeng.service.VideoServiceNHL;
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
@RequestMapping("/VideoControlle")
public class VideoControllerNHL {

    @Autowired
    VideoServiceNHL videoServiceNHL;

    @RequestMapping("/uploadVideo")
    public String uploadVideo(Video video, @RequestParam("videoFile") MultipartFile multipartFile, HttpServletRequest request){
        boolean result = false;
        //执行上传功能
        try {
            result = videoServiceNHL.upload(video,multipartFile,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //处理反馈数据
        if(result){
            request.setAttribute("msg","上传成功");
            return "../page/video/addVideo.jsp";
        }else {
            return null;
        }
    }

    /**
     *查询视频信息
     * @param request
     * @return
     */
    @RequestMapping("/getVideoInfoById")
    public String getVideoInfoById(HttpServletRequest request){
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();
        List<Video> list = videoServiceNHL.getVideoInfoById(business_id);

        request.setAttribute("list",list);
        return "../page/video/query_Video.jsp";

    }

    /**
     * 将视频放入回收站
     * @param video_id
     * @param request
     * @return
     */
    @RequestMapping("/deleteVideo")
    public String deleteVideo(int video_id,HttpServletRequest request){

        boolean b = videoServiceNHL.deleteVideo(video_id,request);
        if(b){

            System.out.println("视频删除成功");
        }else{

            System.out.println("视频删除失败");
        }

        return  "/VideoControlle/getVideoInfoById";
    }

    /**
     * 查找商户视频回收站的视频信息
     * @param request
     * @return
     */
    @RequestMapping("/getRecycleVideoInfoById")
    public String getRecycleVideoInfoById(HttpServletRequest request){
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();
        List<Video> list = videoServiceNHL.getRecycleVideoInfoById(business_id);

        request.setAttribute("list",list);
        return "../page/video/videoRecycleBin.jsp";
    }

    /**
     * 将视频放入回收站
     * @param video_id
     * @param request
     * @return
     */
    @RequestMapping("/restoreVideo")
    public String restoreVideo(int video_id,HttpServletRequest request){

        boolean b = videoServiceNHL.restoreVideo(video_id,request);
        if(b){

            System.out.println("视频还原成功");
        }else{

            System.out.println("视频还原失败");
        }

        return  "/VideoControlle/getRecycleVideoInfoById";
    }

    /**
     * 将视频从回收站彻底删除
     * @param video_id
     * @param request
     * @return
     */
    @RequestMapping("/deleteRecycleVideo")
    public String deleteRecycleVideo(int video_id,String video_src,HttpServletRequest request){



        boolean b = videoServiceNHL.deleteRecycleVideo(video_id,video_src,request);
        if(b){

            System.out.println("将视频从回收站删除成功");
        }else{

            System.out.println("将视频从回收站删除失败");
        }

        return  "/VideoControlle/getRecycleVideoInfoById";
    }

    /**
     *根据video_title查询视频信息
     * @param request
     * @return
     */
    @RequestMapping("/getVideoByTitleAndBusinessID")
    public String getVideoByTitleAndBusinessID(String video_title,HttpServletRequest request){
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();
        Video video = new Video();
        video.setBusiness_id(business_id);
        video.setVideo_title(video_title);
        List<Video> list = videoServiceNHL.getVideoByTitleAndBusinessID(video);

        request.setAttribute("list",list);
        return "../page/video/query_Video.jsp";

    }

    /**
     * 查找被禁用视频的信息
     * @param request
     * @return
     */
    @RequestMapping("/getForbiddenVideoInfoById")
    public String getForbiddenVideoInfoById(HttpServletRequest request){
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();
        List<Video> list = videoServiceNHL.getForbiddenVideoInfoById(business_id);

        request.setAttribute("list",list);
        request.setAttribute("msg","Forbidden");
        return "../page/video/videoForbidden.jsp";
    }


}
