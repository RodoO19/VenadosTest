package com.codigo.venadostest.Interface;

import com.codigo.venadostest.models.Response.ForwardsResponse;
import com.codigo.venadostest.models.Response.GamesResponse;
import com.codigo.venadostest.models.Response.StatisticsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface Service {

    @Headers("Accept:application/json")
    @GET("games")
    Call<GamesResponse> getGames();

    @Headers("Accept:application/json")
    @GET("statistics")
    Call<StatisticsResponse> getStatistics();

    @Headers("Accept:application/json")
    @GET("players")
    Call<ForwardsResponse> getForwards();

}

