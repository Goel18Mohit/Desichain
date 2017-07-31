package com.example.nitin.desichain.Contents;


import static com.example.nitin.desichain.R.mipmap.newsletter;

/**
 * Created by Karan on 28-07-2017.
 */

public class LoginData {

    private int msno, mzip,mphone,mfax, mMobile, mCartItemsAdd, mBillmobileno;
    private String memail, mpwd, mgender, mfname,
            mLname,
            mCity=null,
            mState=null,
    mLmark=null,
    mbillingname=null,
            mCountry=null,
            maddress=null,
            mnewsletter=null;

    public int getMsno() {
        return msno;
    }

    public int getMzip() {
        return mzip;
    }

    public int getMphone() {
        return mphone;
    }

    public int getMfax() {
        return mfax;
    }

    public int getmMobile() {
        return mMobile;
    }

    public int getmCartItemsAdd() {
        return mCartItemsAdd;
    }

    public String getMemail() {
        return memail;
    }

    public String getMpwd() {
        return mpwd;
    }

    public String getMgender() {
        return mgender;
    }

    public String getMfname() {
        return mfname;
    }

    public String getmLname() {
        return mLname;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmState() {
        return mState;
    }

    public String getmCountry() {
        return mCountry;
    }

    public String getMaddress() {
        return maddress;
    }

    public int getmBillmobileno() {
        return mBillmobileno;
    }

    public String getmLmark() {
        return mLmark;
    }

    public String getMbillingname() {
        return mbillingname;
    }

    public String getMnewsletter() {
        return mnewsletter;
    }

    public LoginData(int sno, String email, String lmark, String billingname, int billmobileno, String pwd, String gender, String fname, String Lname, String city, String state, String country, int zip, String address, int phone, int fax, int mobile, int CartItemsAdd, String newsletter){
        msno = sno;
        memail= email;
        mpwd = pwd;
        mgender = gender;
        mfname = fname;
        mLname = Lname;
        mCity = city;
        mState = state;
        mCountry = country;
        mzip = zip;
        maddress = address;
        mphone = phone;
        mMobile = mobile;
        mnewsletter = newsletter;
        mfax=fax;
        mLmark = lmark;
        mbillingname = billingname;
        mBillmobileno = billmobileno;
        mCartItemsAdd = CartItemsAdd;
    }
}
