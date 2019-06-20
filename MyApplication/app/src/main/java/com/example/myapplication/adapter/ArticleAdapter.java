package com.example.myapplication.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.Article;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>  {

    private List<Article> mArticlelist;
    Context context1;

    private MitemonClick mitemonClick;



    public static class ViewHolder extends RecyclerView.ViewHolder{
        View articleView;
        ImageView articleImage;
        TextView articleTitle;
        TextView articleAuthor;
        TextView articleDate;
        TextView articleRead;


        public ViewHolder(@NonNull View view) {
            super(view);
            articleView = view;
            articleImage = (ImageView) view.findViewById(R.id.article_image);
            articleTitle = (TextView) view.findViewById(R.id.article_title);
            articleAuthor = (TextView) view.findViewById(R.id.article_author);
            articleDate = (TextView) view.findViewById(R.id.article_date);
            articleRead = (TextView) view.findViewById(R.id.article_read);

        }
    }

    public ArticleAdapter(List<Article> articlesList,Context context) {
        mArticlelist = articlesList;
        context1=context;

    }


    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.article_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Article article = mArticlelist.get(position);
        holder.articleImage.setImageResource(article.getImageId());
        holder.articleTitle.setText(article.getTitle());
        holder.articleAuthor.setText(article.getAuthor());
        holder.articleDate.setText(article.getDate());
        holder.articleRead.setText(article.getViews());


        holder.articleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mitemonClick.onitemOnclick(v,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mArticlelist.size();
    }



    public interface MitemonClick
    {
        void onitemOnclick(View v,int position);
    }
    public void setItemClickListener(MitemonClick mitemonClick){
        this.mitemonClick=mitemonClick;
    }

}
