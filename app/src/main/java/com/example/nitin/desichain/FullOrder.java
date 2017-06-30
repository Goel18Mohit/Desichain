package com.example.nitin.desichain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nitin.desichain.Adapters.FullOrderAdapter;
import com.example.nitin.desichain.Contents.FullOrderContent;

import java.util.ArrayList;
import java.util.List;

public class FullOrder extends AppCompatActivity {

    private RecyclerView mFullOrderRecyclerView;
    private List<FullOrderContent> mFullOrderList;
    private FullOrderAdapter mAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_order);
        setTitle("Order Id: 12016");


        mToolbar=(Toolbar)findViewById(R.id.myToolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);


        mFullOrderRecyclerView=(RecyclerView)findViewById(R.id.fullOrderListRecyclerView);
        mFullOrderList=new ArrayList<>();
        mAdapter=new FullOrderAdapter(this,mFullOrderList);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        mFullOrderRecyclerView.setLayoutManager(lm);
        mFullOrderRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFullOrderRecyclerView.setAdapter(mAdapter);

        prepareItems();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_cart_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== R.id.my_cart){
            startActivity(new Intent(FullOrder.this,MyCart.class));
        }

        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void prepareItems() {


        mFullOrderList.add(new FullOrderContent("Patanjali","DantKanti",120,2));

        mFullOrderList.add(new FullOrderContent("Patanjali","DantKanti",120,230));

        mFullOrderList.add(new FullOrderContent("Patanjali","DantKanti",120,24));

        mFullOrderList.add(new FullOrderContent("Patanjali","DantKanti",120,21));
        mFullOrderList.add(new FullOrderContent("Patanjali","DantKanti",120,20));



    }
}
