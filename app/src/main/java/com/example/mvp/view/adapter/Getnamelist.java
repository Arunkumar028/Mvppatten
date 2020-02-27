package com.example.mvp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvp.model.GetResponce;
import com.example.mvp.view.activity.MainActivity;
import com.example.mvp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Getnamelist extends RecyclerView.Adapter<Getnamelist.viewHolder> {
    Context mcontext;
    private List<GetResponce> getResponces;

    public Getnamelist(MainActivity mainActivity, List<GetResponce> getResponces){
        this.mcontext=mainActivity;
        this.getResponces=getResponces;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.include_layout,parent,false);
        return new Getnamelist.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        GetResponce getResponce=getResponces.get(position);
        holder.name.setText(getResponce.getName());
        holder.realname.setText(getResponce.getRealname());
    }

    @Override
    public int getItemCount() {
        return getResponces.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView name,realname;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            realname=(TextView)itemView.findViewById(R.id.realname);

        }
    }
}
