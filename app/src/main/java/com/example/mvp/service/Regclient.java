package com.example.mvp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Regclient {
    public static String BaseURL = "https://www.simplifiedcoding.net";

    private static Retrofit retrofit = null;

    public static Retrofit Getclient() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(380, TimeUnit.SECONDS)
                    .readTimeout(380, TimeUnit.SECONDS)
                    .writeTimeout(380, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).client(client)
                    .build();


        }


        return retrofit;
    }
}
