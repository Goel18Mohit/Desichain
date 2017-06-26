package com.example.nitin.desichain;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Adapters.ProductHorizontalAdapter;
import com.example.nitin.desichain.Contents.ProductHorizontal;

import java.util.ArrayList;
import java.util.List;

public class ProductPageActual extends AppCompatActivity {

    private TextView mDeletedCostText,QUANTITY_PRODUCT,PRODUCT_BUY_NOW,PRODUCT_MY_CART;;
    private RecyclerView mRecentlyViewed;
    private static int QUNANTIY=1;
    private List<ProductHorizontal> mProductsList;
    private ProductHorizontalAdapter mAdapter;
    private LinearLayout mQuesnAnswer,mReviewsLayout;
    private ImageView mShareProduct;

    private ImageButton ADD_PRODUCT_BUTTON,MINUS_PRODUCT_BUTTON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page_actual);

        mQuesnAnswer=(LinearLayout)findViewById(R.id.qna);
        ADD_PRODUCT_BUTTON= (ImageButton) findViewById(R.id.addProduct);
        MINUS_PRODUCT_BUTTON= (ImageButton) findViewById(R.id.removeProduct);
        QUANTITY_PRODUCT= (TextView) findViewById(R.id.productquantity);
        PRODUCT_BUY_NOW= (TextView) findViewById(R.id.productbuynow);
        PRODUCT_MY_CART= (TextView) findViewById(R.id.productmycart);

        mRecentlyViewed = (RecyclerView) findViewById(R.id.recentlyView);
        mProductsList = new ArrayList<>();
        mAdapter=new ProductHorizontalAdapter(this, mProductsList);
        LinearLayoutManager lm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        mRecentlyViewed.setLayoutManager(lm);
        mRecentlyViewed.setItemAnimator(new DefaultItemAnimator());
        mRecentlyViewed.setScrollBarSize(0);
        mRecentlyViewed.setAdapter(mAdapter);
        mShareProduct=(ImageView)findViewById(R.id.shareProduct);

        addItems();

        mShareProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_SUBJECT,"sharing Url");
                sendIntent.putExtra(Intent.EXTRA_TEXT,"http://www.google.com");
                startActivity(sendIntent);
            }
        });

        mReviewsLayout=(LinearLayout)findViewById(R.id.reviewsLayout);
        mReviewsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),RatingReviews.class));
            }
        });

        mQuesnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),QuestionandAnser.class));
            }
        });

        ADD_PRODUCT_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QUNANTIY=QUNANTIY+1;
                QUANTITY_PRODUCT.setText(String.valueOf(QUNANTIY));
            }
        });
        MINUS_PRODUCT_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(QUNANTIY<2)
                {
                    QUNANTIY=2;
                }
                QUNANTIY=QUNANTIY-1;
                QUANTITY_PRODUCT.setText(String.valueOf(QUNANTIY));

            }
        });

        PRODUCT_BUY_NOW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductPageActual.this,BuyNow.class);
                intent.putExtra("STATUSFLAG",401);
                startActivity(intent);
                finish();
            }
        });
        PRODUCT_MY_CART.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ProductPageActual.this,MyCart.class);
                intent.putExtra("STATUSFLAG",402);
                startActivity(intent);
                finish();
            }
        });
        mDeletedCostText=(TextView) findViewById(R.id.deletedCost);
        mDeletedCostText.setPaintFlags(mDeletedCostText.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_cart_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==android.R.id.home){
            finish();
        }
        else if (item.getItemId()==R.id.my_cart){
            startActivity(new Intent(ProductPageActual.this,MyCart.class));
        }
        return true;
    }

    private void addItems() {

        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
    }
}
