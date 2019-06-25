package com.codigo.venadostest.models;

import com.google.gson.annotations.SerializedName;

public class Statistics{

	@SerializedName("f_goals")
	private int f_goals;

	@SerializedName("efec")
	private Object efec;

	@SerializedName("image")
	private String image;

	@SerializedName("loss")
	private int loss;

	@SerializedName("tie")
	private int tie;

	@SerializedName("score_diff")
	private int score_diff;

	@SerializedName("games")
	private int games;

	@SerializedName("a_goals")
	private int a_goals;

	@SerializedName("position")
	private int position;

	@SerializedName("team")
	private String team;

	@SerializedName("win")
	private int win;

	@SerializedName("points")
	private int points;

	public void setF_goals(int f_goals){
		this.f_goals = f_goals;
	}

	public int getF_goals(){
		return f_goals;
	}

	public void setEfec(Object efec){
		this.efec = efec;
	}

	public Object getEfec(){
		return efec;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setLoss(int loss){
		this.loss = loss;
	}

	public int getLoss(){
		return loss;
	}

	public void setTie(int tie){
		this.tie = tie;
	}

	public int getTie(){
		return tie;
	}

	public void setScore_diff(int score_diff){
		this.score_diff = score_diff;
	}

	public int getScore_diff(){
		return score_diff;
	}

	public void setGames(int games){
		this.games = games;
	}

	public int getGames(){
		return games;
	}

	public void setA_goals(int a_goals){
		this.a_goals = a_goals;
	}

	public int getA_goals(){
		return a_goals;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public int getPosition(){
		return position;
	}

	public void setTeam(String team){
		this.team = team;
	}

	public String getTeam(){
		return team;
	}

	public void setWin(int win){
		this.win = win;
	}

	public int getWin(){
		return win;
	}

	public void setPoints(int points){
		this.points = points;
	}

	public int getPoints(){
		return points;
	}
}