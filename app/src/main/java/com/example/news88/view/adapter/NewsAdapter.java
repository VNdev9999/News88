package com.example.news88.view.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.news88.R;
import com.example.news88.databinding.ItemNewsBinding;
import com.example.news88.model.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<Article> mListNews;

    public void setListNews(List<Article> mListNews) {
        this.mListNews = mListNews;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new NewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Article article = mListNews.get(position);
        if (mListNews == null) {
            return;
        }
        Glide.with(holder.itemView.getContext())
                .load(article.getUrlToImage())
                .into(holder.binding.imgNews);
        holder.binding.tvNews.setText(article.getTitle());

        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("topnew", article);
            Navigation.findNavController(holder.itemView).navigate(R.id.action_mainFragment_to_detailFragment, bundle);

        });
    }

    @Override
    public int getItemCount() {
        if (mListNews != null) {
            return mListNews.size();
        }
        return 0;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        private ItemNewsBinding binding;

        public NewsViewHolder(@NonNull ItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
