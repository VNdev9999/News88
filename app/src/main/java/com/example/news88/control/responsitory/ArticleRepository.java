package com.example.news88.control.responsitory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.news88.control.api.retrofit.ApiRequest;
import com.example.news88.control.api.retrofit.RetrofitRequest;
import com.example.news88.model.TopNews;
import com.example.news88.util.Constanst;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<TopNews> getDashBoardNews() {

        final MutableLiveData<TopNews> data = new MutableLiveData<>();
        apiRequest.getTopHeadLines(Constanst.COUNTRY, Constanst.API_KEY)
                .enqueue(new Callback<TopNews>() {
                    @Override
                    public void onResponse(Call<TopNews> call, Response<TopNews> response) {
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<TopNews> call, Throwable t) {
                        data.setValue(null);
                    }
                });

        return data;
    }
}
