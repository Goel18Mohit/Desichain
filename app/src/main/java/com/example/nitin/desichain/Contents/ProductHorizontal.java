package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 6/20/2017.
 */

public class ProductHorizontal {

    private String mProductName,mProductNoOfReviews,mProductRating;
    private String mProductImageId;
    int DISCOUNT;
    int mProductCost;

    public int getDISCOUNT() {
        return DISCOUNT;
    }

    public ProductHorizontal(String mProductName, int mProductCost, String mProductImageId, String mProductNoOfReviews, String mProductRating, int DISCOUNT) {
        this.mProductName = mProductName;
        this.mProductCost = mProductCost;
        this.mProductImageId = mProductImageId;
        this.mProductNoOfReviews = mProductNoOfReviews;
        this.mProductRating = mProductRating;
        this.DISCOUNT=DISCOUNT;

    }

    public String getmProductName() {
        return mProductName;
    }

    public int getmProductCost() {
        return mProductCost;
    }

    public String getmProductImageId() {
        return mProductImageId;
    }

    public String getmProductNoOfReviews() {
        return mProductNoOfReviews;
    }

    public String getmProductRating() {
        return mProductRating;
    }
}
