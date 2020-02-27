package com.example.mvp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.model.NewMvpResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Mvpadapter extends RecyclerView.Adapter<Mvpadapter.Viewholder> {

    Context mcontext;
    List<NewMvpResponse> newMvpResponses;

    public Mvpadapter(Context mcontext, List<NewMvpResponse> newMvpResponses) {
        this.mcontext = mcontext;
        this.newMvpResponses = newMvpResponses;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(mcontext).inflate(R.layout.include_layout,parent,false);
        return new Mvpadapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        NewMvpResponse newMvpResponse=newMvpResponses.get(position);
        holder.title.setText(newMvpResponse.getTitle());
        holder.id.setText(String.valueOf(newMvpResponse.getId()));

    }

    @Override
    public int getItemCount() {
        return newMvpResponses.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView id,title;
        ImageView imageView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            id=(TextView) itemView.findViewById(R.id.name);
            title=(TextView) itemView.findViewById(R.id.realname);
            imageView=itemView.findViewById(R.id.imageview);
        }
    }
}
