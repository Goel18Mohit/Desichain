package com.example.nitin.desichain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import com.example.nitin.desichain.Adapters.CategoryAdapter;
import com.example.nitin.desichain.Contents.CategoryList;

import java.util.ArrayList;

public class CategoryPage extends AppCompatActivity {

    GridView listView;
    private ArrayList<com.example.nitin.desichain.Contents.CategoryList> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView= (GridView) findViewById(R.id.categorygridview);
        arrayList=new ArrayList<>();
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));
        arrayList.add(new CategoryList(R.mipmap.ic_launcher,"MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 4399","3.9","1667"));










        CategoryAdapter categoryAdapter=new CategoryAdapter(this,arrayList);
        listView.setAdapter(categoryAdapter);
    }

}
