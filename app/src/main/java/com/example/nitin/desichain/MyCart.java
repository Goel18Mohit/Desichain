package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MyCart extends AppCompatActivity {

    private LinearLayout mCheckoutLayout,mGiftWrapLayout,mPlaceOrderLayout;
    private RadioButton mGiftWrapRadioBtn;

    int k=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        mPlaceOrderLayout=(LinearLayout)findViewById(R.id.placeOrderLayout);
        mPlaceOrderLayout.setBackgroundColor(getResources().getColor(R.color.green));

        mGiftWrapRadioBtn =(RadioButton)findViewById(R.id.giftWrapRadioButton);
        mGiftWrapLayout=(LinearLayout)findViewById(R.id.giftWrapLayout);

        mGiftWrapLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mGiftWrapRadioBtn.isChecked()) {
                    mGiftWrapRadioBtn.setChecked(false);
                } else {
                    mGiftWrapRadioBtn.setChecked(true);
                }
            }
        });

        mCheckoutLayout=(LinearLayout)findViewById(R.id.checkoutLayout);
        mCheckoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyCart.this,BuyNow.class));
            }
        });

    }

}
