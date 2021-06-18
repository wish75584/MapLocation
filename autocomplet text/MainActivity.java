package com.example.mapsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter arrayAdapter;
    String string[] = {"HTML", "CSS", "Android", "PHP", "ASP", "Bootstrap", "Python"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.city1);
        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, string);
        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, string[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
