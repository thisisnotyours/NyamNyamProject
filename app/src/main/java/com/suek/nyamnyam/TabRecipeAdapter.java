package com.suek.nyamnyam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabRecipeAdapter extends FragmentPagerAdapter {
    Fragment[] fragments= new Fragment[2];



    public TabRecipeAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments[0]= new FragmentTabHowtoCook();
        fragments[1]= new FragmentTabYoutube();
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


}
