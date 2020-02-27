package com.example.mvp.presenter;

import android.content.Context;

import com.example.mvp.interfaces.Mvp;
import com.example.mvp.model.GetResponce;
import com.example.mvp.service.Apiservice;
import com.example.mvp.service.Regclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements Mvp.prsenter {
    Context mcontext;
    Mvp.mainactivity mainactivity;

    public Presenter(Context mcontext, Mvp.mainactivity mainactivity) {
        this.mcontext = mcontext;
        this.mainactivity = mainactivity;
    }

    @Override
    public void main() {
        Apiservice apiservice= Regclient.Getclient().create(Apiservice.class);
        final Call<List<GetResponce>> getResponceCall=apiservice.responcecall();
        getResponceCall.enqueue(new Callback<List<GetResponce>>() {
            @Override
            public void onResponse(Call<List<GetResponce>> call, Response<List<GetResponce>> response) {
                if (response.isSuccessful()){
                    mainactivity.success((ArrayList<GetResponce>)response.body());

                }
            }

            @Override
            public void onFailure(Call<List<GetResponce>> call, Throwable t) {

            }
        });
    }

//    @Override
//    public void main() {
//        Apiservice apiservice= Regclient.Getclient().create(Apiservice.class);
//        Call<List<GetResponce>> getResponceCall=apiservice.responcecall();
//        getResponceCall.enqueue(new Callback<List<GetResponce>>() {
//            @Override
//            public void onResponse(Call<List<GetResponce>> call, Response<List<GetResponce>> response) {
//                if (response.isSuccessful()){
//                    mainactivity.success((ArrayList<GetResponce>) response.body());
//
//                }
//                else {
//                    mainactivity.fail("No Records");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<GetResponce>> call, Throwable t) {
//                if (t instanceof Exception){
//                    mainactivity.fail(t.getMessage());
//                }
//                else {
//                    mainactivity.fail(t.getMessage());
//                }
//            }
//        });
//
//


//    }
}
