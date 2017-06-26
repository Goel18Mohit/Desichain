package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.nitin.desichain.Adapters.SingleCartAdapter;
import com.example.nitin.desichain.Contents.SingleCart;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class BuyNow extends AppCompatActivity {

    Button b1;
    private RadioButton mGiftWrapRadioBtn;
    private LinearLayout mGiftWrapLayout;
    private RecyclerView mDeliveryView;
    private List<SingleCart> mList;
    private SingleCartAdapter mAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_cart_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Delivery");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b1 = (Button) findViewById(R.id.myCartContinueBtn);
        b1.setBackgroundColor(getResources().getColor(R.color.green));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Payment.class);
                startActivity(i);
            }
        });
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


        mDeliveryView=(RecyclerView) findViewById(R.id.deliveryView);
        mList=new ArrayList<>();
        mAdapter=new SingleCartAdapter(this,mList);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        mDeliveryView.setLayoutManager(lm);
        mDeliveryView.setItemAnimator(new DefaultItemAnimator());
        mDeliveryView.setAdapter(mAdapter);

        prepareItems();

    }

    private void prepareItems() {

        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));


        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));

        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));

        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));

        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));

        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                break;
            case R.id.my_cart:
                startActivity(new Intent(BuyNow.this,MyCart.class));
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */




}
