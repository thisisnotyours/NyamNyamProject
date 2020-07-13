package com.suek.nyamnyam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentTab3Article extends Fragment {

    ArrayList<ArticleItem> articleItems= new ArrayList<>();
    ArticleAdapter articleAdapter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.tab3_article_fragment, container, false);

        articleItems.add(new ArticleItem("https://esculapio.pk/wp-content/uploads/2018/07/article-submission.jpg", "5 reasons why Korean food is healthy"));
        articleItems.add(new ArticleItem("https://esculapio.pk/wp-content/uploads/2018/07/article-submission.jpg", "5 reasons why Korean food is healthy"));
        articleItems.add(new ArticleItem("https://esculapio.pk/wp-content/uploads/2018/07/article-submission.jpg", "5 reasons why Korean food is healthy"));
        articleItems.add(new ArticleItem("https://esculapio.pk/wp-content/uploads/2018/07/article-submission.jpg", "5 reasons why Korean food is healthy"));
        articleItems.add(new ArticleItem("https://esculapio.pk/wp-content/uploads/2018/07/article-submission.jpg", "5 reasons why Korean food is healthy"));
        articleItems.add(new ArticleItem("https://esculapio.pk/wp-content/uploads/2018/07/article-submission.jpg", "5 reasons why Korean food is healthy"));
        articleItems.add(new ArticleItem("https://esculapio.pk/wp-content/uploads/2018/07/article-submission.jpg", "5 reasons why Korean food is healthy"));
        articleItems.add(new ArticleItem("https://esculapio.pk/wp-content/uploads/2018/07/article-submission.jpg", "5 reasons why Korean food is healthy"));
        articleItems.add(new ArticleItem("https://esculapio.pk/wp-content/uploads/2018/07/article-submission.jpg", "5 reasons why Korean food is healthy"));
        articleItems.add(new ArticleItem("https://esculapio.pk/wp-content/uploads/2018/07/article-submission.jpg", "5 reasons why Korean food is healthy"));


        recyclerView= view.findViewById(R.id.recycler);
        articleAdapter= new ArticleAdapter(view.getContext(), articleItems);
        recyclerView.setAdapter(articleAdapter);

        return view;
    }
}
