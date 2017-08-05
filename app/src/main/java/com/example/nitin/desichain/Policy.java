package com.example.nitin.desichain;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Contents.Advertisements;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Policy extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private Helper listView;
    ArrayList<CategoryHolder> arrayList;
    public ArrayList<String> Books;
    private List<Advertisements> mPics;
    ArrayList<String> Poojaitem;
    NestedScrollView nestedScrollView;
    ArrayList<String> Healthandfood;
    DrawerLayout drawer;
    int count = 2;
    TextView txtViewCount;
    ImageView toolbarcartimage;
    ArrayList<String> others;
    HashMap<String, ArrayList<String>> hashMap;
    View headerView;
    ;
    private LinearLayout mCustomerServiceLayout, mShippingLayout, mReturnLayout;
    private int RETURN_CLICKS = 0, CUSTOMER_CLICKS = 0;
    private FragmentManager fragmentManager;
    final ReturnPolicy returnPolicy = new ReturnPolicy();
    final CustomerService customerService = new CustomerService();
    public static ArrayList<String> Homecare;
    ImageView SHIPPING_POLICY_BUTTON, mImgReturnPolicy, mImgCustomerService;
    public static int SHIPPING_FLAG = 0;
    final ShippingPolicy shippingPolicy = new ShippingPolicy();
    LinearLayout myorder, mycart, myaccount, helpcenter, ratedesichain, productPage, policy, facebook, google, twitter, pinterest, youtube, instagram, aboutus;
    LinearLayout subscribe;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        mToolbar = (Toolbar) findViewById(R.id.myToolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);

        mImgCustomerService = (ImageView) findViewById(R.id.imgCustomerService);
        mImgReturnPolicy = (ImageView) findViewById(R.id.imgReturnPolicy);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        SHIPPING_POLICY_BUTTON = (ImageView) findViewById(R.id.imgShippingPolicy);

        mCustomerServiceLayout = (LinearLayout) findViewById(R.id.customerService);
        mShippingLayout = (LinearLayout) findViewById(R.id.shipping_policy);
        mReturnLayout = (LinearLayout) findViewById(R.id.return_policy);
        textView = (TextView) findViewById(R.id.rpt);
        fragmentManager = getSupportFragmentManager();


        mCustomerServiceLayout.setOnClickListener(this);
        mShippingLayout.setOnClickListener(this);
        mReturnLayout.setOnClickListener(this);
        textView.setOnClickListener(this);
        mImgReturnPolicy.setOnClickListener(this);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        //drawer.setDrawerListener(toggle);
        // toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        refferencetonavigationcategory(navigationView);
        nestedScrollView = (NestedScrollView) navigationView.findViewById(R.id.scrollposition);
        listView = (Helper) navigationView.findViewById(R.id.parentcategoryList);
        initiaze();
        add();

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.imgReturnPolicy:
            case R.id.rpt:

                if (RETURN_CLICKS == 0) {


                    Toast.makeText(Policy.this, "clicked", Toast.LENGTH_SHORT).show();
                    if (CUSTOMER_CLICKS == 1) {
                        fragmentManager.beginTransaction().remove(customerService).commit();
                        mImgCustomerService.setImageResource(R.mipmap.ic_add_black_24dp);
                        CUSTOMER_CLICKS = 0;
                    }
                    if (SHIPPING_FLAG == 1) {
                        fragmentManager.beginTransaction().remove(shippingPolicy).commit();
                        SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_add_black_24dp);
                        SHIPPING_FLAG = 0;
                    }
                    fragmentManager.beginTransaction().replace(R.id.fragment_return_policy, returnPolicy).commit();
                    RETURN_CLICKS = 1;
                    mImgReturnPolicy.setImageResource(R.mipmap.ic_remove_black_24dp);
                } else if (RETURN_CLICKS == 1) {


                    fragmentManager.beginTransaction().remove(returnPolicy).commit();
                    RETURN_CLICKS = 0;
                    mImgReturnPolicy.setImageResource(R.mipmap.ic_add_black_24dp);
                }
                break;
            case R.id.customerService:


                if (CUSTOMER_CLICKS == 0) {
                    if (SHIPPING_FLAG == 1) {
                        fragmentManager.beginTransaction().remove(shippingPolicy).commit();
                        SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_add_black_24dp);
                        SHIPPING_FLAG = 0;
                    }
                    if (RETURN_CLICKS == 1) {
                        fragmentManager.beginTransaction().remove(returnPolicy).commit();
                        mImgReturnPolicy.setImageResource(R.mipmap.ic_add_black_24dp);
                        RETURN_CLICKS = 0;
                    }

                    fragmentManager.beginTransaction().replace(R.id.fragment_customer_Service, customerService).commit();
                    CUSTOMER_CLICKS = 1;
                    mImgCustomerService.setImageResource(R.mipmap.ic_remove_black_24dp);

                } else if (CUSTOMER_CLICKS == 1) {

                    fragmentManager.beginTransaction().remove(customerService).commit();
                    CUSTOMER_CLICKS = 0;
                    mImgCustomerService.setImageResource(R.mipmap.ic_add_black_24dp);
                }
                break;
            case R.id.shipping_policy:


                if (SHIPPING_FLAG == 0) {
                    if (CUSTOMER_CLICKS == 1) {
                        fragmentManager.beginTransaction().remove(customerService).commit();
                        mImgCustomerService.setImageResource(R.mipmap.ic_add_black_24dp);
                        CUSTOMER_CLICKS = 0;

                    }
                    if (RETURN_CLICKS == 1) {
                        fragmentManager.beginTransaction().remove(returnPolicy).commit();
                        mImgReturnPolicy.setImageResource(R.mipmap.ic_add_black_24dp);
                        RETURN_CLICKS = 0;
                    }
                    fragmentManager.beginTransaction().replace(R.id.shippingfragment, shippingPolicy).commit();
                    SHIPPING_FLAG = 1;

                    SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_remove_black_24dp);
                } else if (SHIPPING_FLAG == 1) {
                    fragmentManager.beginTransaction().remove(shippingPolicy).commit();
                    SHIPPING_POLICY_BUTTON.setImageResource(R.mipmap.ic_add_black_24dp);
                    SHIPPING_FLAG = 0;
                }
                break;

            default:
                new Utility().openIntent(this, v.getId(), drawer);
                break;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.my_cart);
        MenuItemCompat.setActionView(menuItem, R.layout.cart_icon_for_toolbar);
        RelativeLayout mycarttoolbar = (RelativeLayout) MenuItemCompat.getActionView(menuItem);
        txtViewCount = (TextView) mycarttoolbar.findViewById(R.id.badge_notification_1);
        toolbarcartimage = (ImageView) mycarttoolbar.findViewById(R.id.badge_notification_image);
        count++;
        toolbarcartimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Policy.this, MyCart.class));
            }
        });
        txtViewCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Policy.this, MyCart.class));
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else {
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

            case R.id.search_item:
                startActivity(new Intent(this, SearchActivity.class));
                break;
        }

        return true;
    }

    public void add() {
        arrayList.add(new CategoryHolder("Book and media", 0, R.mipmap.book));
        arrayList.add(new CategoryHolder("Pooja Item", 0, R.mipmap.pooja));
        arrayList.add(new CategoryHolder("Home Care", 0, R.mipmap.homecare));
        arrayList.add(new CategoryHolder("Others", 0, R.mipmap.other));
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
        hashMap.put(arrayList.get(0).getPARENTCATEGORY(), Books);
        hashMap.put(arrayList.get(1).getPARENTCATEGORY(), Poojaitem);
        hashMap.put(arrayList.get(2).getPARENTCATEGORY(), Homecare);
        hashMap.put(arrayList.get(3).getPARENTCATEGORY(), others);
        navigationCategoryList();
    }

    public void initiaze() {
        arrayList = new ArrayList<>();
        hashMap = new HashMap<>();
        Books = new ArrayList<>();
        Poojaitem = new ArrayList<>();
        Homecare = new ArrayList<>();
        others = new ArrayList<>();

    }

    public void navigationCategoryList() {
        final ShowCategoryAdapeter showCategoryAdapeter = new ShowCategoryAdapeter(Policy.this, arrayList, hashMap, listView);
        listView.setAdapter(showCategoryAdapeter);
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (arrayList.get(groupPosition).getFLAG_INDICATOR() == 1) {
                    listView.collapseGroup(groupPosition);
                    arrayList.get(groupPosition).setFLAG_INDICATOR(0);

                } else {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getFLAG_INDICATOR() == 1) {
                            listView.collapseGroup(i);
                            arrayList.get(i).setFLAG_INDICATOR(0);
                        }

                    }
                    listView.expandGroup(groupPosition);
                    listView.setSelectedGroup(groupPosition);
                    nestedScrollView.smoothScrollTo(0, groupPosition);
                    arrayList.get(groupPosition).setFLAG_INDICATOR(1);

                }
                return true;
            }
        });
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(Policy.this, Childcategoru.class);
                intent.putExtra("get", hashMap.get(arrayList.get(groupPosition).getPARENTCATEGORY()).get(childPosition));
                intent.putExtra("getFilterName", String.valueOf(arrayList.get(groupPosition).getPARENTCATEGORY()));
                startActivity(intent);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                for (int i = 0; i < parent.getCount(); ++i) {
                    if (parent.isGroupExpanded(i)) {
                        parent.collapseGroup(i);
                    }
                }
                return true;
            }
        });

    }

    public void refferencetonavigationcategory(View view) {
        myorder = (LinearLayout) view.findViewById(R.id.myorders);
        mycart = (LinearLayout) view.findViewById(R.id.mycart);
        myaccount = (LinearLayout) view.findViewById(R.id.myaccount);
        helpcenter = (LinearLayout) view.findViewById(R.id.helpcenter);
        ratedesichain = (LinearLayout) view.findViewById(R.id.ratedesichain);
        policy = (LinearLayout) view.findViewById(R.id.policy);
        facebook = (LinearLayout) view.findViewById(R.id.facebook);
        google = (LinearLayout) view.findViewById(R.id.googleplus);
        twitter = (LinearLayout) view.findViewById(R.id.twitter);
        pinterest = (LinearLayout) view.findViewById(R.id.pinterest);
        youtube = (LinearLayout) view.findViewById(R.id.youtube);
        instagram = (LinearLayout) view.findViewById(R.id.instagram);
        aboutus = (LinearLayout) view.findViewById(R.id.aboutus);
        subscribe = (LinearLayout) findViewById(R.id.subscribe);
        myorder.setOnClickListener(this);
        mycart.setOnClickListener(this);
        myaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("myPref",MODE_PRIVATE);
                String email = preferences.getString("emailId","none");
                String pwd = preferences.getString("password","none");

                if (email.equals("none") && pwd.equals("none")){
                    startActivity(new Intent(Policy.this,LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(Policy.this,MyAccount.class));

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


}
