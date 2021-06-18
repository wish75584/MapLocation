package com.androidbatch.androiddevelopementtrainingfelix;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.userName);
        password = findViewById(R.id.userPassword);
    }

    public void sendData(View view) {

        String Username = username.getText().toString().trim();
        String Password = password.getText().toString().trim();

        //DbHelper is a class, creating its  object named dbhelper
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //content  values is used to put values that we want to put in the table
        ContentValues values = new ContentValues();
        values.put("username", Username);
        values.put("password", Password);

        long rowId = db.insert("user_login", null, values);

        Log.e("Row Id", "**********" + rowId);
        Toast.makeText(this, " Data Inserted Sucessfully\n" + Username + "\n " + Password + "\n " + rowId, Toast.LENGTH_LONG).show();

    }

    public void showData(View view) {
        startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
    }
}