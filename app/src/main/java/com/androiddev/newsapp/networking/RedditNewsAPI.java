package com.androiddev.newsapp.networking;

import com.androiddev.newsapp.data.model.NewsDataResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by trach on 1/17/2018.
 */

public interface RedditNewsAPI {
    @GET("/top.json")
    Call<NewsDataResult> getNews(@Query("limit") int limit, @Query("after") String after);
}
