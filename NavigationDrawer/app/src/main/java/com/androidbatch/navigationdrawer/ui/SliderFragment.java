package com.androidbatch.navigationdrawer.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidbatch.navigationdrawer.R;

import androidx.fragment.app.Fragment;


public class SliderFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_slider, container, false);

        //gettng data using bundle
        Bundle bundle = this.getArguments();

        //checking if bundle is not null
        if (bundle != null) {
            String val = bundle.getString("key");//getting string data using bundle
            int val_two = bundle.getInt("key_two");//getting int dat using bundle
            Toast.makeText(this.getContext(), "" + val + " " + val_two, Toast.LENGTH_LONG).show();
        }
        return v;
    }
}