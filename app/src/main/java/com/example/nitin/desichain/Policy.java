package com.example.nitin.desichain;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Contents.Advertisements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Policy extends AppCompatActivity implements View.OnClickListener {


    private Helper listView;
    ArrayList<CategoryHolder> arrayList;
    public ArrayList<String> Books;
    private List<Advertisements> mPics;
    ArrayList<String> Poojaitem;
    NestedScrollView nestedScrollView;
    ArrayList<String> Healthandfood;
    ArrayList<String> others;
    HashMap<String,ArrayList<String>> hashMap;
    View headerView;
    private LinearLayout mCustomerServiceLayout,mShippingLayout,mReturnLayout;
    private int RETURN_CLICKS = 0,CUSTOMER_CLICKS =0;
    private FragmentManager fragmentManager;
    final ReturnPolicy returnPolicy = new ReturnPolicy();
    final CustomerService customerService = new CustomerService();
    ImageView SHIPPING_POLICY_BUTTON,mImgReturnPolicy,mImgCustomerService;
    public static int SHIPPING_FLAG =0;
    final ShippingPolicy shippingPolicy=new ShippingPolicy();
    LinearLayout myorder,mycart,myaccount,helpcenter,ratedesichain,productPage,policy,facebook,google,twitter,pinterest,youtube,instagram,aboutus;

    public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
       mImgCustomerService=(ImageView)findViewById(R.id.imgCustomerService);
        mImgReturnPolicy=(ImageView)findViewById(R.id.imgReturnPolicy);

        SHIPPING_POLICY_BUTTON=(ImageView)findViewById(R.id.imgShippingPolicy);

        mCustomerServiceLayout=(LinearLayout)findViewById(R.id.customerService);
        mShippingLayout=(LinearLayout)findViewById(R.id.shipping_policy);
        mReturnLayout=(LinearLayout)findViewById(R.id.return_policy);
        textView= (TextView) findViewById(R.id.rpt);
        fragmentManager = getSupportFragmentManager();


        mCustomerServiceLayout.setOnClickListener(this);
        mShippingLayout.setOnClickListener(this);
        mReturnLayout.setOnClickListener(this);
        textView.setOnClickListener(this);
        mImgReturnPolicy.setOnClickListener(this);


    }





    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.imgReturnPolicy:
            case R.id.rpt:

                if (RETURN_CLICKS == 0){


                    Toast.makeText(Policy.this,"clicked",Toast.LENGTH_SHORT).show();
                    if (CUSTOMER_CLICKS==1){
                        fragmentManager.beginTransaction().remove(customerService).commit();
                        mImgCustomerService.setImageResource(R.mipmap.ic_add_black_24dp);
                        CUSTOMER_CLICKS=0;
                    }
                    if (SHIPPING_FLAG==1){
                        fragmentManager.beginTransaction().remove(shippingPolicy).commit();
                        SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_add_black_24dp);
                        SHIPPING_FLAG=0;
                    }
                    fragmentManager.beginTransaction().replace(R.id.fragment_return_policy,returnPolicy).commit();
                    RETURN_CLICKS =1;
                    mImgReturnPolicy.setImageResource(R.mipmap.ic_remove_black_24dp);
                }
                else if (RETURN_CLICKS == 1){


                    fragmentManager.beginTransaction().remove(returnPolicy).commit();
                    RETURN_CLICKS =0;
                    mImgReturnPolicy.setImageResource(R.mipmap.ic_add_black_24dp);
                }
                break;
            case R.id.customerService:



                if (CUSTOMER_CLICKS == 0){
                    if (SHIPPING_FLAG==1){
                        fragmentManager.beginTransaction().remove(shippingPolicy).commit();
                        SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_add_black_24dp);
                        SHIPPING_FLAG=0;
                    }
                    if (RETURN_CLICKS==1){
                        fragmentManager.beginTransaction().remove(returnPolicy).commit();
                        mImgReturnPolicy.setImageResource(R.mipmap.ic_add_black_24dp);
                        RETURN_CLICKS=0;
                    }

                    fragmentManager.beginTransaction().replace(R.id.fragment_customer_Service,customerService).commit();
                    CUSTOMER_CLICKS=1;
                    mImgCustomerService.setImageResource(R.mipmap.ic_remove_black_24dp);

                }
                else if (CUSTOMER_CLICKS==1){

                    fragmentManager.beginTransaction().remove(customerService).commit();
                    CUSTOMER_CLICKS=0;
                    mImgCustomerService.setImageResource(R.mipmap.ic_add_black_24dp);
                }
                break;
            case R.id.shipping_policy:



                if(SHIPPING_FLAG ==0) {
                    if (CUSTOMER_CLICKS == 1){
                        fragmentManager.beginTransaction().remove(customerService).commit();
                        mImgCustomerService.setImageResource(R.mipmap.ic_add_black_24dp);
                        CUSTOMER_CLICKS=0;

                    }
                    if (RETURN_CLICKS == 1){
                        fragmentManager.beginTransaction().remove(returnPolicy).commit();
                        mImgReturnPolicy.setImageResource(R.mipmap.ic_add_black_24dp);
                        RETURN_CLICKS=0;
                    }
                    fragmentManager.beginTransaction().replace(R.id.shippingfragment,shippingPolicy).commit();
                    SHIPPING_FLAG =1;

                    SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_remove_black_24dp);
                }
                else if(SHIPPING_FLAG ==1){
                    fragmentManager.beginTransaction().remove(shippingPolicy).commit();
                    SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_add_black_24dp);
                    SHIPPING_FLAG =0;
                }
                break;
        }

    }
}
