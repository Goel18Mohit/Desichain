package com.example.nitin.desichain.Contents;

import java.io.Serializable;

/**
 * Created by NITIN on 20-Jun-17.
 */

public class CategoryList implements Serializable{


    private String PRODUCT_NAME;
    private int   ACTUAL_PRICE;
    private int SELLING_PRICE;
    private String IMAGE_URL;
    private int  DISCOUNT;
    private int PRODUCT_ID;
    private String PRODUCT_DESCRIPTION;
    private int BRAND_ID;
    private String Ingredients;
    private String HOW_TO_USE;
    private String NET_WEIGTH;
    private int GROSS_WEIGHHT;
    private String RATINGS;
    private String REVIEWS;

    public CategoryList(String PRODUCT_NAME, int ACTUAL_PRICE, int SELLING_PRICE, String IMAGE_URL, int DISCOUNT, int PRODUCT_ID, String PRODUCT_DESCRIPTION, int BRAND_ID, String ingredients, String HOW_TO_USE, String NET_WEIGTH, int GROSS_WEIGHHT,String RATINGS,String REVIEWS) {
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.ACTUAL_PRICE = ACTUAL_PRICE;
        this.SELLING_PRICE = SELLING_PRICE;
        this.IMAGE_URL = IMAGE_URL;
        this.DISCOUNT = DISCOUNT;
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
        this.BRAND_ID = BRAND_ID;
        Ingredients = ingredients;
        this.HOW_TO_USE = HOW_TO_USE;
        this.NET_WEIGTH = NET_WEIGTH;
        this.GROSS_WEIGHHT = GROSS_WEIGHHT;
        this.RATINGS=RATINGS;
        this.REVIEWS=REVIEWS;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public int getACTUAL_PRICE() {
        return ACTUAL_PRICE;
    }

    public int getSELLING_PRICE() {
        return SELLING_PRICE;
    }

    public String getIMAGE_URL() {
        return IMAGE_URL;
    }

    public int getDISCOUNT() {
        return DISCOUNT;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public int getBRAND_ID() {
        return BRAND_ID;
    }

    public String getHOW_TO_USE() {
        return HOW_TO_USE;
    }

    public String getNET_WEIGTH() {
        return NET_WEIGTH;
    }

    public int getGROSS_WEIGHHT() {
        return GROSS_WEIGHHT;
    }

    public String getRATINGS() {
        return RATINGS;
    }

    public String getREVIEWS() {
        return REVIEWS;
    }
}
