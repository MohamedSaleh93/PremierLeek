package com.premier.leek;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.premier.leek.adapter.MainPageAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pagesViewPager = (ViewPager) findViewById(R.id.pagesViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        MainPageAdapter mainPageAdapter = new MainPageAdapter(getSupportFragmentManager(), this);
        pagesViewPager.setAdapter(mainPageAdapter);
        tabLayout.setupWithViewPager(pagesViewPager);
    }
}
