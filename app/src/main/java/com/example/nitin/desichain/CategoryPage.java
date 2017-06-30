package com.example.nitin.desichain;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Adapters.CategoryAdapter;
import com.example.nitin.desichain.Contents.CategoryList;

import java.util.ArrayList;

public class CategoryPage extends AppCompatActivity {

    GridView listView;
    TextView SORT_OPTION,FILTER_OPTION;
    private Toolbar mToolbar;
    private ArrayList<com.example.nitin.desichain.Contents.CategoryList> arrayList;
    final CharSequence[] sortoption={"Relevance","Popularity","Price Low To High","Price High To Low","Discount","Fresh Arrivals"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FILTER_OPTION=(TextView)findViewById(R.id.filter);
        listView= (GridView) findViewById(R.id.categorygridview);
        SORT_OPTION= (TextView) findViewById(R.id.sort);
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
        SORT_OPTION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertdialog=new AlertDialog.Builder(CategoryPage.this);
                alertdialog.setTitle("Sort");
                alertdialog.setSingleChoiceItems(sortoption, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CategoryPage.this,"clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                alertdialog.create().show();

            }
        });

        FILTER_OPTION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryPage.this,Filters.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_cart_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.my_cart){
            startActivity(new Intent(CategoryPage.this,MyCart.class));
        }

        if (item.getItemId() == android.R.id.home){
            finish();

        }
        return super.onOptionsItemSelected(item);
    }
}
