package com.example.quran.data.pojo;

public class Video {
    private int videoThumbnail;
    private String videoName;
    private int channelImg;
    private String link;

    public Video(int videoThumbnail, String videoName, int channelImg,String link) {
        this.videoThumbnail = videoThumbnail;
        this.videoName = videoName;
        this.channelImg = channelImg;
        this.link=link;
    }

    public String getLink() {
        return link;
    }

    public int getVideoThumbnail() {
        return videoThumbnail;
    }

    public String getVideoName() {
        return videoName;
    }

    public int getChannelImg() {
        return channelImg;
    }

}
