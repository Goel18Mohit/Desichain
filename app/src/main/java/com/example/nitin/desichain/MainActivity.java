package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Adapters.CustomViewpagerAdapter;
import com.example.nitin.desichain.Adapters.ProductHorizontalAdapter;
import com.example.nitin.desichain.Contents.ProductHorizontal;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3000;
    private Helper listView;
    public  static ArrayList<CategoryHolder> arrayList;
public static  ArrayList<String> Books;
    private CardView cardView;
    private NestedScrollView mNestedScrollView;
 public static ArrayList<String> Poojaitem;
    DrawerLayout drawer;
    NestedScrollView nestedScrollView;
    TextView txtViewCount;
  public static ArrayList<String> Homecare;
    int count=2;
    private ViewPager viewPager;
    private CustomViewpagerAdapter mAdapter;
    private int images[] = {R.drawable.hitkary_small,
                            R.drawable.hitkary2_small};
  public static   ArrayList<String> others;
      public  static HashMap<String,ArrayList<String>> hashMap;
    View headerView;
    private RecyclerView mLatestProductView,mBrandStudioView, mTopTenGameView,mTopTenGameView2, mFeaturedProductView,mAdvertisementView,mBestSellingView;
    private List<ProductHorizontal> mProductsList;
    private ProductHorizontalAdapter mLatestProductAdapter,mBrandStudioAdapter, mTopTenGameAdapter,mTopTenGameAdapter2, mFeaturedProductAdapter,mAdvertisementAdapter,mBestSellingProductAdapter;
    LinearLayout myorder,mycart,myaccount,helpcenter,ratedesichain,productPage,policy,facebook,google,twitter,pinterest,youtube,instagram,aboutus,subscribe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolBar);
        setSupportActionBar(toolbar);
        
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        invalidateOptionsMenu();
        mNestedScrollView=(NestedScrollView)findViewById(R.id.content_main);
        mNestedScrollView.setFillViewport(true);
        cardView= (CardView) findViewById(R.id.searchproduct);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        mAdapter=new CustomViewpagerAdapter(this,images);
        viewPager.setAdapter(mAdapter);
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage==2){
                    currentPage=0;
                }
                viewPager.setCurrentItem(currentPage++,true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_MS,PERIOD_MS);


        mLatestProductView =(RecyclerView)findViewById(R.id.LatestProductRecyclerView);
        mProductsList=new ArrayList<>();
        mLatestProductAdapter = new ProductHorizontalAdapter(MainActivity.this,mProductsList);
        LinearLayoutManager lm =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mLatestProductView.setLayoutManager(lm);
        mLatestProductView.setFocusable(false);
        mLatestProductView.setItemAnimator(new DefaultItemAnimator());
        mLatestProductView.setAdapter(mLatestProductAdapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mLatestProductView.setScrollBarSize(0);
        }

        mBrandStudioView=(RecyclerView)findViewById(R.id.brandStudioRecyclerView);
        mBrandStudioAdapter=new ProductHorizontalAdapter(this,mProductsList);
        LinearLayoutManager lm6 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        mBrandStudioView.setLayoutManager(lm6);
        mBrandStudioView.setItemAnimator(new DefaultItemAnimator());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mBrandStudioView.setScrollBarSize(0);
        }
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mBestSellingView.setScrollBarSize(0);
        }
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


        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "(12)","4.0"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "(12)","4.0"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "(12)","4.0"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "(12)","4.0"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "(12)","4.0"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "(12)","4.0"));
        mProductsList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "(12)","4.0"));

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
        MenuItem item = menu.findItem(R.id.search_item);
        item.setVisible(false);
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

   /* public void updateHotCount(final int new_hot_number) {
        count = new_hot_number;
        if (count < 0) return;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (count == 0)
                    txtViewCount.setVisibility(View.GONE);
                else {
                    txtViewCount.setVisibility(View.VISIBLE);
                    txtViewCount.setText(Integer.toString(count));
                    // supportInvalidateOptionsMenu();
                }
            }
        });
    }*/

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
        subscribe= (LinearLayout) findViewById(R.id.subscribe);
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
        subscribe.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        new Utility().openIntent(this,v.getId(),drawer);
    }
}
