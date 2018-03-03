package com.premier.leek.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.premier.leek.MainActivity;
import com.premier.leek.R;

public class FavoritesFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, null);
        TextView noFavoritesText = (TextView) view.findViewById(R.id.noFavoritesText);
        RecyclerView favoritesRecyclerView = (RecyclerView) view.findViewById(R.id.favoritesRecyclerView);
        noFavoritesText.setVisibility(View.VISIBLE);
        favoritesRecyclerView.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Toast.makeText(getContext(), "Size is : " + ((MainActivity)getActivity()).fixtureDisplayableItems.size(), Toast.LENGTH_LONG).show();
        }
    }
}
