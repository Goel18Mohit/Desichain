package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 6/18/2017.
 */

public class FullOrderContent {

    private String mBrandName,mProductName;
    private int mCost,mQty;

    public FullOrderContent(String mBrandName, String mProductName, int mCost, int mQty) {
        this.mBrandName = mBrandName;
        this.mProductName = mProductName;
        this.mCost = mCost;
        this.mQty = mQty;
    }

    public String getmBrandName() {
        return mBrandName;
    }

    public String getmProductName() {
        return mProductName;
    }

    public int getmCost() {
        return mCost;
    }

    public int getmQty() {
        return mQty;
    }
}
