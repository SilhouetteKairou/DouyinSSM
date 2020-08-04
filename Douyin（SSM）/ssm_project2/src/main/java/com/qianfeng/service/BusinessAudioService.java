package com.qianfeng.service;

//hsz添加

import com.qianfeng.pojo.Audio;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface BusinessAudioService {
    List<Audio> getBusinessAudioInfoById(int business_id);
}
