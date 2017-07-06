package com.example.nitin.desichain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.nitin.desichain.Adapters.CouponAdapter;
import com.example.nitin.desichain.Adapters.NotificationAdapter;
import com.example.nitin.desichain.Contents.Coupons;
import com.example.nitin.desichain.Contents.Notifications;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karan on 05-07-2017.
 */

public class CouponsPage extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private List<Coupons> mCoupons;
    private CouponAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_coupon_page);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        mRecyclerView = (RecyclerView) findViewById(R.id.couponRecyclerView);
        mCoupons = new ArrayList<>();
        mAdapter = new CouponAdapter(this, mCoupons);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareItems();

    }

    private void prepareItems() {
        mCoupons.add(new Coupons("Flat 50%","Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah"));
        mCoupons.add(new Coupons("Flat 50%","Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah"));
        mCoupons.add(new Coupons("Flat 50%","Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah"));
        mCoupons.add(new Coupons("Flat 50%","Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah Blah Blah Blah BlahBlahBlahBlah Blah Blah Blah BlahBlahBlahBlahBlahBlah Blah Blah Blah Blah Blah"));

    }
}
