package com.example.nitin.desichain.Contents;

/**
 * Created by NITIN on 07-Jul-17.
 */

public class BrandStudioList {

    private String BRAND_IMAGE_URL;
    private String BRAND_PAGE_URL;
    private String BRAND_PAGE_DESCRIPTION;
    private int BRAND_SNO;

    public BrandStudioList(String BRAND_IMAGE_URL, String BRAND_PAGE_URL , String BRAND_PAGE_DESCRIPTION,int brandSno) {
        this.BRAND_IMAGE_URL = BRAND_IMAGE_URL;
        this.BRAND_PAGE_URL = BRAND_PAGE_URL;
        this.BRAND_PAGE_DESCRIPTION = BRAND_PAGE_DESCRIPTION;
        this.BRAND_SNO = brandSno;
    }

    public String getBRAND_PAGE_DESCRIPTION() {
        return BRAND_PAGE_DESCRIPTION;
    }

    public int getBRAND_SNO() {
        return BRAND_SNO;
    }

    public String getBRAND_IMAGE_URL() {
        return BRAND_IMAGE_URL;
    }

    public String getBRAND_PAGE_URL() {
        return BRAND_PAGE_URL;
    }
}
