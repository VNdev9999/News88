package com.example.news88.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.news88.R;
import com.example.news88.databinding.FragmentDetailBinding;
import com.example.news88.model.Article;

public class DetailFragment extends Fragment {


    private Article article;
    private FragmentDetailBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (article == null) {
            article = (Article) getArguments().getSerializable("topnew");
            Glide.with(getActivity())
                    .load(article.getUrlToImage())
                    .into(binding.imgDetail);
            binding.tvTittleDetail.setText(article.getTitle());
            binding.tvAuthorDetail.setText(article.getAuthor());
            binding.tvDescriptionDetail.setText(article.getDescription());
            binding.tvPublishedDetail.setText(article.getPublishedAt());
            binding.tvContentDetail.setText(article.getContent());
        }
//        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

    }

}