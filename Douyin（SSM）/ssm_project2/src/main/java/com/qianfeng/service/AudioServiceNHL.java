package com.qianfeng.service;

import com.qianfeng.pojo.Audio;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface AudioServiceNHL {

    boolean uploadAudio(Audio audio, MultipartFile multipartFile, HttpServletRequest request) throws IOException;

    List<Audio> getAudioInfoById(int business_id);

    boolean deleteAudio(int audio_id,HttpServletRequest request);

    List<Audio> getRecycleAudioInfoById(int business_id);

    boolean restoreAudio(int audio_id,HttpServletRequest request);

    boolean deleteRecycleAudio(int audio_id,String audio_src,HttpServletRequest request);

    List<Audio> getVideoByTitleAndBusinessID(Audio audio);

    List<Audio> getForbiddenAudioInfoById(int business_id);
}
