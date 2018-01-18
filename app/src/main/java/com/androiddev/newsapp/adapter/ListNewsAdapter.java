package com.androiddev.newsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androiddev.newsapp.R;
import com.androiddev.newsapp.data.model.NewsModel;

import java.util.List;

/**
 * Created by trach on 1/18/2018.
 */

public class ListNewsAdapter extends BaseAdapter {

    public ListNewsAdapter(Context context, List<NewsModel> data) {
        super(context, data);
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout, null);
        return new NewsHolder(view);
    }
}
