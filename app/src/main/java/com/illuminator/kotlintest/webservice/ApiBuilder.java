package com.illuminator.kotlintest.webservice;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LiGe
 * Date: 2019/8/22
 */
public class ApiBuilder {
    public static final int GLOBAL_CONNECT_TIMEOUT = 20;
    public static final int GLOBAL_READ_TIMEOUT = 60;
    public static final int GLOBAL_WRITE_TIMEOUT = 60;

    private final Retrofit.Builder internalBuilder;

    private OkHttpClient okHttpClient;

    public ApiBuilder(String baseUrl, OkHttpClient okHttpClient){
        this.okHttpClient = okHttpClient;
        internalBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl);
    }

    public ApiBuilder setConnectionTimeout(long timeout, TimeUnit timeUnit){
        okHttpClient = okHttpClient.newBuilder()
                .connectTimeout(timeout, timeUnit)
                .build();
        return this;
    }

    public ApiBuilder setReadTimeout(long timeout, TimeUnit timeUnit){
        okHttpClient = okHttpClient.newBuilder()
                .readTimeout(timeout, timeUnit)
                .build();
        return this;
    }

    public ApiBuilder setWriteTimeout(long timeout, TimeUnit timeUnit){
        okHttpClient = okHttpClient.newBuilder()
                .writeTimeout(timeout, timeUnit)
                .build();
        return this;
    }

    public ApiBuilder followRedirects(boolean willFollow){
        okHttpClient = okHttpClient.newBuilder()
                .followRedirects(willFollow)
                .build();
        return this;
    }

    public ApiBuilder useGsonSerializer(){
        internalBuilder.addConverterFactory(GsonConverterFactory.create());
        return this;
    }

    public ApiBuilder useRxJava2(){
        internalBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return this;
    }

    public <T> T build(Class<T> apiClass){
        return internalBuilder.client(okHttpClient)
                .build().create(apiClass);
    }
}
