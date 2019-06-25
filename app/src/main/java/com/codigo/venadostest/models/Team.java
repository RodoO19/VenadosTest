package com.codigo.venadostest.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Team {

    @SerializedName("forwards")
    private List<Forwards> forwards;

    @SerializedName("centers")
    private List<Forwards> centers;

    @SerializedName("defenses")
    private List<Forwards> defenses;

    @SerializedName("goalkeepers")
    private List<Forwards> goalkeepers;

    @SerializedName("coaches")
    private List<Forwards> coaches;

    public List<Forwards> getForwards() {
        return forwards;
    }

    public void setForwards(List<Forwards> forwards) {
        this.forwards = forwards;
    }

    public List<Forwards> getCenters() {
        return centers;
    }

    public void setCenters(List<Forwards> centers) {
        this.centers = centers;
    }

    public List<Forwards> getDefenses() {
        return defenses;
    }

    public void setDefenses(List<Forwards> defenses) {
        this.defenses = defenses;
    }

    public List<Forwards> getGoalkeepers() {
        return goalkeepers;
    }

    public void setGoalkeepers(List<Forwards> goalkeepers) {
        this.goalkeepers = goalkeepers;
    }

    public List<Forwards> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Forwards> coaches) {
        this.coaches = coaches;
    }

    @Override
    public String toString() {
        return "Team{" +
                "forwards=" + forwards +
                ", centers=" + centers +
                ", defenses=" + defenses +
                ", goalkeepers=" + goalkeepers +
                ", coaches=" + coaches +
                '}';
    }
}
