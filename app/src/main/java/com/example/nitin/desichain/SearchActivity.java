package com.example.nitin.desichain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Internet.FetchingFromUrl;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SearchActivity extends AppCompatActivity {


    ArrayList<com.example.nitin.desichain.Contents.CategoryList> PREVIOUS_SEARCHED;
    ListView listView;
    int count=2;
    TextView txtViewCount;
    ImageView  toolbarcartimage;
    private String JSON_RESPONSE;
    EditText searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        invalidateOptionsMenu();

        searchText = (EditText) findViewById(R.id.search_editTextView);
        listView= (ListView) findViewById(R.id.previoussearched);
        PREVIOUS_SEARCHED=new ArrayList<>();

        searchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // Identifier of the action. This will be either the identifier you supplied,
                // or EditorInfo.IME_NULL if being called due to the enter key being pressed.
                if (actionId == EditorInfo.IME_ACTION_SEARCH
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || event.getAction() == KeyEvent.ACTION_DOWN
                        && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    Log.i("Karan",v.getText().toString());
                    InputMethodManager inputManager =
                            (InputMethodManager) getApplicationContext().
                                    getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(
                            getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    Intent intent = new Intent(SearchActivity.this, ShowSearchResult.class);
                    intent.putExtra("query",v.getText().toString());
                    startActivity(intent);
                    return true;
                }
                // Return true if you have consumed the action, else false.
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem=menu.findItem(R.id.my_cart);
        MenuItem item = menu.findItem(R.id.search_item);
        item.setVisible(false);
        MenuItemCompat.setActionView(menuItem,R.layout.cart_icon_for_toolbar);
        RelativeLayout mycarttoolbar= (RelativeLayout) MenuItemCompat.getActionView(menuItem);
        txtViewCount = (TextView) mycarttoolbar.findViewById(R.id.badge_notification_1);
        toolbarcartimage= (ImageView) mycarttoolbar.findViewById(R.id.badge_notification_image);
        count++;
        toolbarcartimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchActivity.this,MyCart.class));
            }
        });
        txtViewCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchActivity.this,MyCart.class));
            }
        });

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
//            Intent intent=new Intent(SearchActivity.this,MainActivity.class);
//            startActivity(intent);
            finish();
        }


        return true;
    }
    public String load(String url) {
        try {
            JSON_RESPONSE = new FetchingFromUrl().execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return JSON_RESPONSE;

    }
}


