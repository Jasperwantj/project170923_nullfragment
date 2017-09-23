package com.example.practice0706drawerlayout2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by 万天娇 on 2017/9/23.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> titileList;
    private ArrayList<Fragment> fragmenArraytList;

    public MyPagerAdapter(FragmentManager fm, ArrayList<String> titleList, ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.titileList = titleList;
        this.fragmenArraytList = fragmentArrayList;
    }

    public Fragment getItem(int position){
        return fragmenArraytList.get(position);
    }

    @Override
    public int getCount() {
        return fragmenArraytList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
    public  CharSequence getPageTitle(int position){
        return titileList.get(position);
    }

}