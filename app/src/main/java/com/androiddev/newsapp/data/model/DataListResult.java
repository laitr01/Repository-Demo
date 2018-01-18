package com.androiddev.newsapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trach on 1/17/2018.
 */
public class DataListResult<T> implements Serializable {
    private static final long serialVersionUID = 543539280586736629L;
    @SerializedName("before")
    private String mBeforeToken;
    @SerializedName("after")
    private String mAfterToken;
    @SerializedName("children")
    private List<T> mDataList;

    public List<T> getDataList() {
        if (mDataList == null) {
            mDataList = new ArrayList<T>();
        }
        return mDataList;
    }

    public String getAfterToken() {
        return mAfterToken;
    }
}

