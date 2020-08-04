package com.qianfeng.dao;

import com.qianfeng.pojo.Video;

import java.util.List;

public interface VideoDao {

    /**
     * 插入视频相关信息
     * @param video
     * @return
     */
    int insertVideo(Video video);


    /**
     * 根据business_id查询视频信息
     * @param business_id
     * @return
     */

    List<Video> selectVideo(int business_id);

    /**
     * 将视频置为商户删除状态
     * @param video_id
     * @return
     */
    int updateVideoToDeleteStatus(int video_id);

    /**
     * 根据business_id查询回收站视频信息
     * @param business_id
     * @return
     */

    List<Video> selectRecycleVideo(int business_id);

    /**
     * 将视频从回收站还原
     * @param video_id
     * @return
     */
    int updateVideoToNormalStatus(int video_id);

    /**
     * 根据video_id删除视频信息
     * @param video_id
     * @return
     */
    int deleteRecycleVideoByID(int video_id);


    /**
     * 根据视频标题查询视频信息
     * @param video
     * @return
     */
    List<Video> selectVideoByTitleAndBusinessID(Video video);

    /**
     * 查找被管理员禁用的视频信息
     * @param business_id
     * @return
     */
    List<Video> selectForbiddenVideo(int business_id);


    /*--------------------------------郑安峰------------------------------------------*/


    /**
     * 查询所有视频(管理员)
     * @param video_status
     * @return
     */
    List<Video> selectAllVideo(int video_status);

    /**
     *下架视频
     * @param video_id
     * @return
     */
    int deleteVideoByAdmin(int video_id);

    /**
     * 恢复视频
     * @param video_id
     * @return
     */
    int restoreVideoByAdmin(int video_id);

}
