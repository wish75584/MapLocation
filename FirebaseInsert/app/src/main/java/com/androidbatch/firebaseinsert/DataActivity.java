package com.androidbatch.firebaseinsert;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DataActivity extends AppCompatActivity {

    RecyclerView rv_data;
    RecyclerViewAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference reference;
    ArrayList<Data> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        rv_data = findViewById(R.id.rv_data);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("data");
        rv_data.setLayoutManager( new LinearLayoutManager(this));
        list = new ArrayList<>();

        //fetching data from firebase
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Data d = dataSnapshot.getValue(Data.class);
                    list.add(d);
                }
                adapter = new RecyclerViewAdapter(list, DataActivity.this);
                rv_data.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DataActivity.this, "" +error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}