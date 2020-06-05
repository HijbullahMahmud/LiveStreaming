package com.adaptive.exoplayer.bangla_tv;

import com.adaptive.exoplayer.bangla_tv.model.CategoryData;
import com.adaptive.exoplayer.bangla_tv.model.ChannelData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BanglaTvApi {
    public static final String API_KEY = "cda11uT8cBLzm6a1YvsiUWOEgrFowk95K2DM3tHAPRCX4ypGjN";

    @GET("api/get_category_index/")
    Call<CategoryData> getAllCategories(@Query("api_key") String apiKay);

    @GET("api/get_category_posts/")
    Call<ChannelData> getCategoryDetailsByPage(@Query("api_key") String apiKay,
                                               @Query("id") int id,
                                               @Query("page") int page,
                                               @Query("count") int count);
}
