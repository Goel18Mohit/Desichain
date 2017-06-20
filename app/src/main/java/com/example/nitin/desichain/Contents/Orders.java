package com.example.nitin.desichain.Contents;

/**
 * Created by ashis on 6/17/2017.
 */

public class Orders {

    private String mDate,mOrderId,mPrice,mItems,mStatus;

    public Orders(String mDate, String mOrderId, String mPrice, String mItems, String mStatus) {
        this.mDate = mDate;
        this.mOrderId = mOrderId;
        this.mPrice = mPrice;
        this.mItems = mItems;
        this.mStatus = mStatus;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmOrderId() {
        return mOrderId;
    }

    public void setmOrderId(String mOrderId) {
        this.mOrderId = mOrderId;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmItems() {
        return mItems;
    }

    public void setmItems(String mItems) {
        this.mItems = mItems;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }
}
