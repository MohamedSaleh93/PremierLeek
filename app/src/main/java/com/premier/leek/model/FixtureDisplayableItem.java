package com.premier.leek.model;

public class FixtureDisplayableItem {

    private String homeTeamName;
    private String homeTeamIconUrl;
    private int fixtureStatusBackgroundColor;
    private String fixtureStatusText;
    private String awayTeamName;
    private String awayTeamIconUrl;
    private boolean isAddedToFavorites;
    private String fixturesDateHeader;
    private boolean isDateHeader = false;
    private String fixtureId;

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getHomeTeamIconUrl() {
        return homeTeamIconUrl;
    }

    public void setHomeTeamIconUrl(String homeTeamIconUrl) {
        this.homeTeamIconUrl = homeTeamIconUrl;
    }

    public int getFixtureStatusBackgroundColor() {
        return fixtureStatusBackgroundColor;
    }

    public void setFixtureStatusBackgroundColor(int fixtureStatusBackgroundColor) {
        this.fixtureStatusBackgroundColor = fixtureStatusBackgroundColor;
    }

    public String getFixtureStatusText() {
        return fixtureStatusText;
    }

    public void setFixtureStatusText(String fixtureStatusText) {
        this.fixtureStatusText = fixtureStatusText;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getAwayTeamIconUrl() {
        return awayTeamIconUrl;
    }

    public void setAwayTeamIconUrl(String awayTeamIconUrl) {
        this.awayTeamIconUrl = awayTeamIconUrl;
    }

    public boolean isAddedToFavorites() {
        return isAddedToFavorites;
    }

    public void setAddedToFavorites(boolean addedToFavorites) {
        isAddedToFavorites = addedToFavorites;
    }

    public String getFixturesDateHeader() {
        return fixturesDateHeader;
    }

    public void setFixturesDateHeader(String fixturesDateHeader) {
        this.fixturesDateHeader = fixturesDateHeader;
    }

    public boolean isDateHeader() {
        return isDateHeader;
    }

    public void setDateHeader(boolean dateHeader) {
        isDateHeader = dateHeader;
    }

    public String getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(String fixtureId) {
        this.fixtureId = fixtureId;
    }
}
