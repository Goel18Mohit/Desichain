package com.example.nitin.desichain;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Policy extends AppCompatActivity implements View.OnClickListener {

    private TextView returnTextView, customerText;
    private ImageView returnImage,customerImage;
    private int RETURN_CLICKS = 0,CUSTOMER_CLICKS =0;
    private FragmentManager fragmentManager;
    final ReturnPolicy returnPolicy = new ReturnPolicy();
    final CustomerService customerService = new CustomerService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        returnImage = (ImageView) findViewById(R.id.img_return_policy);
        returnTextView=(TextView) findViewById(R.id.textview_return_policy);
        customerText = (TextView) findViewById(R.id.textCustomerService);
        customerImage = (ImageView) findViewById(R.id.imgCustomerService);
        fragmentManager = getSupportFragmentManager();

        returnTextView.setOnClickListener(this);
        returnImage.setOnClickListener(this);

        customerText.setOnClickListener(this);
        customerImage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.img_return_policy:
            case R.id.textview_return_policy:
                    if (RETURN_CLICKS == 0){
                        fragmentManager.beginTransaction().replace(R.id.fragment_return_policy,returnPolicy).commit();
                        RETURN_CLICKS =1;
                        returnImage.setImageResource(R.mipmap.ic_drag_handle_black_24dp);
                    }
                    else if (RETURN_CLICKS == 1){
                        fragmentManager.beginTransaction().remove(returnPolicy).commit();
                        RETURN_CLICKS =0;
                        returnImage.setImageResource(R.mipmap.ic_add_black_24dp);
                    }
                    break;
            case R.id.imgCustomerService:
            case R.id.textCustomerService:
                    if (CUSTOMER_CLICKS == 0){
                        fragmentManager.beginTransaction().replace(R.id.fragment_customer_Service,customerService).commit();
                        CUSTOMER_CLICKS=1;
                        customerImage.setImageResource(R.mipmap.ic_drag_handle_black_24dp);
                    }
                    else{
                        fragmentManager.beginTransaction().remove(customerService).commit();
                        CUSTOMER_CLICKS=0;
                        customerImage.setImageResource(R.mipmap.ic_add_black_24dp);
                    }
                    break;

        }
    }
}
