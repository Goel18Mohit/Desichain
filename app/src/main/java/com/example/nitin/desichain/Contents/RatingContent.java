package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 6/23/2017.
 */

public class RatingContent {

    private String mReviewerName,mDate,mReviewText;

    public RatingContent(String mReviewerName, String mDate, String mReviewText) {
        this.mReviewerName = mReviewerName;
        this.mDate = mDate;
        this.mReviewText = mReviewText;
    }

    public String getmReviewerName() {
        return mReviewerName;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmReviewText() {
        return mReviewText;
    }
}
