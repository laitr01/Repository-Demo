package com.androiddev.newsapp.networking;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by trach on 1/17/2018.
 */

public class RedditService {

    private static String BASE_URL =  "http://reddit.com";
    private static RedditService sInstance;

    private RedditService(){ }

    public static RedditService instance(){
        if(sInstance == null){
            sInstance = new RedditService();
        }
        return sInstance;
    }

    public RedditNewsAPI getNewsAPI(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(RedditNewsAPI.class);
    }
}
