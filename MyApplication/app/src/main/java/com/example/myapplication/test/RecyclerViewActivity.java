package com.example.myapplication.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ArticleAdapter;
import com.example.myapplication.bean.Article;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Article> articlesList = new ArrayList<>();
private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
//        初始化文章数据
        initArticle();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArticleAdapter adapter = new ArticleAdapter(articlesList,context);
        recyclerView.setAdapter(adapter);
    }

    public void initArticle() {
        for (int i=0;i<2;i++) {
            Article article1 = new Article("a1",R.drawable.b1);
            articlesList.add(article1);
            Article article2 = new Article("a1",R.drawable.b1);
            articlesList.add(article2);
            Article article3 = new Article("a1",R.drawable.b1);
            articlesList.add(article3);
            Article article4 = new Article("a1",R.drawable.b1);
            articlesList.add(article4);
            Article article5 = new Article("a1",R.drawable.b1);
            articlesList.add(article5);
            Article article6 = new Article("a1",R.drawable.b1);
            articlesList.add(article6);
            Article article7 = new Article("a1",R.drawable.b1);
            articlesList.add(article7);
            Article article8 = new Article("a1",R.drawable.b1);
            articlesList.add(article8);
            Article article9 = new Article("a1",R.drawable.b1);
            articlesList.add(article9);
            Article article10 = new Article("a1",R.drawable.b1);
            articlesList.add(article10);

        }
    }
}
