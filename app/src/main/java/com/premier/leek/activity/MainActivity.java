package com.premier.leek.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.premier.leek.R;
import com.premier.leek.adapter.MainPageAdapter;
import com.premier.leek.callback.FixturesListRefreshedListener;
import com.premier.leek.callback.LikeButtonClickListener;
import com.premier.leek.fragment.FavoritesFragment;
import com.premier.leek.fragment.FixturesFragment;
import com.premier.leek.model.FixtureDisplayableItem;
import com.premier.leek.util.Statics;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LikeButtonClickListener, FixturesListRefreshedListener{

    public List<FixtureDisplayableItem> fixtureDisplayableItems;
    FavoritesFragment favoritesFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fixtureDisplayableItems = new ArrayList<>();
        ViewPager pagesViewPager = (ViewPager) findViewById(R.id.pagesViewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        favoritesFragment = new FavoritesFragment();
        FixturesFragment fixturesFragment = new FixturesFragment();
        fixturesFragment.registerLikeButtonListener(this);
        fixturesFragment.registerFixtureListRefreshListener(this);
        Fragment tabsFragments[] = new Fragment[] {fixturesFragment, favoritesFragment};
        MainPageAdapter mainPageAdapter = new MainPageAdapter(this, getSupportFragmentManager(), tabsFragments);
        pagesViewPager.setAdapter(mainPageAdapter);
        tabLayout.setupWithViewPager(pagesViewPager);
    }

    @Override
    public void onLikeButtonClicked(FixtureDisplayableItem displayableItem) {
        favoritesFragment.addFavoriteFixture(displayableItem);
    }

    @Override
    public void onDislikeButtonClicked(FixtureDisplayableItem displayableItem) {
        favoritesFragment.removeFavoriteFixture(displayableItem);
    }

    @Override
    public void onFixturesListRefreshed() {
        favoritesFragment.removeAllFavoriteFixtures();
    }
}
