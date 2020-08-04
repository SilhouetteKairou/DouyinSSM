package com.qianfeng.service;

//hsz添加

import com.qianfeng.pojo.Video;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface BusinessVideoService {
    List<Video> getBusinessVideoInfoById(int business_id);
}
