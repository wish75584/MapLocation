package com.androidbatch.navigationdrawer.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidbatch.navigationdrawer.R;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class GalleryFragment extends Fragment {


    Button btn_gal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);

        btn_gal = v.findViewById(R.id.btn_gal);

        btn_gal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val = "android bundle data";
                int val_two = 10;
                //sending data using bundle bcz we dont use intent in fragments
                Bundle bundle = new Bundle();//defining bundle
                bundle.putString("key", val);//in this first have to set key and then value
                bundle.putInt("key_two",val_two);

                //replasing one fragment from another

                FragmentManager fragmentManager = getFragmentManager();//defining fragment manager
                fragmentManager.beginTransaction()//begin transaction to start navigating from one fragment to another
                        .replace(R.id.nav_host_fragment, SliderFragment.class, bundle)//in this method we have passed id which to where to replace,what to replace,
                        // data(bundle) argument if you want to send any data to another fragment or can keep it null
                        .setReorderingAllowed(true)
                        .addToBackStack(null) // name can be null
                        .commit();
            }
        });

        return v;
    }
}