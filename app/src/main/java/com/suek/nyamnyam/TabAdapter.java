package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    Fragment[] fragments= new Fragment[4];
    String[] tabTexts= new String[]{"FOOD","TREND","ARTICLE","COUPON"};


    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragments[0]= new FragmentTab1Food();
        fragments[1]= new FragmentTab2Trend();
        fragments[2]= new FragmentTab3Article();
        fragments[3]= new FragmentTab4Coupon();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTexts[position];
    }
}
