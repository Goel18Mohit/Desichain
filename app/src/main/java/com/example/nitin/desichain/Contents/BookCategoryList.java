package com.example.nitin.desichain.Contents;

/**
 * Created by NITIN on 31-Jul-17.
 */

public class BookCategoryList {
    private String PRODUCT_NAME;
    private int   ACTUAL_PRICE;
    private int SELLING_PRICE;
    private String IMAGE_URL;
    private int  DISCOUNT;
    private int PRODUCT_ID;
    private String PRODUCT_DESCRIPTION;
    private String PUBLISHERNAME;
    private String AUTHORNAME;
    private int BRAND_ID;
    private String NET_WEIGTH;
    private int GROSS_WEIGHHT;
    private String RATINGS;
    private String REVIEWS;

    public BookCategoryList(String PRODUCT_NAME, int ACTUAL_PRICE, int SELLING_PRICE, String IMAGE_URL, int DISCOUNT, int PRODUCT_ID, String PRODUCT_DESCRIPTION, String PUBLISHERNAME, String AUTHORNAME, int BRAND_ID, String NET_WEIGTH, int GROSS_WEIGHHT,String RATINGS,String REVIEWS) {
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.ACTUAL_PRICE = ACTUAL_PRICE;
        this.SELLING_PRICE = SELLING_PRICE;
        this.IMAGE_URL = IMAGE_URL;
        this.DISCOUNT = DISCOUNT;
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
        this.PUBLISHERNAME = PUBLISHERNAME;
        this.AUTHORNAME = AUTHORNAME;
        this.BRAND_ID = BRAND_ID;
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

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public int getDISCOUNT() {
        return DISCOUNT;
    }

    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }

    public String getPUBLISHERNAME() {
        return PUBLISHERNAME;
    }

    public String getAUTHORNAME() {
        return AUTHORNAME;
    }

    public int getBRAND_ID() {
        return BRAND_ID;
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
