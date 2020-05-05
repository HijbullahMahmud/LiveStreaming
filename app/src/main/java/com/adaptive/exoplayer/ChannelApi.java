package com.adaptive.exoplayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChannelApi {
    @GET("-/raw/master/bdix/bdix_iptv_gallery")
    Call<List<Channel>> getAllChannels();
}
