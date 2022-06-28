package com.example.news88.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.news88.model.Article;

public class NewsViewModel extends ViewModel {
    private MutableLiveData<String> selected = new MutableLiveData<>();

    public void setData(Article article){

        selected.setValue(article.getTitle());
    }
}
