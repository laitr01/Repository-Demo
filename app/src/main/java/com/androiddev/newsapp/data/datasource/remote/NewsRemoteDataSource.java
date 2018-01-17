package com.androiddev.newsapp.data.datasource.remote;

import android.support.annotation.NonNull;

import com.androiddev.newsapp.data.datasource.NewsDataSource;
import com.androiddev.newsapp.data.model.NewsDataResult;
import com.androiddev.newsapp.networking.RedditService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by trach on 1/17/2018.
 */

public class NewsRemoteDataSource implements NewsDataSource {

    private static NewsRemoteDataSource sInstance;

    private NewsRemoteDataSource() { }

    public static NewsRemoteDataSource instance(){
        if(sInstance == null){
            sInstance = new NewsRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getTasks(int limit, String after, @NonNull final LoadNewsCallback callback) {
        Call<NewsDataResult> resultCall = RedditService.instance().getNewsAPI().getNews(limit, after);
        if(resultCall != null){
            resultCall.enqueue(new Callback<NewsDataResult>() {
                @Override
                public void onResponse(Call<NewsDataResult> call,
                                       Response<NewsDataResult> response) {
                    callback.onTasksLoaded(response.body());
                }

                @Override
                public void onFailure(Call<NewsDataResult> call, Throwable t) {
                    callback.onDataNotAvailable();
                }
            });
        }
    }

}
