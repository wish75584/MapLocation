package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.html:
                Toast.makeText(this, "HTML", Toast.LENGTH_SHORT).show();
                break;

            case R.id.css:
                Toast.makeText(this, "CSS", Toast.LENGTH_SHORT).show();
                break;

            case R.id.java:
                Toast.makeText(this, "JAVA", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
