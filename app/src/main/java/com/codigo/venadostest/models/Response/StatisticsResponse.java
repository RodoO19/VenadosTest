package com.codigo.venadostest.models.Response;

import com.codigo.venadostest.models.Data.DataStatistics;
import com.google.gson.annotations.SerializedName;

public class StatisticsResponse{

	@SerializedName("data")
	private DataStatistics data;

	@SerializedName("success")
	private boolean success;

	public void setData(DataStatistics data){
		this.data = data;
	}

	public DataStatistics getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}
}