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

    private mitemonClick mitemonClick;



    public static class ViewHolder extends RecyclerView.ViewHolder{
        View articleView;
        ImageView articleImage;
        TextView articleTitle;


        public ViewHolder(@NonNull View view) {
            super(view);
            articleView = view;
            articleImage = (ImageView) view.findViewById(R.id.article_image);
            articleTitle = (TextView) view.findViewById(R.id.article_title);

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

//        holder.articleView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                Article article = mArticlelist.get(position);
//                Intent intent = new Intent(context1,WebActivity.class);
//                activity.startActivity(intent);
//
//
//                Toast.makeText(v.getContext(),"click"+article.getTitle(),Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        holder.articleImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                Article article = mArticlelist.get(position);
//
//
//
//                Toast.makeText(v.getContext(),"click"+article.getTitle(),Toast.LENGTH_SHORT).show();
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Article article = mArticlelist.get(position);
        holder.articleImage.setImageResource(article.getImageId());
        holder.articleTitle.setText(article.getTitle());
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



    public interface mitemonClick
    {
        void onitemOnclick(View v,int position);
    }
    public void setItemClickListener(mitemonClick mitemonClick){
        this.mitemonClick=mitemonClick;
    }

}
