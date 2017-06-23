package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 6/23/2017.
 */

public class QuestionAnswer {

    private String mQues;
    private String mAns;
    private String mSellerName;
    private String mDate;

    public QuestionAnswer(String mQues, String mAns, String mSellerName, String mDate) {
        this.mQues = mQues;
        this.mAns = mAns;
        this.mSellerName = mSellerName;
        this.mDate = mDate;
    }

    public String getmQues() {
        return mQues;
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
