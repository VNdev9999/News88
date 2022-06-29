package com.example.news88.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news88.R;
import com.example.news88.control.api.RetrofitClient;
import com.example.news88.databinding.FragmentMainBinding;
import com.example.news88.model.Article;
import com.example.news88.model.TopNews;
import com.example.news88.util.Constanst;
import com.example.news88.view.adapter.NewsAdapter;
import com.example.news88.view.adapter.TopNewsAdapter;
import com.example.news88.viewmodel.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {

    private RecyclerView rcvTopNews, rcvEveryNews;
    private TopNewsAdapter topNewsAdapter;
    private NewsAdapter newsAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<Article> mListTopNews = new ArrayList<Article>();
    private ArticleViewModel articleViewModel;
    private FragmentMainBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        articleViewModel = new ViewModelProvider(this).get(ArticleViewModel.class);

        fetchTopNews();
        fetchNews();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        topNewsAdapter = new TopNewsAdapter();


    }

    public void fetchTopNews() {
        articleViewModel.getNewsLiveData().observe(getActivity(), articleRespone -> {
            if (articleRespone != null && articleRespone.getArticles() != null && !articleRespone.getArticles().isEmpty()) {

                List<Article> articleList = articleRespone.getArticles();
                mListTopNews.addAll(articleList);
                topNewsAdapter.setmListTopNews(mListTopNews);
                topNewsAdapter.notifyDataSetChanged();

                linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                binding.rcvTopNews.setLayoutManager(linearLayoutManager);
                binding.rcvTopNews.setAdapter(topNewsAdapter);
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        fetchTopNews();
        fetchNews();
    }

    public void fetchNews() {
        newsAdapter = new NewsAdapter();
        RetrofitClient.getNews().callNews(Constanst.Q, Constanst.API_KEY).enqueue(new Callback<TopNews>() {
            @Override
            public void onResponse(Call<TopNews> call, Response<TopNews> response) {
                Log.e("HuyZinkeng", "onResponse: " + response.body());
                newsAdapter.setListNews(response.body().getArticles());
                linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                binding.rcvEveryNews.setLayoutManager(linearLayoutManager);
                binding.rcvEveryNews.setAdapter(newsAdapter);
            }

            @Override
            public void onFailure(Call<TopNews> call, Throwable t) {
                Log.e("HuyZinkeng", "onFailure: ");
            }
        });

    }
}