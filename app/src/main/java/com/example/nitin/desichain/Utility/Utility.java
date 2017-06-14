package com.example.nitin.desichain.Utility;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import com.example.nitin.desichain.AboutUs;
import com.example.nitin.desichain.HelpCentre;
import com.example.nitin.desichain.MyAccount;
import com.example.nitin.desichain.MyCart;
import com.example.nitin.desichain.MyOrders;
import com.example.nitin.desichain.Policy;
import com.example.nitin.desichain.R;

/**
 * Created by ashis on 6/7/2017.
 */

public class Utility {

    public static void openIntent(Context mContext, int id){

        switch (id){
         /*  case R.id.books_and_media:
                mContext.startActivity(new Intent(mContext,BookandMedia.class));
                break;
            case R.id.pooja_item:
                mContext.startActivity(new Intent(mContext,Poojaitems.class));
                break;
            case R.id.others:
                mContext.startActivity(new Intent(mContext,Others.class));
                break;
            case R.id.health_and_food:
                mContext.startActivity(new Intent(mContext, HealthandFood.class));
                break;
            case R.id.kath_putli:
                Toast.makeText(mContext,"Kath putli is selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cow_panchgava_products:
                Toast.makeText(mContext,"cow_panchgava_products is selected",Toast.LENGTH_SHORT).show();
                break;*/
            case R.id.my_cart:
                mContext.startActivity(new Intent(mContext,MyCart.class));
                break;
            case R.id.my_orders:
                mContext.startActivity(new Intent(mContext,MyOrders.class));
                break;
            case R.id.my_account:
                mContext.startActivity(new Intent(mContext,MyAccount.class));
                break;
            case R.id.contact_us:
                mContext.startActivity(new Intent(mContext,HelpCentre.class));
                break;
            case R.id.policy:
                mContext.startActivity(new Intent(mContext, Policy.class));
                break;
            case R.id.about_us:
                    mContext.startActivity(new Intent(mContext, AboutUs.class));
        }
    }

    public static String getFbPageUrl(Context mContext){

          String FACEBOOK_URL = "https://www.facebook.com/DesiChain.in/";
          String FACEBOOK_PAGE_ID = "DesiChain.in";

        PackageManager packageManager = mContext.getPackageManager();

        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana",0).versionCode;
            boolean activated =  packageManager.getApplicationInfo("com.facebook.katana", 0).enabled;
            if (versionCode >= 3002850 && activated){
                return "fb://facewebmodal/f?href="+FACEBOOK_URL;
            }else {
                return "fb://page/"+FACEBOOK_PAGE_ID;
            }

        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL;
        }
    }

    public static String getTwitterUrl(Context mContext){

        String TWITTER_URL = "https://twitter.com/DesiChainindia";
        String TWITTER_ID = "DesiChainindia";

        try {
            String pkgInfo = mContext.getPackageManager().getPackageInfo("com.twitter.android", 0).toString();
            if (pkgInfo.equals("com.twitter.android")) {
                return "twitter://user?user_id=" + TWITTER_ID;
            }
            else {
                return TWITTER_URL;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return TWITTER_URL;
        }
    }

}
