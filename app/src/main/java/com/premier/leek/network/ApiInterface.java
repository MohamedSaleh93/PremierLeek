package com.premier.leek.network;

import com.premier.leek.model.FootballDataResponseModel;
import com.premier.leek.model.TeamsModel;
import com.premier.leek.util.Statics;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("X-Auth-Token: " + Statics.FOOT_BALL_DATA_API_TOKEN)
    @GET("competitions/445/fixtures")
    Call<FootballDataResponseModel> getPremierLeagueNextFixtures(@Query("timeFrame") String timeFrame);

    @Headers("X-Auth-Token: " + Statics.FOOT_BALL_DATA_API_TOKEN)
    @GET("{teamUrl}")
    Call<TeamsModel> getPremierLeagueTeamIcon(@Path("teamUrl") String teamUrl);
}
