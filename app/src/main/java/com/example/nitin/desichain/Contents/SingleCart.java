package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 6/23/2017.
 */

public class SingleCart {

    private int mImageId,mQty,mCost;
    private String mProductName,mProductBrand;

    public SingleCart(int mImageId, int mQty, int mCost, String mProductName, String mProductBrand) {
        this.mImageId = mImageId;
        this.mQty = mQty;
        this.mCost = mCost;
        this.mProductName = mProductName;
        this.mProductBrand = mProductBrand;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public void setmQty(int mQty) {
        this.mQty = mQty;
    }

    public void setmCost(int mCost) {
        this.mCost = mCost;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public void setmProductBrand(String mProductBrand) {
        this.mProductBrand = mProductBrand;
    }

    public int getmImageId() {
        return mImageId;
    }

    public int getmQty() {
        return mQty;
    }

    public int getmCost() {
        return mCost;
    }

    public String getmProductName() {
        return mProductName;
    }

    public String getmProductBrand() {
        return mProductBrand;
    }
}

