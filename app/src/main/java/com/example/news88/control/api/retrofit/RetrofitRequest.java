package com.example.news88.control.api.retrofit;

import com.example.news88.util.Constanst;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {
    private static Retrofit retrofit;
    public  static Retrofit getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constanst.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return  retrofit;
    }
}
