package com.androidbatch.tabbedactivity.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Gallery;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.androidbatch.tabbedactivity.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

//    @SuppressLint("SupportAnnotationUsage")
//    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1 ,R.string.tab_text_2,R.string.tab_text_3};
    private final Context mContext;


    //defining constructor
    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    //getting position of current seleted fragment
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }


    //returning all page title
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString((TAB_TITLES[position]));
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}