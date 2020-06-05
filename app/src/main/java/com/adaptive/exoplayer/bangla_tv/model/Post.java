package com.adaptive.exoplayer.bangla_tv.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("channel_id")
    @Expose
    private Integer channelId;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("channel_name")
    @Expose
    private String channelName;
    @SerializedName("channel_image")
    @Expose
    private String channelImage;
    @SerializedName("channel_url")
    @Expose
    private String channelUrl;
    @SerializedName("channel_description")
    @Expose
    private String channelDescription;
    @SerializedName("channel_type")
    @Expose
    private String channelType;
    @SerializedName("video_id")
    @Expose
    private String videoId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelImage() {
        return channelImage;
    }

    public void setChannelImage(String channelImage) {
        this.channelImage = channelImage;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }

    public String getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(String channelDescription) {
        this.channelDescription = channelDescription;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
