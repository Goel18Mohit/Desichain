package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.nitin.desichain.Adapters.ProductHorizontalAdapter;
import com.example.nitin.desichain.Contents.Advertisements;
import com.example.nitin.desichain.Contents.ProductHorizontal;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Helper listView;
    public  static ArrayList<CategoryHolder> arrayList;
public static  ArrayList<String> Books;
    private List<Advertisements> mPics;
    private CardView cardView;

 public static ArrayList<String> Poojaitem;
    DrawerLayout drawer;
    NestedScrollView nestedScrollView;
  public static ArrayList<String> Homecare;
  public static   ArrayList<String> others;
      public  static HashMap<String,ArrayList<String>> hashMap;
    View headerView;
    private RecyclerView mLatestProductView,mBrandStudioView, mTopTenGameView,mTopTenGameView2, mFeaturedProductView,mAdvertisementView,mBestSellingView;
    private List<ProductHorizontal> mProductsList;
    private ProductHorizontalAdapter mLatestProductAdapter,mBrandStudioAdapter, mTopTenGameAdapter,mTopTenGameAdapter2, mFeaturedProductAdapter,mAdvertisementAdapter,mBestSellingProductAdapter;
    LinearLayout myorder,mycart,myaccount,helpcenter,ratedesichain,productPage,policy,facebook,google,twitter,pinterest,youtube,instagram,aboutus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        final ActionBar ab = getSupportActionBar();
        cardView= (CardView) findViewById(R.id.searchproduct);


        mLatestProductView =(RecyclerView)findViewById(R.id.LatestProductRecyclerView);
        mProductsList=new ArrayList<>();
        mLatestProductAdapter = new ProductHorizontalAdapter(MainActivity.this,mProductsList);
        LinearLayoutManager lm =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mLatestProductView.setLayoutManager(lm);
        mLatestProductView.setItemAnimator(new DefaultItemAnimator());
        mLatestProductView.setAdapter(mLatestProductAdapter);
        mLatestProductView.setScrollBarSize(0);

        mPics=new ArrayList<>();
        mAdvertisementView=(RecyclerView)findViewById(R.id.advertisemntRecyclerView);
        mAdvertisementAdapter=new ProductHorizontalAdapter(this,mProductsList);
        LinearLayoutManager lm3 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        mAdvertisementView.setLayoutManager(lm3);
        mAdvertisementView.setItemAnimator(new DefaultItemAnimator());
        mAdvertisementView.setAdapter(mAdvertisementAdapter);
        mAdvertisementView.setScrollBarSize(0);

    //    addAdvertisment();

        mBrandStudioView=(RecyclerView)findViewById(R.id.brandStudioRecyclerView);
        mBrandStudioAdapter=new ProductHorizontalAdapter(this,mProductsList);
        LinearLayoutManager lm6 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        mBrandStudioView.setLayoutManager(lm6);
        mBrandStudioView.setItemAnimator(new DefaultItemAnimator());
        mBrandStudioView.setScrollBarSize(0);
        mBrandStudioView.setAdapter(mBrandStudioAdapter);
        mBrandStudioView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(MainActivity.this,BrandProducts.class));
            }
        }));

        mTopTenGameAdapter =new ProductHorizontalAdapter(MainActivity.this,mProductsList);
        mTopTenGameView =(RecyclerView) findViewById(R.id.top_ten_game_view);
        LinearLayoutManager lm1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        mTopTenGameView.setLayoutManager(lm1);
        mTopTenGameView.setItemAnimator(new DefaultItemAnimator());
        mTopTenGameView.setAdapter(mTopTenGameAdapter);


        mTopTenGameAdapter2 =new ProductHorizontalAdapter(MainActivity.this,mProductsList);
        mTopTenGameView2 =(RecyclerView) findViewById(R.id.top_ten_game_second_RecyclerView);
        LinearLayoutManager lm5 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        mTopTenGameView2.setLayoutManager(lm5);
        mTopTenGameView2.setItemAnimator(new DefaultItemAnimator());
        mTopTenGameView2.setAdapter(mTopTenGameAdapter2);


        mFeaturedProductAdapter =new ProductHorizontalAdapter(MainActivity.this,mProductsList);
        mFeaturedProductView =(RecyclerView)findViewById(R.id.featuredProductRecyclerView);
        LinearLayoutManager lm2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        mFeaturedProductView.setLayoutManager(lm2);
        mFeaturedProductView.setItemAnimator(new DefaultItemAnimator());
        mFeaturedProductView.setAdapter(mFeaturedProductAdapter);

        mBestSellingProductAdapter=new ProductHorizontalAdapter(this,mProductsList);
        mBestSellingView=(RecyclerView)findViewById(R.id.bestSellingRecyclerView);
        LinearLayoutManager lm4 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        mBestSellingView.setLayoutManager(lm4);
        mBestSellingView.setItemAnimator(new DefaultItemAnimator());
        mBestSellingView.setScrollBarSize(0);
        mBestSellingView.setAdapter(mBestSellingProductAdapter);



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

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        refferencetonavigationcategory(navigationView);
        nestedScrollView= (NestedScrollView) navigationView.findViewById(R.id.scrollposition);
        listView= (Helper) navigationView.findViewById(R.id.parentcategoryList);
        initiaze();
        add();

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }


    private void prepareItems() {


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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.my_cart:
                startActivity(new Intent(MainActivity.this,MyCart.class));
                break;
            case R.id.notifications:
                Toast.makeText(MainActivity.this,"Notifications item selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_orders:
                startActivity(new Intent(MainActivity.this,MyOrders.class));
                break;
            case android.R.id.home:
                    if(drawer.isDrawerOpen(Gravity.LEFT)) {
                        drawer.closeDrawer(Gravity.LEFT);
                    }else{
                        drawer.openDrawer(Gravity.LEFT);
                    }


        }


        return super.onOptionsItemSelected(item);
    }

    public void add()
    {
        arrayList.add(new CategoryHolder("Book and media",0));
        arrayList.add(new CategoryHolder("Pooja Item",0));
        arrayList.add(new CategoryHolder("Home Care",0));
        arrayList.add(new CategoryHolder("Others",0));
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
        final ShowCategoryAdapeter showCategoryAdapeter=new ShowCategoryAdapeter(MainActivity.this,arrayList,hashMap,listView);
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
                Intent intent=new Intent(MainActivity.this,Childcategoru.class);
                intent.putExtra("get",hashMap.get(arrayList.get(groupPosition).getPARENTCATEGORY()).get(childPosition));
                startActivity(intent);
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
        productPage=(LinearLayout)view.findViewById(R.id.myProductLayout);
        pinterest= (LinearLayout) view.findViewById(R.id.pinterest);
        youtube= (LinearLayout) view.findViewById(R.id.youtube);
        instagram= (LinearLayout) view.findViewById(R.id.instagram);
        aboutus= (LinearLayout) view.findViewById(R.id.aboutus);
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
        new Utility().openIntent(this,v.getId());
    }
}
