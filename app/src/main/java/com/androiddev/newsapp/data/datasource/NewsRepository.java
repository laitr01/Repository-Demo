package com.androiddev.newsapp.data.datasource;

import android.support.annotation.NonNull;

/**
 * Created by trach on 1/17/2018.
 */

public class NewsRepository implements NewsDataSource {

    private static NewsRepository sInstance;

    private NewsRepository() { }

    public static NewsRepository instance(){
        if(sInstance == null){
            sInstance = new NewsRepository();
        }
        return sInstance;
    }
    @Override
    public void getTasks(int limit, String after,@NonNull LoadNewsCallback callback) {

    }

}
