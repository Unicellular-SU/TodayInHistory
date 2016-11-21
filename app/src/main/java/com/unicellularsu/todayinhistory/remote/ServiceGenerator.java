package com.unicellularsu.todayinhistory.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by szc on 2016/11/13.
 *
 */

public class ServiceGenerator {
    public static final String API_BASE_URL = "http://v.juhe.cn/todayOnhistory/";
    //public static final String API_BASE_URL = "https://api.github.com";


    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder=
            new Retrofit
                    .Builder().baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
    public static <S> S createSerxice(Class<S> serviceClass){
        Retrofit retrofit =builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}
