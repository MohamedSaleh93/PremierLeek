package com.premier.leek.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.premier.leek.R;

public class FixturesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    public FixturesListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fixtures_list_item, parent, false);
        return new FixturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class FixturesViewHolder extends RecyclerView.ViewHolder {
        public FixturesViewHolder(View view) {
            super(view);
        }
    }
}
