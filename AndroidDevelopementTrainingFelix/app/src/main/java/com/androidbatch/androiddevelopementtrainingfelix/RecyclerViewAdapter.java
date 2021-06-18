package com.androidbatch.androiddevelopementtrainingfelix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//specifying type
class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {//change the name of view holder

    ArrayList<Model> list;
    Context context;

    public RecyclerViewAdapter(ArrayList<Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    //view holders name changed in adapter will also appear here
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        //getting data by using posiotion of list(arraylist)
        holder.username.setText(list.get(position).getUsername());
        holder.password.setText(list.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {//changed name of view  holder will create class here
        TextView username, password;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.cs_username);
            password = itemView.findViewById(R.id.cs_password);
        }
    }
}