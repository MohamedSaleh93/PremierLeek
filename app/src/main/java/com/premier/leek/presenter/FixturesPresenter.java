package com.premier.leek.presenter;


import com.premier.leek.model.FixtureDisplayableItem;

import java.util.List;

public interface FixturesPresenter {

    List<FixtureDisplayableItem> loadNextFixtures();
}
