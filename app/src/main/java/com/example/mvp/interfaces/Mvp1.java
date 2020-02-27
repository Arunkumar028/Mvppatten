package com.example.mvp.interfaces;

import com.example.mvp.model.GetResponce;
import com.example.mvp.model.NewMvpResponse;

import java.util.ArrayList;

public interface Mvp1 {

    interface prsenter {
        void main();
    }
    interface mainactivity {
        void success(ArrayList<NewMvpResponse> getResponces);
        void fail(String name);
    }
}


