package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 7/5/2017.
 */

public class ChildCategoryBrand {

    private int mImageId;
    private String mBrandName;


    public ChildCategoryBrand(int mImageId, String mBrandName) {
        this.mImageId = mImageId;
        this.mBrandName = mBrandName;
    }

    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
    }

    public String getmBrandName() {
        return mBrandName;
    }

    public void setmBrandName(String mBrandName) {
        this.mBrandName = mBrandName;
    }
}
