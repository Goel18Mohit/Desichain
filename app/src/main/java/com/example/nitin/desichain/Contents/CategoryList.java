package com.example.nitin.desichain.Contents;

/**
 * Created by NITIN on 20-Jun-17.
 */

public class CategoryList {

    private int ImageUrl;
    private String PRODUCT_NAME;
    private String PRICE;
    private String RATINGS;
    private String NUMBER_OF_REVIEWS;

    public CategoryList(int imageUrl, String PRODUCT_NAME, String PRICE, String RATINGS, String NUMBER_OF_REVIEWS) {
        ImageUrl = imageUrl;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRICE = PRICE;
        this.RATINGS = RATINGS;
        this.NUMBER_OF_REVIEWS = NUMBER_OF_REVIEWS;
    }

    public void setImageUrl(int imageUrl) {
        ImageUrl = imageUrl;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public void setNUMBER_OF_REVIEWS(String NUMBER_OF_REVIEWS) {
        this.NUMBER_OF_REVIEWS = NUMBER_OF_REVIEWS;
    }

    public void setRATINGS(String RATINGS) {
        this.RATINGS = RATINGS;
    }

    public int getImageUrl() {

        return ImageUrl;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public String getRATINGS() {
        return RATINGS;
    }

    public String getPRICE() {
        return PRICE;
    }

    public String getNUMBER_OF_REVIEWS() {
        return NUMBER_OF_REVIEWS;
    }
}
