package com.premier.leek.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.premier.leek.R;
import com.premier.leek.adapter.FavoritesListAdapter;
import com.premier.leek.model.FixtureDisplayableItem;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment{

    private List<FixtureDisplayableItem> fixtureDisplayableItems;
    private TextView noFavoritesText;
    private RecyclerView favoritesRecyclerView;
    private ProgressBar loadFavoritesProgress;
    private FavoritesListAdapter favoritesListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, null);
        fixtureDisplayableItems = new ArrayList<>();
        noFavoritesText = (TextView) view.findViewById(R.id.noFavoritesText);
        favoritesRecyclerView = (RecyclerView) view.findViewById(R.id.favoritesRecyclerView);
        loadFavoritesProgress = (ProgressBar) view.findViewById(R.id.loadingFavoritesProgress);
        favoritesListAdapter = new FavoritesListAdapter(getContext(), fixtureDisplayableItems);
        favoritesRecyclerView.setAdapter(favoritesListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        favoritesRecyclerView.setLayoutManager(layoutManager);
        favoritesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(favoritesRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        favoritesRecyclerView.addItemDecoration(dividerItemDecoration);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            loadFavoritesProgress.setVisibility(View.GONE);
            favoritesListAdapter.notifyDataSetChanged();
            if (fixtureDisplayableItems.size() > 0) {
                noFavoritesText.setVisibility(View.GONE);
                favoritesRecyclerView.setVisibility(View.VISIBLE);
            } else {
                noFavoritesText.setVisibility(View.VISIBLE);
            }
        }
    }

    public void addFavoriteFixture(FixtureDisplayableItem favoriteFixture) {
        fixtureDisplayableItems.add(favoriteFixture);
    }

    public void removeFavoriteFixture(FixtureDisplayableItem favoriteFixture) {
        fixtureDisplayableItems.remove(favoriteFixture);
    }
}
