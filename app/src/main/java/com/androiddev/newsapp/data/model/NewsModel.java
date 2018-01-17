package com.androiddev.newsapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by trach on 1/17/2018.
 */

public class NewsModel implements Serializable{

    private static final long serialVersionUID = -9112139280586736629L;
    @SerializedName("data")
    private Data mData;

    public Data getData() {
        return mData;
    }

    public static class Data{

        private static final long serialVersionUID = 64545280586736629L;
        @SerializedName("id")
        private String mId;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("author")
        private String mAuthor;
        @SerializedName("created")
        private long mCreatedTime;
        @SerializedName("thumbnail")
        private String mThumbnailUrl;
        @SerializedName("num_comments")
        private int mNumOfComments;

        public String getId() {
            return mId;
        }

        public String getTitle() {
            return mTitle;
        }

        public String getAuthor() {
            return mAuthor;
        }

        public long getCreatedTime() {
            return mCreatedTime;
        }

        public String getThumbnailUrl() {
            return mThumbnailUrl;
        }

        public int getNumOfComments() {
            return mNumOfComments;
        }
    }
}
