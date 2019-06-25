package com.codigo.venadostest.models.Data;

public class ForwardsList {

    private String name;

    private String first_surname;

    private String second_surname;

    private String birthday;

    private String birth_place;

    private int weight;

    private Double height;

    private String position;

    private int number;

    private String position_short;

    private String last_team;

    private String image;

    public ForwardsList(String name, String first_surname, String second_surname, String birthday, String birth_place, int weight, Double height, String position, int number, String position_short, String last_team, String image) {
        this.name = name;
        this.first_surname = first_surname;
        this.second_surname = second_surname;
        this.birthday = birthday;
        this.birth_place = birth_place;
        this.weight = weight;
        this.height = height;
        this.position = position;
        this.number = number;
        this.position_short = position_short;
        this.last_team = last_team;
        this.image = image;
    }

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
}
