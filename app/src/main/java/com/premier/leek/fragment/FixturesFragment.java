package com.premier.leek.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.premier.leek.MainActivity;
import com.premier.leek.R;
import com.premier.leek.adapter.FixturesListAdapter;
import com.premier.leek.callback.LikeButtonClickListener;
import com.premier.leek.model.FixtureDisplayableItem;
import com.premier.leek.presenter.FixturesPresenter;
import com.premier.leek.presenter.FixturesPresenterImpl;
import com.premier.leek.util.Utilities;

import java.util.List;

public class FixturesFragment extends Fragment implements LikeButtonClickListener{

    private RecyclerView fixturesView;
    private ProgressBar loadingFixturesProgressBar;
    private TextView noFixturesDisclaimer;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<FixtureDisplayableItem> fixtureDisplayableItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fixture, null);
        loadingFixturesProgressBar = (ProgressBar) view.findViewById(R.id.loadingFixturesProgress);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshFixturesLayout);
        fixturesView = (RecyclerView) view.findViewById(R.id.fixturesRecyclerView);
        noFixturesDisclaimer = (TextView) view.findViewById(R.id.noFixturesDisclaimer);
        if (Utilities.checkForInternetConnection(getContext())) {
            new LoadFixturesAsyncTask().execute();
        } else {
            loadingFixturesProgressBar.setVisibility(View.GONE);
            noFixturesDisclaimer.setVisibility(View.VISIBLE);
            noFixturesDisclaimer.setText(R.string.no_internet_connection);
        }
        return view;
    }

    private class LoadFixturesAsyncTask extends AsyncTask<Void, Void, List<FixtureDisplayableItem>> {

        @Override
        protected List<FixtureDisplayableItem> doInBackground(Void... voids) {
            FixturesPresenter fixturesPresenter = new FixturesPresenterImpl(getContext());
            fixtureDisplayableItems = fixturesPresenter.loadNextFixtures();
            return fixtureDisplayableItems;
        }

        @Override
        protected void onPostExecute(List<FixtureDisplayableItem> fixturesList) {
            super.onPostExecute(fixturesList);
            FixturesListAdapter fixturesListAdapter = new FixturesListAdapter(getContext(), fixturesList, FixturesFragment.this);
            fixturesView.setAdapter(fixturesListAdapter);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
            fixturesView.setLayoutManager(layoutManager);
            fixturesView.setItemAnimator(new DefaultItemAnimator());
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(fixturesView.getContext(),
                    LinearLayoutManager.VERTICAL);
            fixturesView.addItemDecoration(dividerItemDecoration);
            loadingFixturesProgressBar.setVisibility(View.GONE);
            if (fixturesList.size() > 0) {
                swipeRefreshLayout.setVisibility(View.VISIBLE);
                noFixturesDisclaimer.setVisibility(View.GONE);
            } else {
                noFixturesDisclaimer.setVisibility(View.VISIBLE);
                noFixturesDisclaimer.setText(R.string.no_fixtures);
            }
        }
    }

    @Override
    public void onLikeButtonClicked(int itemPosition) {
        ((MainActivity)getActivity()).fixtureDisplayableItems.add(fixtureDisplayableItems.get(itemPosition));
    }

    @Override
    public void onDislikeButtonClicked(int itemPosition) {
        ((MainActivity)getActivity()).fixtureDisplayableItems.remove(fixtureDisplayableItems.get(itemPosition));
    }
}
