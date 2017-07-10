package com.example.nitin.desichain.Contents;

/**
 * Created by NITIN on 07-Jul-17.
 */

public class BrandStudioList {

    private String BRAND_IMAGE_URL;
    private String BRAND_PAGE_URL;

    public BrandStudioList(String BRAND_IMAGE_URL, String BRAND_PAGE_URL) {
        this.BRAND_IMAGE_URL = BRAND_IMAGE_URL;
        this.BRAND_PAGE_URL = BRAND_PAGE_URL;
    }

    public String getBRAND_IMAGE_URL() {
        return BRAND_IMAGE_URL;
    }

    public String getBRAND_PAGE_URL() {
        return BRAND_PAGE_URL;
    }
}
