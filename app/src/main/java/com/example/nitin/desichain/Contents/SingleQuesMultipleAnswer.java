package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 6/23/2017.
 */

public class SingleQuesMultipleAnswer {

    private String mAns;
    private String mSellerName;
    private String mDate;

    public SingleQuesMultipleAnswer(String mAns, String mSellerName, String mDate) {
        this.mAns = mAns;
        this.mSellerName = mSellerName;
        this.mDate = mDate;
    }

    public String getmAns() {
        return mAns;
    }

    public String getmSellerName() {
        return mSellerName;
    }

    public String getmDate() {
        return mDate;
    }
}
