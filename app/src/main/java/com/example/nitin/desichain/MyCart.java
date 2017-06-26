package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Adapters.SingleCartAdapter;
import com.example.nitin.desichain.Contents.SingleCart;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity  implements SingleCartAdapter.ListChange{

    private LinearLayout mCheckoutLayout,mPlaceOrderLayout;
    private RecyclerView mCartRecyclerView;
    private List<SingleCart> mList;
    private SingleCartAdapter mAdapter;
    private TextView ITEM_COUNT;

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
        ITEM_COUNT= (TextView) findViewById(R.id.itemsCount);
        prepareItems();

        ITEM_COUNT.setText(String.valueOf(mList.size()));
        mPlaceOrderLayout=(LinearLayout)findViewById(R.id.placeOrderLayout);
        mPlaceOrderLayout.setBackgroundColor(getResources().getColor(R.color.green));


        mCheckoutLayout=(LinearLayout)findViewById(R.id.checkoutLayout);
        mCheckoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyCart.this,BuyNow.class));
            }
        });

        Intent intent=getIntent();
        if(intent!=null)
        {
            if(intent.getIntExtra("STATUSFLAG",0)==402){
                mList.add(new SingleCart(R.mipmap.ic_launcher,
                        10,
                        12000,
                        "NEW ITEM IS ADDED DESICHAIN",
                        "DESICHAIN"));
                ITEM_COUNT.setText(String.valueOf(mList.size()));
                mAdapter.notifyDataSetChanged();
            }
        }


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
    public void change() {
        ITEM_COUNT.setText(String.valueOf(mList.size()));
    }
}
