package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {


    ArrayList<String> PREVIOUS_SEARCHED;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        listView= (ListView) findViewById(R.id.previoussearched);
        PREVIOUS_SEARCHED=new ArrayList<>();
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        PREVIOUS_SEARCHED.add("BOOKS");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(SearchActivity.this,android.R.layout.simple_list_item_1,PREVIOUS_SEARCHED);
        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mysearch,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            Intent intent=new Intent(SearchActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        switch (item.getItemId()) {
            case R.id.my_cart:
                startActivity(new Intent(SearchActivity.this, MyCart.class));
                break;
            case R.id.notifications:
                Toast.makeText(SearchActivity.this, "Notifications item selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_orders:
                startActivity(new Intent(SearchActivity.this, MyOrders.class));
                break;

        }
        return true;
    }
}


