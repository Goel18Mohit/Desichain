package com.example.nitin.desichain.Contents;

import java.io.Serializable;

/**
 * Created by NITIN on 20-Jun-17.
 */

public class CategoryList implements Serializable{

    private String ImageUrl;
    private String PRODUCT_NAME;
    private int PRICE;
    private String RATINGS;
    private String NUMBER_OF_REVIEWS;



    public CategoryList(String imageUrl, String PRODUCT_NAME, int PRICE, String RATINGS, String NUMBER_OF_REVIEWS) {
        this.ImageUrl = imageUrl;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRICE = PRICE;
        this.RATINGS = RATINGS;
        this.NUMBER_OF_REVIEWS = NUMBER_OF_REVIEWS;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public int getPRICE() {
        return PRICE;
    }

    public String getRATINGS() {
        return RATINGS;
    }

    public String getNUMBER_OF_REVIEWS() {
        return NUMBER_OF_REVIEWS;
    }
}
