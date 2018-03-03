
package com.premier.leek.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FootballDataResponseModel {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("fixtures")
    @Expose
    private List<Fixture> fixtures = null;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<Fixture> fixtures) {
        this.fixtures = fixtures;
    }

}
