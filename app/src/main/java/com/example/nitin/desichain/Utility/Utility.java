package com.example.nitin.desichain.Utility;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.nitin.desichain.BookandMedia;
import com.example.nitin.desichain.HealthandFood;
import com.example.nitin.desichain.HelpCentre;
import com.example.nitin.desichain.MyAccount;
import com.example.nitin.desichain.MyCart;
import com.example.nitin.desichain.MyOrders;
import com.example.nitin.desichain.Others;
import com.example.nitin.desichain.Poojaitems;
import com.example.nitin.desichain.R;

/**
 * Created by ashis on 6/7/2017.
 */

public class Utility {

    public static void openIntent(Context mContext, int id){

        switch (id){
           case R.id.books_and_media:
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
                Toast.makeText(mContext,"Kath putli is selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cow_panchgava_products:
                Toast.makeText(mContext,"cow_panchgava_products is selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_cart:
                mContext.startActivity(new Intent(mContext,MyCart.class));
                break;
            case R.id.my_order:
                mContext.startActivity(new Intent(mContext,MyOrders.class));
                break;
            case R.id.my_account:
                mContext.startActivity(new Intent(mContext,MyAccount.class));
                break;
            case R.id.help_centre:
                mContext.startActivity(new Intent(mContext,HelpCentre.class));
                break;
            case R.id.Legal:
                Toast.makeText(mContext,"Legal option is selected",Toast.LENGTH_SHORT).show();
                break;
        }



    }

}
