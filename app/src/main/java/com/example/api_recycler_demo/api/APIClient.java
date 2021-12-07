package com.example.api_recycler_demo.api;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    //https://www.journaldev.com/13639/retrofit-android-example-tutorial

    private static Retrofit retrofit = null;
    public static String url = "http://shine.officebrains.in/";
    public static String urlApi = url + "api/";

    public static Retrofit getClient(Context context) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(2000, TimeUnit.SECONDS);
        httpClient.readTimeout(2000, TimeUnit.SECONDS);
        httpClient.writeTimeout(2000, TimeUnit.SECONDS);
        httpClient.addInterceptor(interceptor);
        httpClient.addInterceptor(new NetworkConnectionInterceptor(context));

        retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        return retrofit;
    }
}
