package com.premier.leek.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.premier.leek.R;
import com.premier.leek.fragment.FavoritesFragment;
import com.premier.leek.fragment.FixturesFragment;

public class MainPageAdapter extends FragmentPagerAdapter {

    private Context context;
    private Fragment tabsFragments[];

    public MainPageAdapter(Context context, FragmentManager fm,  Fragment tabsFragments[]) {
        super(fm);
        this.context = context;
        this.tabsFragments = tabsFragments;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return tabsFragments[0];
            case 1:
                return tabsFragments[1];
            default:
                return tabsFragments[0];
        }
    }

    @Override
    public int getCount() {
        return tabsFragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.fixtures);
            case 1:
                return context.getString(R.string.favorites);
            default:
                return context.getString(R.string.fixtures);
        }
    }
}
