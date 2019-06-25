package com.codigo.venadostest.models.Data;

import com.codigo.venadostest.models.Games;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataGames {
    @SerializedName("code")
    private int code;

    @SerializedName("games")
    private List<Games> games;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Games> getGames() {
        return games;
    }

    public void setGames(List<Games> games) {
        this.games = games;
    }
}
