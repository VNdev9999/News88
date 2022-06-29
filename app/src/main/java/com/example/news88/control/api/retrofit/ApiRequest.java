package com.example.news88.control.api.retrofit;

import com.example.news88.model.TopNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("v2/top-headlines")
    Call<TopNews> getTopHeadLines(@Query("country")String country,
                                  @Query("apiKey")String apiKey);

}
