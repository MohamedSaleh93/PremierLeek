package com.premier.leek.callback;

import com.premier.leek.model.FixtureDisplayableItem;

import java.io.Serializable;

public interface LikeButtonClickListener extends Serializable{

    void onLikeButtonClicked(FixtureDisplayableItem displayableItem);
    void onDislikeButtonClicked(FixtureDisplayableItem displayableItem);
}
