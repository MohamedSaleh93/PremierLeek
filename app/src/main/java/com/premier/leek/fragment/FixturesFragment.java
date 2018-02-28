package com.premier.leek.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.premier.leek.R;
import com.premier.leek.adapter.FixturesListAdapter;

public class FixturesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixture, null);
        final ProgressBar loadingFixturesProgressBar = (ProgressBar) view.findViewById(R.id.loadingFixturesProgress);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshFixturesLayout);
        final RecyclerView fixturesView = (RecyclerView) view.findViewById(R.id.fixturesRecyclerView);
        fixturesView.setVisibility(View.GONE);
        loadingFixturesProgressBar.setVisibility(View.VISIBLE);
        FixturesListAdapter fixturesListAdapter = new FixturesListAdapter(getContext());
        fixturesView.setAdapter(fixturesListAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        fixturesView.setLayoutManager(mLayoutManager);
        fixturesView.setItemAnimator(new DefaultItemAnimator());
        fixturesView.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingFixturesProgressBar.setVisibility(View.GONE);
                fixturesView.setVisibility(View.VISIBLE);
            }
        }, 2000);
        return view;
    }
}
