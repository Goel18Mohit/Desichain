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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.example.nitin.desichain.Adapters.AddressAdapter;
import com.example.nitin.desichain.Contents.AddressList;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyAddress extends AppCompatActivity implements AddressAdapter.SaveAddress,View.OnClickListener{


    private int POSITION;
    private RecyclerView mRecyclerView;
    private AddressAdapter mAdapter;
    private List<AddressList> mAddressList;
    private Button mAddNewAddress;
    private int REQUEST_CODE_EDIT=000;
    private int REQUEST_CODE_ADD=001;
    private Toolbar mToolbar;

    LinearLayout subscribe;
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
        setContentView(R.layout.activity_my_address);

        mAddNewAddress = (Button)findViewById(R.id.buttonAddAddress);
        mRecyclerView = (RecyclerView)findViewById(R.id.mAddressRecyclerView);
        mAddressList = new ArrayList<>();
        mAdapter = new AddressAdapter(this,mAddressList,0);

        mToolbar=(Toolbar)findViewById(R.id.myToolBar);



        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(lm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mAddNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyAddress.this,AddNewAddress.class);
                intent.putExtra("REQUESTCODE",REQUEST_CODE_ADD);
                startActivityForResult(intent,REQUEST_CODE_ADD);
                finish();
            }
        });

        prepareItems();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawer.setDrawerListener(toggle);
        toggle.syncState();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        refferencetonavigationcategory(navigationView);
        nestedScrollView= (NestedScrollView) navigationView.findViewById(R.id.scrollposition);
        listView= (Helper) navigationView.findViewById(R.id.parentcategoryList);
        initiaze();
        add();
    }

    private void prepareItems() {

        mAddressList.add(new AddressList("ashish","WQDWQ jaoias aspp","984515618"));
        mAddressList.add(new AddressList("qwqwq","2013 DWDWQWQjaoias aspp","93484515618"));
        mAddressList.add(new AddressList("qwfwqqwf","2013 jaoWDDQWQias aspp","95384515618"));
        mAddressList.add(new AddressList("sdvdsvds","2013 jaoiasASDDAS aspp","984515618"));
        mAddressList.add(new AddressList("saSSA","2013 jaoias asppACS","92284515618"));
        mAddressList.add(new AddressList("BRRR","2013 jaoias aspp","98451565318"));
    }


    @Override
    public void OnEditButtonClicked(int position) {

        POSITION=position;
        Intent intent=new Intent(MyAddress.this,AddNewAddress.class);
        intent.putExtra("REQUESTCODE",REQUEST_CODE_EDIT);
        startActivityForResult(intent,REQUEST_CODE_EDIT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.my_cart){

            startActivity(new Intent(MyAddress.this,MyCart.class));
        }
        else if (item.getItemId()==R.id.search_item){
            startActivity(new Intent(this,SearchActivity.class));
        }
        if (item.getItemId() == android.R.id.home){

            finish();
        }
        else if (item.getItemId()==R.id.my_orders){
            startActivity(new Intent(this,MyOrders.class));
        }
        else if (item.getItemId()==R.id.notifications){
            startActivity(new Intent(this,NotificationPage.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data!=null) {
            if (requestCode == REQUEST_CODE_EDIT) {
                if (data.getBundleExtra("NEW ADDRESS") != null) {
                    mAddressList.remove(POSITION);
                    Bundle bundle = data.getBundleExtra("NEW ADDRESS");
                    mAddressList.add(POSITION, new AddressList(bundle.getString("CUSTOMERNAME"), bundle.getString("CUSTOMERADDRESS"), bundle.getString("CUSTOMERMOBILE")));
                    mAdapter.notifyDataSetChanged();
                }
            } else {

                if (data.getBundleExtra("NEW ADDRESS") != null) {
                    Bundle bundle = data.getBundleExtra("NEW ADDRESS");
                    mAddressList.add(new AddressList(bundle.getString("CUSTOMERNAME"), bundle.getString("CUSTOMERADDRESS"), bundle.getString("CUSTOMERMOBILE")));
                    mAdapter.notifyDataSetChanged();
                }

            }
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
        final ShowCategoryAdapeter showCategoryAdapeter=new ShowCategoryAdapeter(MyAddress.this,arrayList,hashMap,listView);
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
                Intent intent=new Intent(MyAddress.this,Childcategoru.class);
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
                    startActivity(new Intent(MyAddress.this,LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(MyAddress.this,MyAccount.class));

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
