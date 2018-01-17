package com.androiddev.newsapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.androiddev.newsapp.data.datasource.NewsDataSource;
import com.androiddev.newsapp.data.datasource.remote.NewsRemoteDataSource;
import com.androiddev.newsapp.data.model.NewsDataResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                NewsRemoteDataSource.instance().getTasks(10, "", new NewsDataSource.LoadNewsCallback() {
                    @Override
                    public void onTasksLoaded(NewsDataResult result) {
                        Log.e("GET", result.toString());
                    }

                    @Override
                    public void onDataNotAvailable() {
                        Log.e("FAIL", "onDataNotAvailable");
                    }
                });
                return null;
            }
        }.execute();
    }
}
