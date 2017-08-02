package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
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
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Adapters.BrandStudioAdapter;
import com.example.nitin.desichain.Adapters.CustomViewpagerAdapter;
import com.example.nitin.desichain.Adapters.ProductHorizontalAdapter;
import com.example.nitin.desichain.Contents.*;
import com.example.nitin.desichain.Internet.FetchingFromUrl;
import com.example.nitin.desichain.ParsingJson.BrandStudio;
import com.example.nitin.desichain.ParsingJson.BsetSellingProduct;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int currentPage = 0,count=0,currentCateg =0;
    Timer timer;
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3000;
    private Helper listView;
    public static ArrayList<CategoryHolder> arrayList;
    public static ArrayList<String> Books;
    private CardView cardView;
    private NestedScrollView mNestedScrollView;
    private TextView mLatestProdText, mTopTenText, mFeaturedText, mBestSellText;
    public static ArrayList<String> Poojaitem;
    DrawerLayout drawer;
    NestedScrollView nestedScrollView;
    TextView txtViewCount;
    public static ArrayList<String> Homecare;
    TextView TESTING;
    private ArrayList<BrandStudioList> BRAND_STUDIO_LIST;
    //  int count=2;
    private String FLAG_FOR_CALLING=null;
    private String CUSTOMER_SNO;
    String JSON_RESPONSE;
    private int imagesAdvertisement[] = {R.drawable.bikano,
                    R.drawable.mobile_covers,
                    R.drawable.handicrafts};
    private ViewPager viewPager,mAdvertisementViewpager;
    private CustomViewpagerAdapter mAdapter,mAdvertisemetnAdapter;
    private BrandStudioAdapter mBrandStudioAdapter;
    private int images[] = {R.drawable.hitkary_small,
            R.drawable.books_small,
            R.drawable.go_cashless_small,
            R.drawable.handlooms_small,
            R.drawable.ime9_small};
    public static ArrayList<String> others;
    public static HashMap<String, ArrayList<String>> hashMap;
    View headerView;
    //  private BrandStudioAdapter mBrandStudioAdapter;
    private RecyclerView mLatestProductView, mBrandStudioView, mTopTenGameView, mTopTenGameView2, mFeaturedProductView, mAdvertisementView, mBestSellingView;
    private ArrayList<com.example.nitin.desichain.Contents.CategoryList> mLatestProductList, mFeaturedProductList,mBestSellingProductList, mDummmyBestSelling,mDeummyLatest,mDummyFeatured;
    private ProductHorizontalAdapter mLatestProductAdapter, mTopTenGameAdapter, mTopTenGameAdapter2, mFeaturedProductAdapter, mAdvertisementAdapter, mBestSellingProductAdapter;
    LinearLayout myorder, mycart, myaccount, helpcenter, ratedesichain, productPage, policy, facebook, google, twitter, pinterest, youtube, instagram, aboutus, subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolBar);
        setSupportActionBar(toolbar);
        TESTING = (TextView) findViewById(R.id.testing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        invalidateOptionsMenu();


        final Intent intent=getIntent();
        if(intent!=null){
            FLAG_FOR_CALLING=intent.getStringExtra("CALLINGFROMREGISTERACTIVITY");
            if(FLAG_FOR_CALLING!=null)
            {
                CUSTOMER_SNO=intent.getStringExtra("SNO");
                Toast.makeText(MainActivity.this,CUSTOMER_SNO,Toast.LENGTH_SHORT).show();
                //savedInstanceState.putString("SNO",CUSTOMER_SNO);
            }
        }

        mFeaturedProductList =new ArrayList<>();
        mDeummyLatest=new ArrayList<>();
        mDummyFeatured=new ArrayList<>();
        mBestSellingProductList=new ArrayList<>();
        mDummmyBestSelling =new ArrayList<>();
        mLatestProdText = (TextView) findViewById(R.id.latestProdViewAll);
        mTopTenText = (TextView) findViewById(R.id.topTenGameViewAll);
        mFeaturedText = (TextView) findViewById(R.id.featuredProductViewAll);
        mBestSellText = (TextView) findViewById(R.id.bestSellingProductViewAll);


        mNestedScrollView = (NestedScrollView) findViewById(R.id.content_main);
        mNestedScrollView.setFillViewport(true);
        cardView = (CardView) findViewById(R.id.searchproduct);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mAdapter = new CustomViewpagerAdapter(this, images);
        viewPager.setAdapter(mAdapter);
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage==5){
                    currentPage=0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        mAdvertisementViewpager = (ViewPager)findViewById(R.id.viewpagerAdvertisement);
        mAdvertisemetnAdapter = new CustomViewpagerAdapter(this,imagesAdvertisement);
        mAdvertisementViewpager.setAdapter(mAdvertisemetnAdapter);
        final Handler handler2 = new Handler();
        final Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                if (currentCateg==3){
                    currentCateg=0;
                }
                mAdvertisementViewpager.setCurrentItem(currentCateg++,true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler2.post(runnable2);
            }
        },DELAY_MS,PERIOD_MS);

        mLatestProdText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,CategoryPage.class);
                intent1.putExtra("featuredProdKey",mLatestProductList);
                startActivity(intent1);
            }
        });
        mTopTenText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,CategoryPage.class);
                intent1.putExtra("featuredProdKey",mLatestProductList);
                startActivity(intent1);

            }
        });
        mFeaturedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,CategoryPage.class);
                intent1.putExtra("featuredProdKey",mFeaturedProductList);
                startActivity(intent1);
            }
        });
        mBestSellText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,CategoryPage.class);
                intent1.putExtra("featuredProdKey",mBestSellingProductList);
                startActivity(intent1);

            }
        });

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);

        launchFeaturedProducts();
        loadBrandStudio();
        loadLatestProduct();
        loadBestSellingProducts();

        mLatestProductView = (RecyclerView) findViewById(R.id.LatestProductRecyclerView);
        mLatestProductAdapter = new ProductHorizontalAdapter(MainActivity.this, mDeummyLatest);
        GridLayoutManager lm = new GridLayoutManager(this, 2);
        mLatestProductView.setLayoutManager(lm);
        mLatestProductView.setHasFixedSize(true);
        mLatestProductView.setFocusable(false);
        mLatestProductView.setNestedScrollingEnabled(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mLatestProdText.setNestedScrollingEnabled(false);
        }
        mLatestProductView.setAdapter(mLatestProductAdapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mLatestProductView.setScrollBarSize(0);
        }


        mBrandStudioView = (RecyclerView) findViewById(R.id.brandStudioRecyclerView);
        mBrandStudioAdapter = new BrandStudioAdapter(BRAND_STUDIO_LIST, MainActivity.this);
        //GridLayoutManager lm6 = new GridLayoutManager(this,2, LinearLayoutManager.HORIZONTAL,true);
        com.example.nitin.desichain.LinearLayoutPagerManager lm6 = new LinearLayoutPagerManager(this, LinearLayoutManager.HORIZONTAL, false, 4);
        mBrandStudioView.setLayoutManager(lm6);
        mBrandStudioView.setNestedScrollingEnabled(false);
        mBrandStudioView.setItemAnimator(new DefaultItemAnimator());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mBrandStudioView.setScrollBarSize(0);
        }
        mBrandStudioView.setAdapter(mBrandStudioAdapter);
        mBrandStudioView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent1 = new Intent(MainActivity.this,BrandProducts.class);
                BrandStudioList brandStudioList = BRAND_STUDIO_LIST.get(position);
                Bundle bundle = new Bundle();
