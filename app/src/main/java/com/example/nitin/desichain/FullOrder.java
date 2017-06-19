package com.example.nitin.desichain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nitin.desichain.Adapters.FullOrderAdapter;
import com.example.nitin.desichain.Contents.FullOrderContent;

import java.util.ArrayList;
import java.util.List;

public class FullOrder extends AppCompatActivity {

    private RecyclerView mFullOrderRecyclerView;
    private List<FullOrderContent> mFullOrderList;
    private FullOrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_order);
        setTitle("Order Id: 12016");

        mFullOrderRecyclerView=(RecyclerView)findViewById(R.id.fullOrderListRecyclerView);
        mFullOrderList=new ArrayList<>();
        mAdapter=new FullOrderAdapter(this,mFullOrderList);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        mFullOrderRecyclerView.setLayoutManager(lm);
        mFullOrderRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFullOrderRecyclerView.setAdapter(mAdapter);

        prepareItems();
    }

    private void prepareItems() {


        mFullOrderList.add(new FullOrderContent("Patanjali","DantKanti",120,2));

        mFullOrderList.add(new FullOrderContent("Patanjali","DantKanti",120,230));

        mFullOrderList.add(new FullOrderContent("Patanjali","DantKanti",120,24));

        mFullOrderList.add(new FullOrderContent("Patanjali","DantKanti",120,21));
        mFullOrderList.add(new FullOrderContent("Patanjali","DantKanti",120,20));



    }
}
