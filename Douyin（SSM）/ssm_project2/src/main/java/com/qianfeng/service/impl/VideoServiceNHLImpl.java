package com.qianfeng.service.impl;

import com.qianfeng.dao.VideoDao;
import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.Video;
import com.qianfeng.service.VideoServiceNHL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class VideoServiceNHLImpl implements VideoServiceNHL {

    @Autowired
    VideoDao videoDao;
    /**
     * 实现视频的上传
     * @param video
     * @param multipartFile
     * @param request
     * @return
     */
    @Override
    public boolean upload(Video video, MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        //=================文件上传=================

        //设置文件放在哪个路径下（全路径：路径+文件名.扩展名）定义成file
            //获取项目的目录
        String projectPath = request.getServletContext().getRealPath("");
            //设置文件的全路径
        String filePath = projectPath + "/video/" + multipartFile.getOriginalFilename();
            //  创建File对象
        File file = new File(filePath);

        System.out.println("projectPath:"+projectPath);
        System.out.println("multipartFile.getOriginalFilename():"+multipartFile.getOriginalFilename());
        System.out.println("filePath:"+filePath);
        //判断文件路径是否存在，如果不存在，创建相应的父路径
        File fileParentFile = file.getParentFile();
        if(!fileParentFile.exists()){
            fileParentFile.mkdir();
        }
        //创建文件（路径+文件名.扩展名）空文件
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println("file"+file);

        //转移文件
        multipartFile.transferTo(new File(filePath));


        //===================数据保存================
        Business business = (Business) request.getSession().getAttribute("business");
        //获取数据
        video.setVideo_src("/video/" + multipartFile.getOriginalFilename());
        video.setBusiness_id(business.getBusiness_id());
        //获取对应Dao层
        int res = videoDao.insertVideo(video);
        //带着相关参数执行数据库，返回结果
        if(res > 0){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 查询business_id的视频信息
     * @param business_id
     * @return
     */
    @Override
    public List<Video> getVideoInfoById(int business_id) {

        return videoDao.selectVideo(business_id);
    }

    /**
     * 将视频放入回收站
     * @param video_id
     * @param request
     * @return
     */
    @Override
    public  boolean deleteVideo(int video_id, HttpServletRequest request) {

        int r = videoDao.updateVideoToDeleteStatus(video_id);

        if(r>0){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 查询business_id的视频信息
     * @param business_id
     * @return
     */
    @Override
    public List<Video> getRecycleVideoInfoById(int business_id) {

        return videoDao.selectRecycleVideo(business_id);
    }

    /**
     * 将视频回收站还原
     * @param video_id
     * @param request
     * @return
     */
    @Override
    public  boolean restoreVideo(int video_id,HttpServletRequest request) {

        int r = videoDao.updateVideoToNormalStatus(video_id);

        if(r>0){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 将视频从回收站删除
     * @param video_id
     * @param request
     * @return
     */
    @Override
    public  boolean deleteRecycleVideo(int video_id,String video_src,HttpServletRequest request) {


        int r = videoDao.deleteRecycleVideoByID(video_id);
        String projectPath = request.getServletContext().getRealPath("");
        System.out.println("666666666666666:"+video_src);
        System.out.println("666666666666666:"+projectPath + video_src);
        File file = new File(projectPath+video_src);
        if (file.isFile() && file.exists()) {
            file.delete();
        }

        if(r>0){
            return true;
        }else{
            return false;
        }

    }

    /**
     * 查询video_title的视频信息
     * @param video
     * @return
     */
    @Override
    public List<Video> getVideoByTitleAndBusinessID(Video video) {

        return videoDao.selectVideoByTitleAndBusinessID(video);
    }

    /**
     * 查询被管理员禁用的视频信息
     * @param business_id
     * @return
     */
    @Override
    public List<Video> getForbiddenVideoInfoById(int business_id) {

        return videoDao.selectForbiddenVideo(business_id);
    }

}










