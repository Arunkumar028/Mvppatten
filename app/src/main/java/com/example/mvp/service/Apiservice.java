package com.example.mvp.service;

import com.example.mvp.model.GetResponce;
import com.example.mvp.model.NewMvpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiservice {
    @GET("/demos/marvel/")
    Call<List<GetResponce>>responcecall();

    @GET("/photos")
    Call<List<NewMvpResponse>> newmvpresponce();



}
