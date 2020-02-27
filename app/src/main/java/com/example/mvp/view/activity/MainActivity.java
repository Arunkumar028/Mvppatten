package com.example.mvp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvp.model.GetResponce;
import com.example.mvp.interfaces.Mvp;
import com.example.mvp.presenter.Presenter;
import com.example.mvp.R;
import com.example.mvp.view.adapter.Getnamelist;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Mvp.mainactivity {

    Presenter presenter;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    Getnamelist getnamelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        presenter=new Presenter(MainActivity.this,MainActivity.this);
        presenter.main();

    }
    @Override
    public void success(ArrayList<GetResponce> getResponces) {
        getnamelist=new Getnamelist(MainActivity.this,getResponces);
        recyclerView.setAdapter(getnamelist);
    }

    @Override
    public void fail(String name) {
        Toast.makeText(this, name+"", Toast.LENGTH_LONG).show();
    }
}
