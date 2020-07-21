package com.suek.nyamnyam;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper_HowtoCook {

    public static Retrofit getInstance(){
        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("http://suhyun2963.dothome.co.kr");
        builder.addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }
}
