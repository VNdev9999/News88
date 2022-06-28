package com.example.news88.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.news88.R;
import com.example.news88.model.Article;
import com.example.news88.viewmodel.SharedViewModel;

public class DetailFragment extends Fragment {

    private SharedViewModel sharedViewModel;
    private Article article;
    private ImageView imgDetail;
    private TextView tvTittleDetail;
    private TextView tvAuthorDetail;
    private TextView tvDescriptionDetail;
    private TextView tvPublishedDetail;
    private TextView tvContentDetail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);


        imgDetail = (ImageView) view.findViewById(R.id.img_detail);
        tvTittleDetail = (TextView) view.findViewById(R.id.tv_tittle_detail);
        tvAuthorDetail = (TextView) view.findViewById(R.id.tv_author_detail);
        tvDescriptionDetail = (TextView) view.findViewById(R.id.tv_description_detail);
        tvPublishedDetail = (TextView) view.findViewById(R.id.tv_published_detail);
        tvContentDetail = (TextView) view.findViewById(R.id.tv_content_detail);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (article == null) {
            article = (Article) getArguments().getSerializable("topnew");
            Glide.with(getActivity())
                    .load(article.getUrlToImage())
                    .into(imgDetail);
            tvTittleDetail.setText(article.getTitle());
            tvAuthorDetail.setText(article.getAuthor());
            tvDescriptionDetail.setText(article.getDescription());
            tvPublishedDetail.setText(article.getPublishedAt());
            tvContentDetail.setText(article.getContent());
        }
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

    }

}