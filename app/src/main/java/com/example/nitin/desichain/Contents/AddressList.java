package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 6/17/2017.
 */

public class AddressList {

    private String mName;
    private String mAddress;
    private String mContactNumber;

    public AddressList() {
    }

    public AddressList(String mName, String mAddress, String mContactNumber) {
        this.mName = mName;
        this.mAddress = mAddress;
        this.mContactNumber = mContactNumber;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmContactNumber() {
        return mContactNumber;
    }

    public void setmContactNumber(String mContactNumber) {
        this.mContactNumber = mContactNumber;
    }


}
