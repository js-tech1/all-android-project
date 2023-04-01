package com.example.mytablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewpageAdepter extends FragmentPagerAdapter {
    public ViewpageAdepter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        {
            return new BlankFragment();
        }
        else if (position == 1)
        {
            return new BlankFragment2();
        }
        else
        {
            return new BlankFragment3();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Chat";
        }
        else if (position == 1)
        {
            return  "Status";
        }else
        {
            return  "Calls";
        }
    }
}
