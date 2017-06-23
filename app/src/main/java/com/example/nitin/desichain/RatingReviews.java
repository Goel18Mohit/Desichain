package com.example.nitin.desichain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.nitin.desichain.Adapters.RatingAdapter;
import com.example.nitin.desichain.Contents.RatingContent;

import java.util.ArrayList;
import java.util.List;

public class RatingReviews extends AppCompatActivity {

    private RecyclerView mRatingReviewView;
    private List<RatingContent> mList;
    private RatingAdapter mAdapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_cart_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.my_cart){
            startActivity(new Intent(RatingReviews.this,MyCart.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_reviews);

        mRatingReviewView=(RecyclerView)findViewById(R.id.reviewRatingView);
        mList=new ArrayList<>();
        mAdapter=new RatingAdapter(this,mList);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        mRatingReviewView.setLayoutManager(lm);
        mRatingReviewView.setItemAnimator(new DefaultItemAnimator());
        mRatingReviewView.setAdapter(mAdapter);

        TextView text = (TextView)findViewById(R.id.writeReview);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),WriteReview.class));
            }
        });

        prepareItems();
    }

    private void prepareItems() {

        mList.add(new RatingContent("Rohit","09 Oct 16","Very good product "));
        mList.add(new RatingContent("Rohit","09 Oct 16","Very good product "));
        mList.add(new RatingContent("Rohit","09 Oct 16","Very good product "));
        mList.add(new RatingContent("Rohit","09 Oct 16","Very good product "));
        mList.add(new RatingContent("Rohit","09 Oct 16","Very good product "));
        mList.add(new RatingContent("Rohit","09 Oct 16","Very good product "));
        mList.add(new RatingContent("Rohit","09 Oct 16","Very good product "));
        mList.add(new RatingContent("Rohit","09 Oct 16","Very good product "));
        mList.add(new RatingContent("Rohit","09 Oct 16","Very good product "));


    }
}
