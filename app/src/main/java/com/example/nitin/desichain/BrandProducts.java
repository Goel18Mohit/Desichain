package com.example.nitin.desichain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nitin.desichain.Adapters.ProductHorizontalAdapter;
import com.example.nitin.desichain.Contents.ProductHorizontal;

import java.util.ArrayList;
import java.util.List;

public class BrandProducts extends AppCompatActivity {

    private RecyclerView mBrandRecyclerView;
    private List<ProductHorizontal> mList;
    private ProductHorizontalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_products);
        mList=new ArrayList<>();
        mBrandRecyclerView=(RecyclerView)findViewById(R.id.brandRecyclerView);

        mAdapter = new ProductHorizontalAdapter(this,mList);

        GridLayoutManager manager = new GridLayoutManager(this,2);
        mBrandRecyclerView.setLayoutManager(manager);
        mBrandRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mBrandRecyclerView.setAdapter(mAdapter);

        prepareItems();
    }

    private void prepareItems() {

        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));

        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));

        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));

        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));

        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));


    }
}
