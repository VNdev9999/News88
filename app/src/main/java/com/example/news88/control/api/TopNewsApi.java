package com.example.news88.control.api;

import com.example.news88.model.TopNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TopNewsApi {

    @GET("v2/top-headlines")
    Call<TopNews> callTopNews(@Query("country")String country,
                              @Query("apiKey")String apiKey);
}
