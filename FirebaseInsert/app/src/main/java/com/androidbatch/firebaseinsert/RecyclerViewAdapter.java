package com.androidbatch.firebaseinsert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    ArrayList<Data> list;
    Context mcontext;

    public RecyclerViewAdapter(ArrayList<Data> list, Context mcontext) {
        this.list = list;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data pos = list.get(position);
        holder.tv_name.setText(pos.getName());
        holder.tv_number.setText(pos.getNumber());
        holder.tv_email.setText(pos.getEmail());
        holder.tv_passs.setText(pos.getPass());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_number, tv_email, tv_passs;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_number = itemView.findViewById(R.id.tv_number);
            tv_email = itemView.findViewById(R.id.tv_email);
            tv_passs = itemView.findViewById(R.id.tv_pass);

        }
    }
}
