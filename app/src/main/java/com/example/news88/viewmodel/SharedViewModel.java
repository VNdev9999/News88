package com.example.news88.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.news88.model.Article;

public class SharedViewModel extends ViewModel {

    private static final String Tag = "sharedViewModel";
    //    private MutableLiveData<List<Article>> mutableArticleList = new MutableLiveData<>();
    private MutableLiveData<Article> selected = new MutableLiveData<>();

    public void setSelected(Article article) {
        selected.setValue(article);
    }

    public MutableLiveData<Article> getSelected() {
        return selected;
    }
}
