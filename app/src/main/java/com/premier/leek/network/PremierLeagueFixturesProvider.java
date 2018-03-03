package com.premier.leek.network;


import android.util.Log;

import com.premier.leek.model.FootballDataResponseModel;
import com.premier.leek.model.TeamsModel;
import com.premier.leek.util.Statics;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class PremierLeagueFixturesProvider implements FixturesProvider{

    private final static String TIME_FRAME = "n20";
    public static final String FOOT_BALL_URL = "http://api.football-data.org/v1/";

    @Override
    public FootballDataResponseModel loadNextFixtures() {
        FootballDataResponseModel dataResult = null;
        try {
            ApiInterface apiService = ApiClient.getClient(FOOT_BALL_URL).create(ApiInterface.class);
            Call<FootballDataResponseModel> fixturesCall = apiService.getPremierLeagueNextFixtures(TIME_FRAME);
            Response<FootballDataResponseModel> callResponse = fixturesCall.execute();
            if (callResponse.isSuccessful()) {
                dataResult = callResponse.body();
            } else {
                Log.e(Statics.LOG_TAG, "Failed to load fixtures : " + callResponse.errorBody().string());
            }
        } catch (IOException ioException) {
            Log.e(Statics.LOG_TAG, "Exception in loading fixtures : " + ioException.getMessage());
        }
        return dataResult;
    }
}
