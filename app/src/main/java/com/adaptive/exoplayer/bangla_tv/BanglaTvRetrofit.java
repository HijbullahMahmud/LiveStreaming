package com.adaptive.exoplayer.bangla_tv;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BanglaTvRetrofit {
    private static Retrofit retrofit = null;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit =  new Retrofit.Builder()
                    .baseUrl("http://pronobtelecom.com/HB/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
