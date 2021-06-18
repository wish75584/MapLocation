package com.androidbatch.tabbedactivity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.androidbatch.tabbedactivity.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //custom view pager adapter
        //sending fragment manager as a parameter
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        //declaring and defining pager adapter
        ViewPager viewPager = findViewById(R.id.view_pager);//finding adapter

        //setting adapter to view pager
        viewPager.setAdapter(sectionsPagerAdapter);
        //fiding tabs by id
        TabLayout tabs = findViewById(R.id.tabs);
        //setting view pager to tab
        tabs.setupWithViewPager(viewPager);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}