package com.codigo.venadostest.models.Data;

import com.codigo.venadostest.models.Statistics;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataStatistics {

    @SerializedName("code")
    private int code;

    @SerializedName("statistics")
    private List<Statistics> statistics;

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setStatistics(List<Statistics> statistics){
        this.statistics = statistics;
    }

    public List<Statistics> getStatistics(){
        return statistics;
    }
}
