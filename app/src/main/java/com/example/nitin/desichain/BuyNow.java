package com.example.nitin.desichain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nitin.desichain.Adapters.SingleCartAdapter;
import com.example.nitin.desichain.Contents.SingleCart;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuyNow extends AppCompatActivity implements View.OnClickListener,SingleCartAdapter.ListChange{

    Button b1;
    private int totalCost = 1520,FLAG=1;
    private CheckBox mGiftWrapCheckBox;
    private LinearLayout mGiftWrapLayout;
    private RecyclerView mDeliveryView;
    private List<SingleCart> mList;
    private SingleCartAdapter mAdapter;
    private TextView editAddress,mAddNewAddress,mBuyNowCustName,mBuyNowAddress,mGrandTotal, mPromoCode;
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
    LinearLayout subscribe;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_now);
        Toolbar toolbar = (Toolbar) findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);

        getSupportActionBar().setTitle("Delivery");
        mGrandTotal=(TextView)findViewById(R.id.grandTotal);
        editAddress=(TextView)findViewById(R.id.editInfo);
        mAddNewAddress=(TextView)findViewById(R.id.newAddress);
        mBuyNowCustName=(TextView)findViewById(R.id.buyNowCustomerName);
        mBuyNowAddress=(TextView)findViewById(R.id.buyNowCustomerAddress);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        b1 = (Button) findViewById(R.id.myCartContinueBtn);
        b1.setBackgroundColor(getResources().getColor(R.color.green));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Payment.class);
                startActivity(i);
            }
        });
        mGiftWrapCheckBox =(CheckBox)findViewById(R.id.giftWrapCheckBox);

        mGiftWrapCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mGiftWrapCheckBox.isChecked()) {
                    totalCost = totalCost+25;
                    mGrandTotal.setText(String.valueOf(totalCost));

                } else {
                    mGiftWrapCheckBox.setChecked(false);
                    totalCost = totalCost-25;
                    mGrandTotal.setText(String.valueOf(totalCost));
                }
            }
        });

        mPromoCode = (TextView) findViewById(R.id.textView8);
        mPromoCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CouponsPage.class);
                startActivity(intent);
            }
        });


        editAddress.setOnClickListener(this);
        mAddNewAddress.setOnClickListener(this);
        mDeliveryView=(RecyclerView) findViewById(R.id.deliveryView);
        mList=new ArrayList<>();
        mAdapter=new SingleCartAdapter(this,mList);


        LinearLayoutManager lm = new LinearLayoutManager(this);
        mDeliveryView.setLayoutManager(lm);
        mDeliveryView.setFocusable(false);
        mDeliveryView.setItemAnimator(new DefaultItemAnimator());
        mDeliveryView.setAdapter(mAdapter);
        mDeliveryView.setNestedScrollingEnabled(false);
        prepareItems();

        Intent intent=getIntent();
        if(intent!=null)
        {
            if(intent.getIntExtra("STATUSFLAG",0)==401)
            {
                mList.add(new SingleCart(R.mipmap.ic_launcher,
                        10,
                        12000,
                        "NEW ITEM ADDED",
                        "DESICHAIN"));
                mAdapter.notifyDataSetChanged();
            }
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        refferencetonavigationcategory(navigationView);
        nestedScrollView= (NestedScrollView) navigationView.findViewById(R.id.scrollposition);
        listView= (Helper) navigationView.findViewById(R.id.parentcategoryList);
        initiaze();
        add();
    }


    private void prepareItems() {

        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));


        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));

        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));

        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));

        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));

        mList.add(new SingleCart(R.mipmap.ic_launcher,
                10,
                12000,
                "Samsung Galaxy S8 plus",
                "Samsung"));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                switch (item.getItemId()){
                    case android.R.id.home:
                        if(drawer.isDrawerOpen(Gravity.LEFT)) {
                            drawer.closeDrawer(Gravity.LEFT);
                        }else{
                            finish();
                        }
                        break;
                    case R.id.search_item:
                        startActivity(new Intent(this,SearchActivity.class));
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

                return true;

        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.editInfo:

                Intent editIntent = new Intent(this,SelectAddress.class);
                editIntent.putExtra("flagIntent",FLAG);
                startActivity(editIntent);
                break;

            case R.id.newAddress:
                startActivity(new Intent(this,AddNewAddress.class));
                break;
            default:new Utility().openIntent(this,v.getId(),drawer);
                break;
        }

    }

    @Override
    public void change() {

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
        final ShowCategoryAdapeter showCategoryAdapeter=new ShowCategoryAdapeter(BuyNow.this,arrayList,hashMap,listView);
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
                Intent intent=new Intent(BuyNow.this,Childcategoru.class);
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
                    startActivity(new Intent(BuyNow.this,LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(BuyNow.this,MyAccount.class));

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
