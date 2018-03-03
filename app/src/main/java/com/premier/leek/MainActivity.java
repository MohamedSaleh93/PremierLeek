package com.premier.leek;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.premier.leek.adapter.MainPageAdapter;
import com.premier.leek.fragment.FavoritesFragment;
import com.premier.leek.fragment.FixturesFragment;
import com.premier.leek.model.FixtureDisplayableItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<FixtureDisplayableItem> fixtureDisplayableItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fixtureDisplayableItems = new ArrayList<>();
        ViewPager pagesViewPager = (ViewPager) findViewById(R.id.pagesViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        Fragment tabsFragments[] = new Fragment[] {new FixturesFragment(), new FavoritesFragment()};
        MainPageAdapter mainPageAdapter = new MainPageAdapter(this, getSupportFragmentManager(), tabsFragments);
        pagesViewPager.setAdapter(mainPageAdapter);
        tabLayout.setupWithViewPager(pagesViewPager);
    }
}
