package com.premier.leek.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.premier.leek.R;
import com.premier.leek.fragment.FavoritesFragment;
import com.premier.leek.fragment.FixturesFragment;

public class FixturesPageAdapter extends FragmentPagerAdapter {

    private Context context;

    public FixturesPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FixturesFragment();
            case 1:
                return new FavoritesFragment();
            default:
                return new FixturesFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
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
