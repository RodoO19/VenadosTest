package com.codigo.venadostest.models.Response;

import com.codigo.venadostest.models.Data.DataGames;
import com.google.gson.annotations.SerializedName;

public class GamesResponse{

	@SerializedName("data")
	private DataGames data;

	@SerializedName("success")
	private boolean success;

	public void setData(DataGames data){
		this.data = data;
	}

	public DataGames getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}
}