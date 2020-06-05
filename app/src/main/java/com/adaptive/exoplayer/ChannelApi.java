package com.adaptive.exoplayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChannelApi {
    //-/raw/master/bdix/bdix_iptv_gallery
    //-/raw/master/bdix/amrbd         good
    //-/raw/master/bdix/anytvlive
    //-/raw/master/bdix/bangla_iptv
    //-/raw/master/bdix/bangla_tv


    @GET("-/raw/master/bdix/anytvlive")
    Call<List<Channel>> getAllChannels();
}
