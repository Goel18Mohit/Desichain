package com.example.nitin.desichain;

/**
 * Created by NITIN on 14-Jun-17.
 */

public class CategoryHolder {
    private String PARENTCATEGORY;
    private int FLAG_INDICATOR;

    public CategoryHolder(String PARENTCATEGORY, int FLAG_INDICATOR) {
        this.PARENTCATEGORY = PARENTCATEGORY;
        this.FLAG_INDICATOR = FLAG_INDICATOR;
    }

    public void setPARENTCATEGORY(String PARENTCATEGORY) {
        this.PARENTCATEGORY = PARENTCATEGORY;
    }

    public void setFLAG_INDICATOR(int FLAG_INDICATOR) {
        this.FLAG_INDICATOR = FLAG_INDICATOR;
    }

    public String getPARENTCATEGORY() {
        return PARENTCATEGORY;
    }

    public int getFLAG_INDICATOR() {
        return FLAG_INDICATOR;
    }
}
