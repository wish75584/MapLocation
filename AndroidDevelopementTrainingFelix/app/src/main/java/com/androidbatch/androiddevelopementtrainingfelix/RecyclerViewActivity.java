package com.androidbatch.androiddevelopementtrainingfelix;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView rv_data;
    //ReclerViewAdapter reclerViewAdapter;
    ArrayList<Model> modellist;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rv_data = (RecyclerView) findViewById(R.id.rv_data);

        modellist = new ArrayList<Model>();
        rv_data.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter( modellist,this);



        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();//reading data from db
       // recyclerViewAdapter = new RecyclerViewAdapter( modellist,this);

        String[] col = {"username","password"};
        Cursor cursor = db.query("user_login", col, "", null, "", "", "");

        while (cursor.moveToNext()) {
            //getting data from db
            String userName = cursor.getString(cursor.getColumnIndexOrThrow("username"));
            String passWord = cursor.getString(cursor.getColumnIndexOrThrow("password"));
            //setting data to model
            Model p1 = new Model(""+userName,""+passWord);

            modellist.add(p1);

        }
        cursor.close();
        rv_data.setAdapter(recyclerViewAdapter);
    }
}


