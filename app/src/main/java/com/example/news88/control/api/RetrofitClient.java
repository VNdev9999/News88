package com.example.news88.control.api;

import com.example.news88.util.Constanst;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static TopNewsApi getNewsTop(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constanst.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(TopNewsApi.class);
    }

    public static NewsApi getNews(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constanst.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(NewsApi.class);
    }
}
