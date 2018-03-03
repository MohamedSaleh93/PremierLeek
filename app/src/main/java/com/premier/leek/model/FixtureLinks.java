
package com.premier.leek.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FixtureLinks {

    @SerializedName("self")
    @Expose
    private FixtureIdLink fixtureIdLink;
    @SerializedName("homeTeam")
    @Expose
    private HomeTeamLink homeTeamLink;
    @SerializedName("awayTeam")
    @Expose
    private AwayTeamLink awayTeamLink;

    public FixtureIdLink geFixtureIdLink() {
        return fixtureIdLink;
    }

    public void setFixtureIdLink(FixtureIdLink self) {
        this.fixtureIdLink = self;
    }

    public HomeTeamLink getHomeTeam() {
        return homeTeamLink;
    }

    public void setHomeTeam(HomeTeamLink homeTeam) {
        this.homeTeamLink = homeTeam;
    }

    public AwayTeamLink getAwayTeam() {
        return awayTeamLink;
    }

    public void setAwayTeam(AwayTeamLink awayTeam) {
        this.awayTeamLink = awayTeam;
    }

}
