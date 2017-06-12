package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCart extends AppCompatActivity implements View.OnClickListener {

    private TextView textCheckOut, textRupeeSymbol, textCost;
    private ImageView imgCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
     /*   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/
        textCheckOut = (TextView) findViewById(R.id.checkoutText);
        textRupeeSymbol = (TextView) findViewById(R.id.rupeeSymbolCheckout);
        textCost = (TextView) findViewById(R.id.costCheckout);
        imgCheckout = (ImageView) findViewById(R.id.imgCheckoutForward);

        textCheckOut.setOnClickListener(this);
        textCost.setOnClickListener(this);
        textRupeeSymbol.setOnClickListener(this);
        imgCheckout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.checkoutText:
            case R.id.rupeeSymbolCheckout:
            case R.id.costCheckout:
            case R.id.imgCheckoutForward:
                startActivity(new Intent(MyCart.this,BuyNow.class));
                break;

        }
    }
}
