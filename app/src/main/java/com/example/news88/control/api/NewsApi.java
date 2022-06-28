package com.example.news88.control.api;

import com.example.news88.model.TopNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// https://newsapi.org/v2/everything?q=bitcoin&apiKey=83450e3faab644c7889212bf1353adce

public interface NewsApi {
    @GET("/v2/everything")
    Call<TopNews> callNews(@Query("q")String q,
                           @Query("apiKey")String apiKey);
}
