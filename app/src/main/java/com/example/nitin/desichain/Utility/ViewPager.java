package com.example.nitin.desichain.Utility;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by NITIN on 13-Jun-17.
 */

public class ViewPager extends FragmentPagerAdapter {

    private final ArrayList<Fragment> mFragmentList=new ArrayList<>();
    private final ArrayList<String> mFragmentTileList=new ArrayList<>();

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTileList.get(position);
    }

    public ViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment,String title){
        mFragmentList.add(fragment);
        mFragmentTileList.add(title);
    }

}
