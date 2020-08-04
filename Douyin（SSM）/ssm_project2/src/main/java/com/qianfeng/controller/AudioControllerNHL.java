package com.qianfeng.controller;

import com.qianfeng.pojo.Audio;
import com.qianfeng.pojo.Business;
import com.qianfeng.service.AudioServiceGJH;
import com.qianfeng.service.AudioServiceNHL;
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
@RequestMapping("/AudioController")
public class AudioControllerNHL {

    @Autowired
    AudioServiceGJH audioServiceGJH;
    @Autowired
    AudioServiceNHL audioServiceNHL;

    @RequestMapping("/uploadAudio")
    public String uploadVideo(Audio audio, @RequestParam("audioFile") MultipartFile multipartFile, HttpServletRequest request){
        boolean result = false;
        //执行上传功能
        try {
            result = audioServiceNHL.uploadAudio(audio,multipartFile,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //处理反馈数据
        if(result){
            request.setAttribute("msg","上传成功");
            return "../page/audio/addAudio.jsp";
        }else {
            return null;
        }
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/getAudioInfoById")
    public String getAudioInfoById(HttpServletRequest request){
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();
        List<Audio> list = audioServiceNHL.getAudioInfoById(business_id);


        request.setAttribute("list",list);
        return "../page/audio/query_Audio.jsp";

    }


    /**
     * 将音频放入回收站
     * @param audio_id
     * @param request
     * @return
     */
    @RequestMapping("/deleteAudio")
    public String deleteAudio(int audio_id,HttpServletRequest request){

        boolean b = audioServiceNHL.deleteAudio(audio_id,request);
        if(b){

            System.out.println("音频删除成功");
        }else{

            System.out.println("音频删除失败");
        }

        return  "/AudioController/getAudioInfoById";
    }

    /**
     * 查询某商户回收站音频列表
     * @param request
     * @return
     */
    @RequestMapping("/getRecycleAudioInfoById")
    public String getRecycleAudioInfoById(HttpServletRequest request){
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();
        List<Audio> list = audioServiceNHL.getRecycleAudioInfoById(business_id);

        request.setAttribute("list",list);
        return "../page/audio/audioRecycleBin.jsp";
    }

    /**
     * 将音频从回收站还原
     * @param audio_id
     * @param request
     * @return
     */
    @RequestMapping("/restoreAudio")
    public String restoreAudio(int audio_id,HttpServletRequest request){

        boolean b = audioServiceNHL.restoreAudio(audio_id,request);
        if(b){

            System.out.println("视频还原成功");
        }else{

            System.out.println("视频还原失败");
        }

        return  "/AudioController/getRecycleAudioInfoById";
    }

    /**
     * 将视频从回收站彻底删除
     * @param audio_id
     * @param request
     * @return
     */
    @RequestMapping("/deleteRecycleAudio")
    public String deleteRecycleAudio(int audio_id,String audio_src,HttpServletRequest request){

        boolean b = audioServiceNHL.deleteRecycleAudio(audio_id,audio_src,request);
        if(b){

            System.out.println("将视频从回收站删除成功");
        }else{

            System.out.println("将视频从回收站删除失败");
        }

        return  "/AudioController/getRecycleAudioInfoById";
    }

    /**
     *根据video_title查询视频信息
     * @param request
     * @return
     */
    @RequestMapping("/getAudioByTitleAndBusinessID")
    public String getAudioByTitleAndBusinessID(String audio_title,HttpServletRequest request){
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();
        Audio audio = new Audio();
        audio.setBusiness_id(business_id);
        audio.setAudio_title(audio_title);
        List<Audio> list = audioServiceNHL.getVideoByTitleAndBusinessID(audio);

        request.setAttribute("list",list);
        return "../page/audio/query_Audio.jsp";

    }

    /**
     * 查找被禁用音频的信息
     * @param request
     * @return
     */
    @RequestMapping("/getForbiddenAudioInfoById")
    public String getForbiddenAudioInfoById(HttpServletRequest request){
        HttpSession session = request.getSession();
        int business_id = ((Business)session.getAttribute("business")).getBusiness_id();
        List<Audio> list = audioServiceNHL.getForbiddenAudioInfoById(business_id);

        request.setAttribute("list",list);
        request.setAttribute("msg","Forbidden");
        return "../page/audio/audioForbidden.jsp";
    }
/************************************郭江昊****************************************************************/
    @RequestMapping("/getAudio")
    public String getAudio(HttpServletRequest request){
        List<Audio> list= audioServiceGJH.selectAudio();
        request.setAttribute("list",list);
        return "../page/audio/query_AudioGJH.jsp";
    }

        @RequestMapping("/getAudioByID")
        public Audio getAudioByID(HttpServletRequest request){
            HttpSession session=request.getSession();
            int business_id=((Business)session.getAttribute("business")).getBusiness_id();
            return audioServiceGJH.selectAudioByUserID(business_id);
        }



}
