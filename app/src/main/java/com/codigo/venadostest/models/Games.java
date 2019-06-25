package com.codigo.venadostest.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Games {

	@SerializedName("opponent_image")
	private String opponent_image;

	@SerializedName("image")
	private String image;

	@SerializedName("datetime")
	private String datetime;

	@SerializedName("home_score")
	private int home_score;

	@SerializedName("away_score")
	private int away_score;

	@SerializedName("opponent")
	private String opponent;

	@SerializedName("league")
	private String league;

	@SerializedName("local")
	private boolean local;

	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setOpponent_image(String opponentImage){
		this.opponent_image = opponentImage;
	}

	public String getOpponent_image(){
		return opponent_image;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setDatetime(String datetime){
		this.datetime = datetime;
	}

	public String getDatetime(){
		return datetime;
	}

	public void setHome_score(int home_score){
		this.home_score = home_score;
	}

	public int getHome_score(){
		return home_score;
	}

	public void setAway_score(int away_score){
		this.away_score = away_score;
	}

	public int getAway_score(){
		return away_score;
	}

	public void setOpponent(String opponent){
		this.opponent = opponent;
	}

	public String getOpponent(){
		return opponent;
	}

	public void setLeague(String league){
		this.league = league;
	}

	public String getLeague(){
		return league;
	}

	public void setLocal(boolean local){
		this.local = local;
	}

	public boolean isLocal(){
		return local;
	}



}