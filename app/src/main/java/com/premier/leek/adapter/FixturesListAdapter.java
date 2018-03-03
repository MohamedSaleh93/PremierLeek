package com.premier.leek.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.premier.leek.R;
import com.premier.leek.callback.LikeButtonClickListener;
import com.premier.leek.model.FixtureDisplayableItem;
import com.premier.leek.util.Statics;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FixturesListAdapter extends RecyclerView.Adapter<FixturesListAdapter.FixturesViewHolder>{

    private Context context;
    private List<FixtureDisplayableItem> fixtureDisplayableItems;
    private LikeButtonClickListener likeButtonClickListener;

    public FixturesListAdapter(Context context, List<FixtureDisplayableItem> fixtureDisplayableItems,
                               @NonNull LikeButtonClickListener likeButtonClickListener) {
        this.context = context;
        this.fixtureDisplayableItems = fixtureDisplayableItems;
        this.likeButtonClickListener = likeButtonClickListener;
    }

    @NonNull
    @Override
    public FixturesListAdapter.FixturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fixtures_list_item, parent, false);
        return new FixturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FixturesListAdapter.FixturesViewHolder holder, final int position) {
        FixtureDisplayableItem currentFixture = fixtureDisplayableItems.get(position);
        if (currentFixture.isDateHeader()) {
            holder.fixturesDateHeader.setVisibility(View.VISIBLE);
            holder.fixturesResultView.setVisibility(View.GONE);
            holder.addToFavoritesButton.setVisibility(View.GONE);
            holder.fixturesDateHeader.setText(currentFixture.getFixturesDateHeader());
        } else {
            holder.addToFavoritesButton.setLiked(currentFixture.isAddedToFavorites());
            holder.homeTeamName.setText(currentFixture.getHomeTeamName());
            holder.matchResultOrTime.setBackgroundColor(currentFixture.getFixtureStatusBackgroundColor());
            holder.matchResultOrTime.setText(currentFixture.getFixtureStatusText());
            holder.awayTeamName.setText(currentFixture.getAwayTeamName());

            holder.addToFavoritesButton.setOnLikeListener(new OnLikeListener() {
                @Override
                public void liked(LikeButton likeButton) {
                    likeButtonClickListener.onLikeButtonClicked(position);
                }

                @Override
                public void unLiked(LikeButton likeButton) {
                    likeButtonClickListener.onDislikeButtonClicked(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return fixtureDisplayableItems.size();
    }

    class FixturesViewHolder extends RecyclerView.ViewHolder {
        LikeButton addToFavoritesButton;
        TextView homeTeamName;
        TextView matchResultOrTime;
        TextView awayTeamName;
        TextView fixturesDateHeader;
        View fixturesResultView;

        FixturesViewHolder(View view) {
            super(view);
            addToFavoritesButton = (LikeButton) view.findViewById(R.id.addFixtureToFavoriteButton);
            homeTeamName = (TextView) view.findViewById(R.id.homeTeamName);
            matchResultOrTime = (TextView) view.findViewById(R.id.matchResultOrTime);
            awayTeamName = (TextView) view.findViewById(R.id.awayTeamName);
            fixturesDateHeader = (TextView) view.findViewById(R.id.fixturesDateHeader);
            fixturesResultView = view.findViewById(R.id.fixtureResultView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
