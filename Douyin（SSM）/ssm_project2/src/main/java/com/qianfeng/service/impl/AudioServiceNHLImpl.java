package com.qianfeng.service.impl;

import com.qianfeng.dao.AudioDao;
import com.qianfeng.pojo.Audio;
import com.qianfeng.pojo.Business;
import com.qianfeng.service.AudioServiceNHL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public  class AudioServiceNHLImpl implements AudioServiceNHL {

    @Autowired
    AudioDao audioDao;

    /**
     * 实现音频的上传，并将相关信息写入数据库
     * @param audio
     * @param multipartFile
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public boolean uploadAudio(Audio audio, MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        //=================文件上传=================

        //设置文件放在哪个路径下（全路径：路径+文件名.扩展名）定义成file
        //获取项目的目录
        String projectPath = request.getServletContext().getRealPath("");
        //设置文件的全路径
        String filePath = projectPath + "/audio/" + multipartFile.getOriginalFilename();
        //  创建File对象
        File file = new File(filePath);

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

        System.out.println(" ");
        //转移文件
        multipartFile.transferTo(new File(filePath));


        //===================数据保存================
        Business business = (Business) request.getSession().getAttribute("business");
        //获取数据
        audio.setAudio_src("/audio/" + multipartFile.getOriginalFilename());
        audio.setBusiness_id(business.getBusiness_id());
        //获取对应Dao层
        int res = audioDao.insertAudio(audio);
        //带着相关参数执行数据库，返回结果
        if(res > 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 查看business_id的音频信息
     * @param business_id
     * @return
     */
    @Override
    public List<Audio> getAudioInfoById(int business_id) {
        return audioDao.selectAudio(business_id);
    }

    @Override
    public boolean deleteAudio(int audio_id, HttpServletRequest request) {
        System.out.println("audio_id:"+audio_id);
        int r = audioDao.updateAudioToDeleteStatus(audio_id);

        if(r>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Audio> getRecycleAudioInfoById(int business_id) {
        return audioDao.selectRecycleAudio(business_id);
    }

    @Override
    public boolean restoreAudio(int audio_id, HttpServletRequest request) {
        int r = audioDao.updateAudioToNormalStatus(audio_id);

        if(r>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteRecycleAudio(int audio_id,String audio_src, HttpServletRequest request) {
        int r = audioDao.deleteRecycleAudioByID(audio_id);

        String projectPath = request.getServletContext().getRealPath("");
        File file = new File(projectPath+audio_src);
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
     * 查询audio_title的视频信息
     * @param audio
     * @return
     */
    @Override
    public List<Audio> getVideoByTitleAndBusinessID(Audio audio) {

        return audioDao.selectAudioByTitleAndBusinessID(audio);
    }


    /**
     * 查询被管理员禁用的视频信息
     * @param business_id
     * @return
     */
    @Override
    public List<Audio> getForbiddenAudioInfoById(int business_id) {

        return audioDao.selectForbiddenAudio(business_id);
    }

}
