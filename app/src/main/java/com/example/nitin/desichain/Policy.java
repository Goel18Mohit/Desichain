package com.example.nitin.desichain;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Policy extends AppCompatActivity implements View.OnClickListener {
    TextView SHIPPING_POLICY_TEXTVIEW;
    ImageView SHIPPING_POLICY_BUTTON;
    FragmentManager FRAGMENTMANAGER;
    public static int SHIPPING_FLAG =0;
    final ShippingPolicy shippingPolicy=new ShippingPolicy();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        FRAGMENTMANAGER=getSupportFragmentManager();
        SHIPPING_POLICY_TEXTVIEW= (TextView) findViewById(R.id.shipping_policy);
        SHIPPING_POLICY_BUTTON= (ImageView) findViewById(R.id.shipping_policy1);
        SHIPPING_POLICY_BUTTON.setOnClickListener(this);
        SHIPPING_POLICY_TEXTVIEW.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.shipping_policy:
            case R.id.shipping_policy1:if(SHIPPING_FLAG ==0) {
                SHIPPING_FLAG =1;
                fragmentopen(R.id.shippingfragment);
                SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_remove_black_24dp);
            }
                else if(SHIPPING_FLAG ==1)
            {
                fragmentclose(R.id.shippingfragment);
                SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_add_black_24dp);
                SHIPPING_FLAG =0;
            }
                                       break;
        }
    }

    public void fragmentopen(int fragmentid){

        switch (fragmentid){
            case R.id.shippingfragment:
                FRAGMENTMANAGER.beginTransaction().replace(fragmentid,shippingPolicy).commit();


        }

    }
    public void fragmentclose(int fragmentid)
    {
        switch (fragmentid){
            case R.id.shippingfragment:
                FRAGMENTMANAGER.beginTransaction().remove(shippingPolicy).commit();
                break;
        }
    }
}
