package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 6/20/2017.
 */

public class ProductHorizontal {

    private String mProductName,mProductCost,mProductNoOfReviews,mProductRating;
    private int mProductImageId;
    public ProductHorizontal(String mProductName, String mProductCost, int mProductImageId, String mProductNoOfReviews, String mProductRating) {
        this.mProductName = mProductName;
        this.mProductCost = mProductCost;
        this.mProductImageId = mProductImageId;
        this.mProductNoOfReviews = mProductNoOfReviews;
        this.mProductRating = mProductRating;
    }

    public String getmProductName() {
        return mProductName;
    }

    public String getmProductCost() {
        return mProductCost;
    }

    public int getmProductImageId() {
        return mProductImageId;
    }

    public String getmProductNoOfReviews() {
        return mProductNoOfReviews;
    }

    public String getmProductRating() {
        return mProductRating;
    }
}
