package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Adapters.OrderAdapter;
import com.example.nitin.desichain.Contents.Orders;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyOrders extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private List<Orders> mOrders;
    private OrderAdapter mAdapter;

    TextView txtViewCount;
    int count=2;
    private Helper listView;
    View headerView;
    DrawerLayout drawer;
    NestedScrollView nestedScrollView;
    public static ArrayList<String> Poojaitem;
    public static ArrayList<CategoryHolder> arrayList;
    public static ArrayList<String> Books;
    public static ArrayList<String> Homecare;
    public static ArrayList<String> others;
    public static HashMap<String, ArrayList<String>> hashMap;
    LinearLayout myorder, mycart, myaccount, helpcenter, ratedesichain, productPage, policy, facebook, google, twitter, pinterest, youtube, instagram, aboutus;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        mRecyclerView = (RecyclerView) findViewById(R.id.myOrderRecyclerView);
        mOrders = new ArrayList<>();
        mAdapter = new OrderAdapter(this, mOrders);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareItems();

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

    private void prepareItems() {

        mOrders.add(new Orders("01 jan 2017", "1651513", "Rs 1200", "1100", "Completed"));

        mOrders.add(new Orders("01 jan 2017", "1651513", "Rs 1200", "1100", "Completed"));

        mOrders.add(new Orders("01 jan 2017", "1651513", "Rs 1200", "1100", "Completed"));

        mOrders.add(new Orders("01 jan 2017", "1651513", "Rs 1200", "1100", "Completed"));

        mOrders.add(new Orders("01 jan 2017", "1651513", "Rs 1200", "1100", "Completed"));

        mOrders.add(new Orders("01 jan 2017", "1651513", "Rs 1200", "1100", "Completed"));
        mOrders.add(new Orders("01 jan 2017", "1651513", "Rs 1200", "1100", "Completed"));
        mOrders.add(new Orders("01 jan 2017", "1651513", "Rs 1200", "1100", "Completed"));


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            MenuItem menuItem=menu.findItem(R.id.my_cart);
            MenuItemCompat.setActionView(menuItem,R.layout.cart_icon_for_toolbar);
            RelativeLayout mycarttoolbar= (RelativeLayout) MenuItemCompat.getActionView(menuItem);
            txtViewCount = (TextView) mycarttoolbar.findViewById(R.id.badge_notification_1);
            count++;
            txtViewCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    txtViewCount.setText(String.valueOf(count++));
                }
            });

            return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        } else if (item.getItemId() == R.id.my_cart) {

            startActivity(new Intent(MyOrders.this, MyCart.class));
        }
        else if (item.getItemId()==R.id.search_item){
            startActivity(new Intent(MyOrders.this,SearchActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void add() {
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
        final ShowCategoryAdapeter showCategoryAdapeter = new ShowCategoryAdapeter(MyOrders.this, arrayList, hashMap, listView);
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

                 /*   DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                   */ return true;
                }

                /**
                 * ATTENTION: This was auto-generated to implement the App Indexing API.
                 * See https://g.co/AppIndexing/AndroidStudio for more information.
                 */

                return true;
            }
        });
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(MyOrders.this, Childcategoru.class);
                intent.putExtra("get", hashMap.get(arrayList.get(groupPosition).getPARENTCATEGORY()).get(childPosition));
                startActivity(intent);
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
        productPage = (LinearLayout) view.findViewById(R.id.myProductLayout);
        pinterest = (LinearLayout) view.findViewById(R.id.pinterest);
        youtube = (LinearLayout) view.findViewById(R.id.youtube);
        instagram = (LinearLayout) view.findViewById(R.id.instagram);
        aboutus = (LinearLayout) view.findViewById(R.id.aboutus);
        myorder.setOnClickListener(this);
        mycart.setOnClickListener(this);
        myaccount.setOnClickListener(this);
        helpcenter.setOnClickListener(this);
        productPage.setOnClickListener(this);
        ratedesichain.setOnClickListener(this);
        policy.setOnClickListener(this);
        facebook.setOnClickListener(this);
        google.setOnClickListener(this);
        twitter.setOnClickListener(this);
        pinterest.setOnClickListener(this);
        youtube.setOnClickListener(this);
        instagram.setOnClickListener(this);
        aboutus.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        new Utility().openIntent(this, v.getId(),drawer);
    }


    class MyOnClickListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            int itemClicked = mRecyclerView.getChildLayoutPosition(v);
            Log.i("ashishMyOrder.java", itemClicked + " position clicked");
        }
    }
}
