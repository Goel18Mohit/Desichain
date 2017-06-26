package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.nitin.desichain.Adapters.SingleCartAdapter;
import com.example.nitin.desichain.Contents.SingleCart;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {

    private LinearLayout mCheckoutLayout,mPlaceOrderLayout;
    private RecyclerView mCartRecyclerView;
    private List<SingleCart> mList;
    private SingleCartAdapter mAdapter;

    int k=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        mCartRecyclerView=(RecyclerView)findViewById(R.id.cartView);
        mList=new ArrayList<>();
        mAdapter=new SingleCartAdapter(this,mList);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        mCartRecyclerView.setLayoutManager(lm);
        mCartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mCartRecyclerView.setAdapter(mAdapter);

        prepareItems();

        mPlaceOrderLayout=(LinearLayout)findViewById(R.id.placeOrderLayout);
        mPlaceOrderLayout.setBackgroundColor(getResources().getColor(R.color.green));


        mCheckoutLayout=(LinearLayout)findViewById(R.id.checkoutLayout);
        mCheckoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyCart.this,BuyNow.class));
            }
        });

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

}
