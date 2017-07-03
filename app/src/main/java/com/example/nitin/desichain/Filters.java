package com.example.nitin.desichain;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Filters extends AppCompatActivity {


    private Toolbar toolbar;
    private Button mApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        toolbar = (Toolbar) findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);


        FiltersFragment fFragment = new FiltersFragment();

        mApply=(Button)findViewById(R.id.btnApplyFilter);
        FragmentManager fm =getSupportFragmentManager();


        fm.beginTransaction().add(R.id.filtersFrameLayout,fFragment).commit();

        mApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        FilterFragmentData fFragmentData = new FilterFragmentData();
        fm.beginTransaction().add(R.id.filterSelectionFrame,fFragmentData).commit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
