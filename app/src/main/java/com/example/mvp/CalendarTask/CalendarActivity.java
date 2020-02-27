package com.example.mvp.CalendarTask;

import android.os.Bundle;

import com.example.mvp.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CalendarActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    @BindView(R.id.recycler) RecyclerView recyclerView;
    List<CustomTimer> list;
    private RecyclerViewAdapter.OnItemClickListener onItemClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        ButterKnife.bind(this);
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(),list,onItemClickListener);
        recyclerView.setAdapter(recyclerViewAdapter);



    }


}


