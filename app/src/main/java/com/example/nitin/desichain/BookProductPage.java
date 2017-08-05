package com.example.nitin.desichain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Adapters.ProductHorizontalAdapter;
import com.example.nitin.desichain.Contents.*;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Karan on 28-07-2017.
 */

public class BookProductPage extends AppCompatActivity implements View.OnClickListener{

    private TextView mDeletedCostText,QUANTITY_PRODUCT,PRODUCT_BUY_NOW,PRODUCT_MY_CART;;
    private RecyclerView mRecentlyViewed;
    private static int QUNANTIY=1;
    private int productCost = 850;
    private Toolbar mToolbar;
    private TextView mTotalCostText,mBrandName;
    int count=2;
    TextView txtViewCount;
    ImageView toolbarcartimage;
    private ArrayList<com.example.nitin.desichain.Contents.CategoryList> mProductsList;
    private CheckBox mSecCheckBox,mThirdCheckBox;
    private ProductHorizontalAdapter mAdapter;
    private LinearLayout mQuesnAnswer,mReviewsLayout,mReviewsProductLayout;
    private ImageView mShareProduct,mPlusForSecImage,mPlusForThirdImage,mSecImage,mThirdImage;

    LinearLayout subscribe;
    private ImageButton ADD_PRODUCT_BUTTON,MINUS_PRODUCT_BUTTON;


