package com.premier.leek.network;

import com.premier.leek.model.FootballDataResponseModel;

import java.util.List;

public interface FixturesProvider {

    FootballDataResponseModel loadNextFixtures();

    String getTeamImageIcon(String teamUrl);
}
