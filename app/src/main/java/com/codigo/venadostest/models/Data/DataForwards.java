package com.codigo.venadostest.models.Data;

import com.codigo.venadostest.models.Team;
import com.google.gson.annotations.SerializedName;

public class DataForwards {

    @SerializedName("code")
    private int code;

    @SerializedName("team")
    private Team team;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "DataForwards{" +
                "code=" + code +
                ", team=" + team +
                '}';
    }
}
