package com.example.mvp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.interfaces.Mvp;
import com.example.mvp.interfaces.Mvp1;
import com.example.mvp.model.NewMvpResponse;
import com.example.mvp.presenter.Mvppresenter;
import com.example.mvp.view.adapter.Mvpadapter;

import java.util.ArrayList;

public class MvppattenActivity extends AppCompatActivity implements Mvp1.mainactivity {
    private RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    Mvpadapter mvpadapter;
    Mvppresenter mvppresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvppatten);
        recyclerView=findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mvppresenter=new Mvppresenter(MvppattenActivity.this,MvppattenActivity.this);
        mvppresenter.main();
    }

    @Override
    public void success(ArrayList<NewMvpResponse> getResponces) {
        mvpadapter=new Mvpadapter(MvppattenActivity.this,getResponces);
       recyclerView.setAdapter(mvpadapter);
    }

    @Override
    public void fail(String name) {
        Toast.makeText(this, name+"", Toast.LENGTH_SHORT).show();

    }


}