    private Helper listView;
    View headerView;
    DrawerLayout drawer;
    NestedScrollView nestedScrollView;
    public static ArrayList<String> Poojaitem;
    public  static ArrayList<CategoryHolder> arrayList;
    public static  ArrayList<String> Books;
    public static ArrayList<String> Homecare;
    public static   ArrayList<String> others;
    public  static HashMap<String,ArrayList<String>> hashMap;
    LinearLayout myorder,mycart,myaccount,helpcenter,ratedesichain,productPage,policy,facebook,google,twitter,pinterest,youtube,instagram,aboutus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page_actual);

        mToolbar=(Toolbar)findViewById(R.id.myToolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        mBrandName = (TextView)findViewById(R.id.brandName);
        mBrandName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookProductPage.this, BrandProducts.class));
            }
        });
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        refferencetonavigationcategory(navigationView);
        nestedScrollView= (NestedScrollView) navigationView.findViewById(R.id.scrollposition);
        listView= (Helper) navigationView.findViewById(R.id.parentcategoryList);
        initiaze();
        add();

        mSecCheckBox=(CheckBox)findViewById(R.id.secondImageCheck);
        mThirdCheckBox=(CheckBox)findViewById(R.id.thirdImageCheck);
        mPlusForSecImage=(ImageView)findViewById(R.id.plusIconFor2ndImage);
        mPlusForThirdImage=(ImageView)findViewById(R.id.plusIconFor3rdImage);
        mSecImage=(ImageView)findViewById(R.id.secondImageCombo);
        mThirdImage=(ImageView)findViewById(R.id.thirdImageCombo);
        mReviewsProductLayout=(LinearLayout)findViewById(R.id.reviewsProductPage);
        mQuesnAnswer=(LinearLayout)findViewById(R.id.qna);
        ADD_PRODUCT_BUTTON= (ImageButton) findViewById(R.id.addProduct);
        MINUS_PRODUCT_BUTTON= (ImageButton) findViewById(R.id.removeProduct);
        QUANTITY_PRODUCT= (TextView) findViewById(R.id.productquantity);
        PRODUCT_BUY_NOW= (TextView) findViewById(R.id.productbuynow);
        PRODUCT_MY_CART= (TextView) findViewById(R.id.productmycart);
        mTotalCostText=(TextView)findViewById(R.id.totalPrice);


        mTotalCostText.setText("Total Price is Rs:"+productCost);
        mSecCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mSecCheckBox.isChecked()){
                    mTotalCostText.setText("Total Price is Rs:"+String.valueOf(productCost*2));
                    mPlusForSecImage.setVisibility(View.VISIBLE);
                    mSecImage.setVisibility(View.VISIBLE);
                }
                else if(!mSecCheckBox.isChecked()){
                    mTotalCostText.setText("Total Price is Rs:"+String.valueOf(productCost));
                    mPlusForSecImage.setVisibility(View.GONE);
                    mSecImage.setVisibility(View.GONE);
                }

            }
        });

        mThirdCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (mThirdCheckBox.isChecked()){
                    mTotalCostText.setText("Total Price is Rs:"+String.valueOf(productCost*2));
                    mPlusForThirdImage.setVisibility(View.VISIBLE);
                    mThirdImage.setVisibility(View.VISIBLE);
                }
                else if (!mThirdCheckBox.isChecked()) {
                    mTotalCostText.setText("Total Price is Rs:"+String.valueOf(productCost));
                    mPlusForThirdImage.setVisibility(View.GONE);
                    mThirdImage.setVisibility(View.GONE);

                }
            }
        });


        mRecentlyViewed = (RecyclerView) findViewById(R.id.recentlyView);
        mProductsList = new ArrayList<>();

        addItems();
        mAdapter=new ProductHorizontalAdapter(this, mProductsList);
        GridLayoutManager lm = new GridLayoutManager(this,2);
        mRecentlyViewed.setLayoutManager(lm);
        mRecentlyViewed.setItemAnimator(new DefaultItemAnimator());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mRecentlyViewed.setScrollBarSize(0);
        }
        mRecentlyViewed.setAdapter(mAdapter);

        mShareProduct=(ImageView)findViewById(R.id.shareProduct);


        mReviewsProductLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookProductPage.this,RatingReviews.class));
            }
        });

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
                Intent intent=new Intent(BookProductPage.this,BuyNow.class);
                intent.putExtra("STATUSFLAG",401);
                startActivity(intent);
                finish();
            }
        });
        PRODUCT_MY_CART.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(BookProductPage.this,MyCart.class);
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
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem=menu.findItem(R.id.my_cart);
        MenuItemCompat.setActionView(menuItem,R.layout.cart_icon_for_toolbar);
        RelativeLayout mycarttoolbar= (RelativeLayout) MenuItemCompat.getActionView(menuItem);
        txtViewCount = (TextView) mycarttoolbar.findViewById(R.id.badge_notification_1);
        toolbarcartimage= (ImageView) mycarttoolbar.findViewById(R.id.badge_notification_image);
        count++;
        toolbarcartimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookProductPage.this,MyCart.class));
            }
        });
        txtViewCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookProductPage.this,MyCart.class));
            }
        });

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if(drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawer(Gravity.LEFT);
                }else{
                    finish();
                }
                break;
            case R.id.my_orders:
                startActivity(new Intent(this, MyOrders.class));
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                break;
            case R.id.notifications:
                startActivity(new Intent(this, NotificationPage.class));
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                break;
        }
        if (item.getItemId()==R.id.search_item){
            startActivity(new Intent(this,SearchActivity.class));
        }

        return true;
    }

    private void addItems() {


        for (int i=0;i<5;i++){
//            mProductsList.add(new ProductHorizontal("product name",1200,"data:image/png;base64,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"
//                    ,"12","4.0",17));

        }

    }

    public void add()
    {
        arrayList.add(new CategoryHolder("Book and media",0,R.mipmap.book));
        arrayList.add(new CategoryHolder("Pooja Item",0,R.mipmap.pooja));
        arrayList.add(new CategoryHolder("Home Care",0,R.mipmap.homecare));
        arrayList.add(new CategoryHolder("Others",0,R.mipmap.other));
        Books.add("Bhagavad-Gita As It Is");
        Books.add("Paperback/ Hardbound");
        Books.add("Media");
        Poojaitem.add("Items for Worship");
        Poojaitem.add("Other Essentials");
        Poojaitem.add("Bells");
        Poojaitem.add("Agarbatti/ Dhoop");
        Poojaitem.add("Murtis/ Deities");
        Homecare.add("Home Decor");
        Homecare.add("Home Furnishing");
        Homecare.add("Kitchen n Dinning");
        others.add("Personal Care");
        others.add("Health & Food");
        others.add("Fshion Accessiories");
        others.add("Women");
        others.add("Men");
        others.add("BagsnStationery");
        others.add("MobileAccessiories");
        hashMap.put(arrayList.get(0).getPARENTCATEGORY(),Books);
        hashMap.put(arrayList.get(1).getPARENTCATEGORY(),Poojaitem);
        hashMap.put(arrayList.get(2).getPARENTCATEGORY(),Homecare);
        hashMap.put(arrayList.get(3).getPARENTCATEGORY(),others);
        navigationCategoryList();
    }

    public void initiaze(){
        arrayList=new ArrayList<>();
        hashMap=new HashMap<>();
        Books=new ArrayList<>();
        Poojaitem=new ArrayList<>();
        Homecare=new ArrayList<>();
        others=new ArrayList<>();

    }
    public void navigationCategoryList(){
        final ShowCategoryAdapeter showCategoryAdapeter=new ShowCategoryAdapeter(BookProductPage.this,arrayList,hashMap,listView);
        listView.setAdapter(showCategoryAdapeter);
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if(arrayList.get(groupPosition).getFLAG_INDICATOR()==1)
                {
                    listView.collapseGroup(groupPosition);
                    arrayList.get(groupPosition).setFLAG_INDICATOR(0);

                }
                else{
                    for(int i=0;i<arrayList.size();i++)
                    {
                        if(arrayList.get(i).getFLAG_INDICATOR()==1)
                        {
                            listView.collapseGroup(i);
                            arrayList.get(i).setFLAG_INDICATOR(0);
                        }

                    }
                    listView.expandGroup(groupPosition);
                    listView.setSelectedGroup(groupPosition);
                    nestedScrollView.smoothScrollTo(0,groupPosition);
                    arrayList.get(groupPosition).setFLAG_INDICATOR(1);

                }
                return true;
            }
        });
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent=new Intent(BookProductPage.this,Childcategoru.class);
                intent.putExtra("get",hashMap.get(arrayList.get(groupPosition).getPARENTCATEGORY()).get(childPosition));
                intent.putExtra("getFilterName",String.valueOf(arrayList.get(groupPosition).getPARENTCATEGORY()));
                startActivity(intent);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                for (int i=0; i<parent.getCount(); ++i) {
                    if (parent.isGroupExpanded(i)) {
                        parent.collapseGroup(i);
                    }
                }
                return true;
            }
        });

    }

    public void refferencetonavigationcategory(View view)
    {
        myorder= (LinearLayout) view.findViewById(R.id.myorders);
        mycart= (LinearLayout) view.findViewById(R.id.mycart);
        myaccount= (LinearLayout) view.findViewById(R.id.myaccount);
        helpcenter= (LinearLayout) view.findViewById(R.id.helpcenter);
        ratedesichain= (LinearLayout) view.findViewById(R.id.ratedesichain);
        policy= (LinearLayout) view.findViewById(R.id.policy);
        facebook= (LinearLayout) view.findViewById(R.id.facebook);
        google=(LinearLayout) view.findViewById(R.id.googleplus);
        twitter= (LinearLayout) view.findViewById(R.id.twitter);
        pinterest= (LinearLayout) view.findViewById(R.id.pinterest);
        youtube= (LinearLayout) view.findViewById(R.id.youtube);
        instagram= (LinearLayout) view.findViewById(R.id.instagram);
        aboutus= (LinearLayout) view.findViewById(R.id.aboutus);
        subscribe= (LinearLayout) findViewById(R.id.subscribe);
        myorder.setOnClickListener(this);
        mycart.setOnClickListener(this);
        myaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("myPref",MODE_PRIVATE);
                String email = preferences.getString("emailId","none");
                String pwd = preferences.getString("password","none");

                if (email.equals("none") && pwd.equals("none")){
                    startActivity(new Intent(BookProductPage.this,LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(BookProductPage.this,MyAccount.class));

                }
            }
        });
        helpcenter.setOnClickListener(this);
        ratedesichain.setOnClickListener(this);
        policy.setOnClickListener(this);
        facebook.setOnClickListener(this);
        google.setOnClickListener(this);
        twitter.setOnClickListener(this);
        pinterest.setOnClickListener(this);
        youtube.setOnClickListener(this);
        instagram.setOnClickListener(this);
        aboutus.setOnClickListener(this);
        subscribe.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        new Utility().openIntent(this,v.getId(),drawer);
    }
}
