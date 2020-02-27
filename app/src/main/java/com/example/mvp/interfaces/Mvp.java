package com.example.mvp.interfaces;

import com.example.mvp.model.GetResponce;
import com.example.mvp.model.NewMvpResponse;

import java.util.ArrayList;

public interface Mvp {

    interface prsenter {
        void main();
    }
    interface mainactivity {
        void success(ArrayList<GetResponce>getResponces);
        void fail(String name);
    }

}


