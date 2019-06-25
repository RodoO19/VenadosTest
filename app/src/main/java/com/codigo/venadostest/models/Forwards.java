package com.codigo.venadostest.models;

import com.google.gson.annotations.SerializedName;

public class Forwards {

    @SerializedName("name")
    private String name;

    @SerializedName("first_surname")
    private String first_surname;

    @SerializedName("second_surname")
    private String second_surname;

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("birth_place")
    private String birth_place;

    @SerializedName("weight")
    private int weight;

    @SerializedName("height")
    private Double height;

    @SerializedName("position")
    private String position;

    @SerializedName("number")
    private int number;

    @SerializedName("position_short")
    private String position_short;

    @SerializedName("last_team")
    private String last_team;

    @SerializedName("image")
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_surname() {
        return first_surname;
    }

    public void setFirst_surname(String first_surname) {
        this.first_surname = first_surname;
    }

    public String getSecond_surname() {
        return second_surname;
    }

    public void setSecond_surname(String second_surname) {
        this.second_surname = second_surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition_short() {
        return position_short;
    }

    public void setPosition_short(String position_short) {
        this.position_short = position_short;
    }

    public String getLast_team() {
        return last_team;
    }

    public void setLast_team(String last_team) {
        this.last_team = last_team;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Forwards{" +
                "name='" + name + '\'' +
                ", first_surname='" + first_surname + '\'' +
                ", second_surname='" + second_surname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", birth_place='" + birth_place + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", position='" + position + '\'' +
                ", number=" + number +
                ", position_short='" + position_short + '\'' +
                ", last_team='" + last_team + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
