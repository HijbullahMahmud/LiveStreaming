package com.adaptive.exoplayer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Channel {
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("channel_id")
    @Expose
    private String channelId;
    @SerializedName("source_url")
    @Expose
    private String sourceUrl;
    @SerializedName("link_description")
    @Expose
    private String linkDescription;
    @SerializedName("link_type")
    @Expose
    private String linkType;
    @SerializedName("link_priority")
    @Expose
    private Integer linkPriority;
    @SerializedName("link_name")
    @Expose
    private String linkName;
    @SerializedName("configuration_link")
    @Expose
    private Object configurationLink;
    @SerializedName("id")
    @Expose
    private String id;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public Integer getLinkPriority() {
        return linkPriority;
    }

    public void setLinkPriority(Integer linkPriority) {
        this.linkPriority = linkPriority;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public Object getConfigurationLink() {
        return configurationLink;
    }

    public void setConfigurationLink(Object configurationLink) {
        this.configurationLink = configurationLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
