package com.premier.leek.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamsModel {

    @SerializedName("crestUrl")
    @Expose
    private String iconUrl;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
