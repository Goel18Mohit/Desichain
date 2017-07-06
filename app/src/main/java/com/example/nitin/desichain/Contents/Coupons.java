package com.example.nitin.desichain.Contents;

/**
 * Created by Karan on 05-07-2017.
 */

public class Coupons {

    private String mCouponCode, mCouponDescription;

    public Coupons(String couponCode, String couponDescription){
        this.mCouponCode=couponCode;
        this.mCouponDescription=couponDescription;
    }

    public String getmCouponCode(){
        return mCouponCode;
    }
    public String getmCouponDescription(){
        return mCouponDescription;
    }
}
