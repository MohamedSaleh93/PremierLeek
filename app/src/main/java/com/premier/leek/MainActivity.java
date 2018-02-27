package com.premier.leek;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.premier.leek.adapter.FixturesPageAdapter;
import com.premier.leek.fragment.FavoritesFragment;
import com.premier.leek.fragment.FixturesFragment;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pagesViewPager = (ViewPager) findViewById(R.id.pagesViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        FixturesPageAdapter fixturesPageAdapter = new FixturesPageAdapter(getSupportFragmentManager(), this);
        pagesViewPager.setAdapter(fixturesPageAdapter);
        tabLayout.setupWithViewPager(pagesViewPager);
    }
}
