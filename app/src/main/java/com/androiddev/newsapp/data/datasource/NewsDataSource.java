package com.androiddev.newsapp.data.datasource;

import android.support.annotation.NonNull;

import com.androiddev.newsapp.data.model.NewsDataResult;

/**
 * Created by trach on 1/17/2018.
 */

public interface NewsDataSource {

    interface LoadNewsCallback{

        void onTasksLoaded(NewsDataResult result);

        void onDataNotAvailable();

    }

    void getTasks(int limit, String after, @NonNull LoadNewsCallback callback);

}
