package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 7/5/2017.
 */

public class ChildCategoryBrand {

    private int PRODUCT_ID_SNO;
    private String PRODUCT_IMAGE_URL;
    private String PRODUCT_NAME;


    public ChildCategoryBrand(int PRODUCT_ID_SNO, String PRODUCT_NAME, String PRODUCT_IMAGE_URL) {
        this.PRODUCT_ID_SNO = PRODUCT_ID_SNO;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_IMAGE_URL = PRODUCT_IMAGE_URL;
    }

    public int getPRODUCT_ID_SNO() {
        return PRODUCT_ID_SNO;
    }

    public String getPRODUCT_IMAGE_URL() {
        return PRODUCT_IMAGE_URL;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }
}
