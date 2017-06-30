package com.example.nitin.desichain;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nitin.desichain.Adapters.ProductHorizontalAdapter;
import com.example.nitin.desichain.Contents.ProductHorizontal;

import java.util.ArrayList;
import java.util.List;

public class BrandProducts extends AppCompatActivity {

    private RecyclerView mBrandRecyclerView;
    private List<ProductHorizontal> mList;
    private ProductHorizontalAdapter mAdapter;
    private Toolbar mToolbar;



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }

        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_products);
        mList=new ArrayList<>();
        mBrandRecyclerView=(RecyclerView)findViewById(R.id.brandRecyclerView);

        mToolbar = (Toolbar)findViewById(R.id.myToolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Brand Name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


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
