package com.androiddev.newsapp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trach on 1/17/2018.
 */

public class NewsDataResult {
    private static final long serialVersionUID = -7112139280586736629L;
    @SerializedName("data")
    private DataListResult<NewsModel> mDataListResult;

    public DataListResult<NewsModel> getDataListResult() {
        return mDataListResult;
    }
}
