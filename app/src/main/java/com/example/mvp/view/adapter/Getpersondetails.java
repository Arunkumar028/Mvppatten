package com.example.mvp.view.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.model.GetResponce;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Getpersondetails extends RecyclerView.Adapter<Getpersondetails.viewholer> {

    Context mcontext;
    List<GetResponce>getResponces;

    public Getpersondetails(Context mcontext, List<GetResponce> getResponces) {
        this.mcontext = mcontext;
        this.getResponces = getResponces;
    }

    @NonNull
    @Override
    public viewholer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.include_layout,parent,false);
        return new Getpersondetails.viewholer(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholer holder, int position) {
        GetResponce getResponce=getResponces.get(position);
        holder.name.setText(getResponce.getBio());
    }

    @Override
    public int getItemCount() {
        return getResponces.size();
    }

    public class viewholer extends RecyclerView.ViewHolder {
        TextView name,realname;

        public viewholer(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);

        }
    }
}

