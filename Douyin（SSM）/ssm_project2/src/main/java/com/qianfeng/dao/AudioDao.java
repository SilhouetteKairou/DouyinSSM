package com.qianfeng.dao;

import com.qianfeng.pojo.Audio;

import java.util.List;

public interface AudioDao {

    /**
     * 插入视频相关信息
     * @param audio
     * @return
     */
    int insertAudio(Audio audio);


    /**
     * 根据business_id查询视频信息
     * @param business_id
     * @return
     */

    List<Audio> selectAudio(int business_id);

    /**
     * 将视频置为商户删除状态
     * @param Audio_id
     * @return
     */
    int updateAudioToDeleteStatus(int Audio_id);

    /**
     * 根据business_id查询回收站视频信息
     * @param business_id
     * @return
     */

    List<Audio> selectRecycleAudio(int business_id);

    /**
     * 将视频从回收站还原
     * @param audio_id
     * @return
     */
    int updateAudioToNormalStatus(int audio_id);

    /**
     * 根据audio_id删除视频信息
     * @param audio_id
     * @return
     */
    int deleteRecycleAudioByID(int audio_id);

    /**
     * 根据音频标题查询音频信息
     * @param audio
     * @return
     */
    List<Audio> selectAudioByTitleAndBusinessID(Audio audio);

    /**
     * 查找被管理员禁用的音频信息
     * @param business_id
     * @return
     */
    List<Audio> selectForbiddenAudio(int business_id);

    /**********************************************************************/

    List<Audio> selectAudioGJH();//查看所有上传音频
    Audio selectAudioByIDGJH(int business_id);


    /*--------------------------------郑安峰------------------------------------------*/

}
