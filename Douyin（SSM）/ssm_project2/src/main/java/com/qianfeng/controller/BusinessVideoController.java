package com.qianfeng.controller;

/**
 * 某一商户的视频列表，hsz添加
 */

import com.qianfeng.pojo.Business;
import com.qianfeng.pojo.Video;
import com.qianfeng.service.BusinessVideoService;
import com.qianfeng.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/BusinessVideoController")
public class BusinessVideoController {

    @Autowired
    BusinessVideoService businessVideoService;



    @ResponseBody
    @RequestMapping("/getBusinessVideoInfoById")
    public String getBusinessVideoInfoById(String business_id,HttpServletRequest request){

        System.out.println("1111111111111111111111："+business_id);

        List<Video> list = businessVideoService.getBusinessVideoInfoById(1);

        int len1 = list.size();
        for(int i=0;i<len1;i++)
        {
            int status = list.get(i).getVideo_status();
            if(status==1) {//状态正常
                System.out.println("video_src:");
                System.out.println(list.get(i).getVideo_src());
            }
            else if(status==0) {
                System.out.println("该视频被商户下架！");
            }
            else if(status==-1) {
                System.out.println("该视频被管理员删除！");
            }
            else{
                System.out.println("video错误，状态码为"+status);
            }

        }
        request.setAttribute("list",list);
        return "../page/video/query_Video_admin.jsp";

    }

}

