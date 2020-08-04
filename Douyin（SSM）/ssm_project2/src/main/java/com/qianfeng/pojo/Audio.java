package com.qianfeng.pojo;

import java.util.Date;

public class Audio {
    private int audio_id;
    private String audio_title;
    private String audio_src;
    private Date audio_date;
    private int audio_status;
    private int business_id;
    private String business_username;

    public int getAudio_id() {
        return audio_id;
    }

    public void setAudio_id(int audio_id) {
        this.audio_id = audio_id;
    }

    public String getAudio_title() {
        return audio_title;
    }

    public void setAudio_title(String audio_title) {
        this.audio_title = audio_title;
    }

    public String getAudio_src() {
        return audio_src;
    }

    public void setAudio_src(String audio_src) {
        this.audio_src = audio_src;
    }

    public Date getAudio_date() {
        return audio_date;
    }

    public void setAudio_date(Date audio_date) {
        this.audio_date = audio_date;
    }

    public int getAudio_status() {
        return audio_status;
    }

    public void setAudio_status(int audio_status) {
        this.audio_status = audio_status;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public String getBusiness_username() {
        return business_username;
    }

    public void setBusiness_username(String business_username) {
        this.business_username = business_username;
    }
}
