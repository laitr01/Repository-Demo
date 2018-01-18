package com.androiddev.newsapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.androiddev.newsapp.data.datasource.NewsDataSource;
import com.androiddev.newsapp.data.datasource.remote.NewsRemoteDataSource;
import com.androiddev.newsapp.data.model.NewsDataResult;
import com.androiddev.newsapp.fragment.ListScreenFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.container, ListScreenFragment.instance()).commit();

        /**/

    }
}
