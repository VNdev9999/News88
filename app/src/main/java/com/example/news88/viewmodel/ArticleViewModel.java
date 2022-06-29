package com.example.news88.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.news88.control.responsitory.ArticleRepository;
import com.example.news88.model.TopNews;

public class ArticleViewModel extends AndroidViewModel {
    private ArticleRepository articleRepository;
    private LiveData<TopNews> articleLiveData ;


    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleLiveData = articleRepository.getDashBoardNews();
    }

    public LiveData<TopNews> getNewsLiveData(){

        return articleLiveData;
    }
}