//
//                bundle.putString("bundleImageUrl",brandStudioList.getBRAND_IMAGE_URL());
//                bundle.putString("bundleProdName",brandStudioList.getBRAND_PAGE_URL());
//                bundle.putString("bundleProdDesc",brandStudioList.getBRAND_PAGE_DESCRIPTION());
//                intent1.putExtras(bundle);
                intent1.putExtra(AllConstants.FLAG,AllConstants.CALLFROMBRANDPRODUCTMAINACTIVITY);
                intent1.putExtra("bundleImageUrl",brandStudioList.getBRAND_IMAGE_URL());
                intent1.putExtra("bundleProdName",brandStudioList.getBRAND_PAGE_URL());
                intent1.putExtra("bundleProdDesc",brandStudioList.getBRAND_PAGE_DESCRIPTION());
                intent1.putExtra("bundleBrandSno",brandStudioList.getBRAND_SNO());
                Log.i("aaa",String.valueOf(brandStudioList.getBRAND_SNO()));
                startActivity(intent1);
            }
        }));

        if (BRAND_STUDIO_LIST!=null) {
            final Handler handler1 = new Handler();
            final Runnable runnable = new Runnable() {
                int count;

                @Override
                public void run() {
                    if (count == BRAND_STUDIO_LIST.size()) {
                        count = 0;
                    }
                    mBrandStudioView.smoothScrollToPosition(count++);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler1.post(runnable);
                }
            }, 0, PERIOD_MS);
        }

        mTopTenGameAdapter = new ProductHorizontalAdapter(MainActivity.this, mDeummyLatest);
        mTopTenGameView = (RecyclerView) findViewById(R.id.top_ten_game_view);
        GridLayoutManager lm1 = new GridLayoutManager(this, 2);
        mTopTenGameView.setLayoutManager(lm1);
        mTopTenGameView.setNestedScrollingEnabled(false);
        mTopTenGameView.setItemAnimator(new DefaultItemAnimator());
        mTopTenGameView.setAdapter(mTopTenGameAdapter);


        mTopTenGameAdapter2 = new ProductHorizontalAdapter(MainActivity.this, mDeummyLatest);
        mTopTenGameView2 = (RecyclerView) findViewById(R.id.top_ten_game_second_RecyclerView);
        GridLayoutManager lm5 = new GridLayoutManager(this, 2);
        mTopTenGameView2.setLayoutManager(lm5);
        mTopTenGameView2.setNestedScrollingEnabled(false);
        mTopTenGameView2.setItemAnimator(new DefaultItemAnimator());
        mTopTenGameView2.setAdapter(mTopTenGameAdapter2);


        mFeaturedProductAdapter = new ProductHorizontalAdapter(MainActivity.this, mDummyFeatured);
        mFeaturedProductView = (RecyclerView) findViewById(R.id.featuredProductRecyclerView);
        GridLayoutManager lm2 = new GridLayoutManager(this, 2);
        mFeaturedProductView.setLayoutManager(lm2);
        mFeaturedProductView.setNestedScrollingEnabled(false);
        mFeaturedProductView.setItemAnimator(new DefaultItemAnimator());
        mFeaturedProductView.setAdapter(mFeaturedProductAdapter);

        mBestSellingProductAdapter = new ProductHorizontalAdapter(this, mDummmyBestSelling);
        mBestSellingView = (RecyclerView) findViewById(R.id.bestSellingRecyclerView);
        GridLayoutManager lm4 = new GridLayoutManager(this, 2);
        mBestSellingView.setLayoutManager(lm4);
        mBestSellingView.setNestedScrollingEnabled(false);
        mBestSellingView.setItemAnimator(new DefaultItemAnimator());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mBestSellingView.setScrollBarSize(0);
        }
        mBestSellingView.setAdapter(mBestSellingProductAdapter);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
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
        nestedScrollView = (NestedScrollView) navigationView.findViewById(R.id.scrollposition);
        listView = (Helper) navigationView.findViewById(R.id.parentcategoryList);
        initiaze();
        add();


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);

            }
        });
    }


    public void loadLatestProduct(){
        if (!(Utility.isNetworkAvailable(this))) {

            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        } else {
            try {
                JSON_RESPONSE = new FetchingFromUrl().execute("http://dc.desichain.in/DesiChainWeService.asmx/LatestProduct").get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (JSON_RESPONSE != null) {
                mLatestProductList = new BsetSellingProduct(JSON_RESPONSE, MainActivity.this).parseBestSellingProduct();
                for (int i=0;i<4;i++){
                    mDeummyLatest.add(mLatestProductList.get(i));
                }
             }
        }

    }

    public void loadBestSellingProducts(){
        if (!(Utility.isNetworkAvailable(this))) {

            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        } else {
            try {
                JSON_RESPONSE = new FetchingFromUrl().execute("http://dc.desichain.in/DesiChainWeService.asmx/BestsellingProduct").get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (JSON_RESPONSE != null) {
                mBestSellingProductList = new BsetSellingProduct(JSON_RESPONSE, MainActivity.this).parseBestSellingProduct();
                for (int i=0;i<4;i++){
                    mDummmyBestSelling.add(mBestSellingProductList.get(i));
                }
            }
        }
    }



    public void launchFeaturedProducts() {

        if (!(Utility.isNetworkAvailable(this))) {

            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        } else {
            try {
                JSON_RESPONSE = new FetchingFromUrl().execute("http://dc.desichain.in/DesiChainWeService.asmx/FeaturedProduct").get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            if (JSON_RESPONSE != null) {
                mFeaturedProductList = new BsetSellingProduct(JSON_RESPONSE, MainActivity.this).parseBestSellingProduct();
                for (int i=0;i<4;i++){
                    mDummyFeatured.add(mFeaturedProductList.get(i));
                }
                }
        }
    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.my_cart);
        MenuItem item = menu.findItem(R.id.search_item);
        item.setVisible(false);
        MenuItemCompat.setActionView(menuItem, R.layout.cart_icon_for_toolbar);
        RelativeLayout mycarttoolbar = (RelativeLayout) MenuItemCompat.getActionView(menuItem);
        txtViewCount = (TextView) mycarttoolbar.findViewById(R.id.badge_notification_1);
        count++;
        txtViewCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtViewCount.setText(String.valueOf(count++));
                startActivity(new Intent(MainActivity.this,MyCart.class));
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
        switch (id) {
            case R.id.my_cart:
                startActivity(new Intent(MainActivity.this, MyCart.class));
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }                break;
            case R.id.notifications:
               Toast.makeText(MainActivity.this, "Notifications item selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_orders:
                startActivity(new Intent(MainActivity.this, MyOrders.class));
                break;
            case android.R.id.home:
                if (drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else {
                    drawer.openDrawer(Gravity.LEFT);
                }


        }


        return super.onOptionsItemSelected(item);
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
        final ShowCategoryAdapeter showCategoryAdapeter = new ShowCategoryAdapeter(MainActivity.this, arrayList, hashMap, listView);
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
                Intent intent = new Intent(MainActivity.this, Childcategoru.class);
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
        myaccount.setOnClickListener(this);
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
        new Utility().openIntent(this, v.getId(), drawer);
    }



    public void loadBrandStudio() {
        if (!(Utility.isNetworkAvailable(this))) {

            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        } else {
            try {
                JSON_RESPONSE = new FetchingFromUrl().execute("http://dc.desichain.in/DesiChainWeService.asmx/TotalBrandDetail").get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            if (JSON_RESPONSE != null) {
                BRAND_STUDIO_LIST = new BrandStudio(JSON_RESPONSE, MainActivity.this).parseBestSellingProduct();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if(CUSTOMER_SNO!=null)
        {
            outState.putString("CUSTOMER_SNO",CUSTOMER_SNO);
        }
    }
}
