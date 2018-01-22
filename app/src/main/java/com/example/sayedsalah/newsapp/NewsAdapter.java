package com.example.sayedsalah.newsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by akueisara on 10/9/2016.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<News> mNewsList;
    private OnItemClickListener mListener;


    public NewsAdapter(List<News> newsList, OnItemClickListener listener) {
        mNewsList = newsList;
        mListener = listener;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View newsView = LayoutInflater.from(context).inflate(R.layout.news_list_item, parent, false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(newsView);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News news = mNewsList.get(position);
        holder.mTitle.setText(news.getTitle());
        holder.mType.setText(news.getType());
        holder.mDate.setText(news.getDate());
        holder.mSection.setText(news.getSection());
        holder.firstname.setText(news.getFirstname());
        holder.bind(mNewsList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void clear() {
        mNewsList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<News> newsList) {
        mNewsList.addAll(newsList);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(News news);
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle = (TextView) itemView.findViewById(R.id.news_title);

        TextView mType = (TextView) itemView.findViewById(R.id.news_type);

        TextView mDate = (TextView) itemView.findViewById(R.id.news_date);

        TextView mSection = (TextView) itemView.findViewById(R.id.news_section);

        TextView firstname = (TextView) itemView.findViewById(R.id.first_name);


        public NewsViewHolder(View v) {
            super(v);
        }

        public void bind(final News news, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(news);
                }
            });
        }
    }
}
