package com.nagar.aakash.tablereservation.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    public static String getBaseUrl() {
        return BASE_URL;
    }

    private static final String BASE_URL = "http://192.168.43.14/restaurant-table-reservation-API/user-API/";
    private static Retrofit retrofit = null;
    private static Gson gson=new GsonBuilder().setLenient().create();

    private static final OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
