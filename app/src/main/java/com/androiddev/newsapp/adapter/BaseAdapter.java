package com.androiddev.newsapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androiddev.newsapp.R;
import com.androiddev.newsapp.data.model.NewsModel;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by trach on 1/18/2018.
 */

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.NewsHolder> {

    protected Context mContext;
    protected List<NewsModel> mDataList;

    public BaseAdapter(Context context, List<NewsModel> data){
        mContext = context;
        mDataList = data;
    }


    @Override
    public abstract NewsHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        NewsModel newsModel = mDataList.get(position);
        holder.author.setText(newsModel.getData().getAuthor());
        holder.title.setText(newsModel.getData().getTitle());
        Glide.with(mContext)
                .load(newsModel.getData().getThumbnailUrl())
                .into(holder.imageView);
    }

    public void swapData(List<NewsModel> data){
        if(mDataList!=null){
            mDataList.clear();
            mDataList.addAll(data);
        }else {
            mDataList = data;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (mDataList!=null)?mDataList.size():0;
    }

    public void update(List<NewsModel> dataList) {
        int start = mDataList.size();
        mDataList.addAll(dataList);
        //notifyItemChanged(start, dataList);
        notifyDataSetChanged();
    }

    class NewsHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title, author;
        public NewsHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
        }
    }
}
