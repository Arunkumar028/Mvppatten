package com.example.mvp.presenter;

import android.content.Context;


import com.example.mvp.interfaces.Mvp;
import com.example.mvp.interfaces.Mvp1;
import com.example.mvp.model.GetResponce;
import com.example.mvp.model.NewMvpResponse;
import com.example.mvp.service.Apiservice;
import com.example.mvp.service.Mvpclient;
import com.example.mvp.view.activity.MvppattenActivity;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mvppresenter implements Mvp1.prsenter{

    Context mcontext;
    Mvp1.mainactivity mainactivity;

    public Mvppresenter(MvppattenActivity mcontext, MvppattenActivity mvppattenActivity) {
        this.mcontext = mcontext;
        this.mainactivity = (Mvp1.mainactivity) mvppattenActivity;
    }

    @Override
    public void main() {
        Apiservice apiservice=Mvpclient.Getclient().create(Apiservice.class);
        Call<List<NewMvpResponse>>call=apiservice.newmvpresponce();
        call.enqueue(new Callback<List<NewMvpResponse>>() {
            @Override
            public void onResponse(Call<List<NewMvpResponse>> call, Response<List<NewMvpResponse>> response) {
                if (response.isSuccessful()){
                    mainactivity.success((ArrayList<NewMvpResponse>) response.body());


                }
                else {
                    mainactivity.fail("No Records");
                }
            }

            @Override
            public void onFailure(Call<List<NewMvpResponse>> call, Throwable t) {

            }
        });
    }


}
