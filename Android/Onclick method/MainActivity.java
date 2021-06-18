package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button showToast1;
    Button showToast2, showToast3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast1 = findViewById(R.id.showToast1);
        showToast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button one", Toast.LENGTH_SHORT).show();                
            }
        });
    
        showToast2 = findViewById(R.id.showToast2);
        showToast2.setOnClickListener(this);

        showToast3 = findViewById(R.id.showToast3);
        showToast3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showToast2:
                Toast.makeText(this, "Button 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.showToast3:
                Toast.makeText(this, "Button 3", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void showMessage(View v) {
        Toast.makeText(MainActivity.this, "BUtton 4", Toast.LENGTH_LONG).show();
    }
}
