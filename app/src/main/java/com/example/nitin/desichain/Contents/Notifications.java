package com.example.nitin.desichain.Contents;

/**
 * Created by Karan on 04-07-2017.
 */

public class Notifications {

    private String mHeading;
    private int mImage;

    public Notifications (String Heading, int Description)
    {
        this.mHeading = Heading;
        this.mImage = Description;
    }

    public String getmHeading(){
        return mHeading;
    }

    public int getmImage(){
        return mImage;
    }
}
