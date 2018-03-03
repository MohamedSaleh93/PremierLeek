package com.premier.leek.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.like.LikeButton;
import com.premier.leek.R;
import com.premier.leek.model.FixtureDisplayableItem;

import java.util.List;

public class FavoritesListAdapter extends RecyclerView.Adapter<FavoritesListAdapter.FavoritesViewHolder>{

    private Context context;
    private List<FixtureDisplayableItem> fixtureDisplayableItems;

    public FavoritesListAdapter(Context context, List<FixtureDisplayableItem> fixtureDisplayableItems) {
        this.context = context;
        this.fixtureDisplayableItems = fixtureDisplayableItems;
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favorites_list_item, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        final FixtureDisplayableItem currentFixture = fixtureDisplayableItems.get(position);
        if (currentFixture.isDateHeader()) {
            holder.fixturesDateHeader.setVisibility(View.VISIBLE);
            holder.fixturesInFavoritesView.setVisibility(View.GONE);
            holder.fixturesDateHeader.setText(currentFixture.getFixturesDateHeader());
        } else {
            holder.homeTeamName.setText(currentFixture.getHomeTeamName());
            holder.matchResultOrTime.setBackgroundColor(currentFixture.getFixtureStatusBackgroundColor());
            holder.matchResultOrTime.setText(currentFixture.getFixtureStatusText());
            holder.awayTeamName.setText(currentFixture.getAwayTeamName());
        }
    }

    @Override
    public int getItemCount() {
        return fixtureDisplayableItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class FavoritesViewHolder extends RecyclerView.ViewHolder {
        TextView homeTeamName;
        TextView matchResultOrTime;
        TextView awayTeamName;
        TextView fixturesDateHeader;
        View fixturesInFavoritesView;

        FavoritesViewHolder(View view) {
            super(view);
            homeTeamName = (TextView) view.findViewById(R.id.homeTeamName);
            matchResultOrTime = (TextView) view.findViewById(R.id.matchResultOrTime);
            awayTeamName = (TextView) view.findViewById(R.id.awayTeamName);
            fixturesDateHeader = (TextView) view.findViewById(R.id.fixturesDateHeader);
            fixturesInFavoritesView = view.findViewById(R.id.fixturesInFavoritesView);
        }
    }
}
