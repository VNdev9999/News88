package com.example.news88.view.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.news88.R;
import com.example.news88.databinding.ItemTopNewsBinding;
import com.example.news88.model.Article;

import java.util.List;

public class TopNewsAdapter extends RecyclerView.Adapter<TopNewsAdapter.TopNewsViewHolder> {
    private List<Article> mListTopNews;


    public void setmListTopNews(List<Article> mListTopNews) {
        this.mListTopNews = mListTopNews;
    }


    @NonNull
    @Override
    public TopNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTopNewsBinding binding = ItemTopNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TopNewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TopNewsViewHolder holder, int position) {
        Article article = mListTopNews.get(position);
        if (mListTopNews == null) {
            return;
        }
        Glide.with(holder.itemView.getContext())
                .load(article.getUrlToImage())
                .into(holder.binding.imgTopNews);
        holder.binding.tvTopNews.setText(article.getTitle());
        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("topnew", article);
            Navigation.findNavController(holder.itemView).navigate(R.id.action_mainFragment_to_detailFragment, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return mListTopNews == null ? 0 : mListTopNews.size();
    }

    public class TopNewsViewHolder extends RecyclerView.ViewHolder {
        private ItemTopNewsBinding binding;

        public TopNewsViewHolder(@NonNull ItemTopNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
