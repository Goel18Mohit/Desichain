package com.example.nitin.desichain.Contents;

/**
 * Created by NITIN on 23-Jun-17.
 */

public class ChildCategoryList {

    private String CHILDCATEGORYNAME;
    private int IMAGEID;

    public ChildCategoryList(String CHILDCATEGORYNAME, int IMAGEID) {
        this.CHILDCATEGORYNAME = CHILDCATEGORYNAME;
        this.IMAGEID = IMAGEID;
    }

    public int getIMAGEID() {
        return IMAGEID;
    }

    public String getCHILDCATEGORYNAME() {
        return CHILDCATEGORYNAME;
    }

    public void setCHILDCATEGORYNAME(String CHILDCATEGORYNAME) {
        this.CHILDCATEGORYNAME = CHILDCATEGORYNAME;
    }

    public void setIMAGEID(int IMAGEID) {
        this.IMAGEID = IMAGEID;
    }
}
