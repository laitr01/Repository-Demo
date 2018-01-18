package com.androiddev.newsapp.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androiddev.newsapp.R;
import com.androiddev.newsapp.adapter.ListNewsAdapter;
import com.androiddev.newsapp.data.datasource.NewsDataSource;
import com.androiddev.newsapp.data.datasource.remote.NewsRemoteDataSource;
import com.androiddev.newsapp.data.model.NewsDataResult;
import com.androiddev.newsapp.data.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trach on 1/18/2018.
 */

public class ListScreenFragment extends Fragment {

    RecyclerView recyclerView;
    ListNewsAdapter mAdapter;
    List<NewsModel> mData;
    private boolean isFirst = false, loading = false;
    int visibleItemCount;
    int totalItemCount;
    int firstVisibleItemIndex, previousTotal;
    LinearLayoutManager linearLayoutManager;
    String afterToken;

    public static ListScreenFragment instance(){
        return new ListScreenFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_screen_layout, null);
        recyclerView = rootView.findViewById(R.id.list_news_view);
        isFirst = true;
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mData = new ArrayList<>();
        mAdapter = new ListNewsAdapter(getContext(), mData);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = recyclerView.getLayoutManager().getItemCount();
                firstVisibleItemIndex = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading){
                    if ((totalItemCount - visibleItemCount) <= firstVisibleItemIndex) {
                        loading = true;
                        loadNews(afterToken);
                    }
                }
            }
        });
        recyclerView.setAdapter(mAdapter);
        if(isFirst) {
            loadNews("");
        }
    }

    public void loadNews(final String after){
        NewsRemoteDataSource.instance().getTasks(10, after, new NewsDataSource.LoadNewsCallback() {
            @Override
            public void onTasksLoaded(NewsDataResult result) {
                Log.e("GET", result.toString());
                afterToken = (result.getDataListResult().getAfterToken()!=null)?result.getDataListResult().getAfterToken():"";
                if (isFirst && !loading){
                    swapData(result.getDataListResult().getDataList());
                }
                if(loading){
                    update(result.getDataListResult().getDataList());
                }
                isFirst = false;
                loading = false;
            }

            @Override
            public void onDataNotAvailable() {
                Log.e("FAIL", "onDataNotAvailable");
            }
        });
    }

    private void update(List<NewsModel> dataList) {
        mAdapter.update(dataList);
    }

    public void swapData(List<NewsModel> newsModels){
        mAdapter.swapData(newsModels);
    }
}
