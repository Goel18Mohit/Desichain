package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Adapters.ChildCategoryAdapter;
import com.example.nitin.desichain.Adapters.ChildCategoryCardAdapter;
import com.example.nitin.desichain.Contents.ChildCategoryBrand;
import com.example.nitin.desichain.Contents.ChildCategoryList;
import com.example.nitin.desichain.Internet.FetchingFromUrl;
import com.example.nitin.desichain.ParsingJson.ShopByPublisher;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.example.nitin.desichain.MainActivity.arrayList;


public class Childcategoru extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView newLaunchView, mPublisherView, mPriceView, mDiscountView, mPopularCategView;
    private ArrayList<ChildCategoryBrand> SHOP_BY_PUBLISHER, mDummyList;
    private ChildCategoryCardAdapter mnewLaunchAdapter, mPublisherAdapter, mPriceAdapter, mDiscountAdapter, mPopularCategAdapter;
    ArrayList<ChildCategoryList> mGetList;
    ArrayList<ChildCategoryList> homedecor;
    ArrayList<ChildCategoryList> homefurnishing;
    ArrayList<ChildCategoryList> kitchenndinning;
    private int CATEGORY_FLAG=-1;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    ArrayList<ChildCategoryList> agarbatti;
    ArrayList<ChildCategoryList> bells;
    ArrayList<ChildCategoryList> itemsofworship;
    ArrayList<ChildCategoryList> murtis;
    ArrayList<ChildCategoryList> otheressentials;
    ArrayList<ChildCategoryList> bhagavad;
    ArrayList<ChildCategoryList> media;
    ArrayList<ChildCategoryList> paperback;
    ArrayList<ChildCategoryList> personalcare;
    ArrayList<ChildCategoryList> healthandfood;
    ArrayList<ChildCategoryList> fashion;
    ArrayList<ChildCategoryList> women;
    ArrayList<ChildCategoryList> men;
    ArrayList<ChildCategoryList> bags;
    ArrayList<ChildCategoryList> mobile;

    private Helper listView;
    TextView viewMoreLaunchText, viewMorePublisherText, viewMorePriceText, viewMoreDiscountText, viewMorePopularCategText;
    View headerView;
    DrawerLayout drawer;
    private String JSON_RESPONSE,JSON_RESPONSE_NEW_LAUNCH;
    ImageView toolbarcartimage;
    NestedScrollView nestedScrollView;
    public static ArrayList<String> Poojaitem;
    public static ArrayList<String> Books;
    public static ArrayList<String> Homecare;
    public static ArrayList<String> others;
    public static HashMap<String, ArrayList<String>> hashMap;
    LinearLayout myorder, mycart, myaccount, helpcenter, ratedesichain, productPage, policy, facebook, google, twitter, pinterest, youtube, instagram, aboutus;
    LinearLayout subscribe;
    private com.example.nitin.desichain.MyGridView gridView;
    ChildCategoryAdapter childCategoryAdapter;
    List<ChildCategoryBrand> mList;
    TextView txtViewCount;
    int count = 2;
    int columns = 2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childcategoru);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
        newLaunchView=(RecyclerView)findViewById(R.id.newLaunchRecyclerView);

        mnewLaunchAdapter =new ChildCategoryCardAdapter(this, mNewLaunchList);
        GridLayoutManager lm = new GridLayoutManager(this,4);
        newLaunchView.setLayoutManager(lm);

        newLaunchView.setNestedScrollingEnabled(false);
        newLaunchView.setItemAnimator(new DefaultItemAnimator());
        newLaunchView.setAdapter(mnewLaunchAdapter);
*/
        mList = new ArrayList<>();
        JSON_RESPONSE = load("http://dc.desichain.in/DesiChainWeService.asmx/TotalPublisherDetail");
        if (JSON_RESPONSE != null) {
            mDummyList = new ArrayList<>();
            SHOP_BY_PUBLISHER = new ShopByPublisher(JSON_RESPONSE, Childcategoru.this).parsingShopByPublisher();

/*
            for (int i=0;i<12;i++){
                mList.add(new ChildCategoryBrand(1,"element"+i,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSt39g-FXH7yGefXv_tk5Fy56YL_iRqErTgjrKYFDbsq5aQY03aX6OVAw"));
            }
  */

            for (int i = 0; i < 6; i++) {
                mDummyList.add(SHOP_BY_PUBLISHER.get(i));
            }


            mPublisherView = (RecyclerView) findViewById(R.id.publisherRecyclerView);
            mPublisherAdapter = new ChildCategoryCardAdapter(this, mDummyList);
            final GridLayoutManager gm = new GridLayoutManager(this, 2);
            mPublisherView.setItemAnimator(new DefaultItemAnimator());
            mPublisherView.setLayoutManager(gm);
            mPublisherView.setFocusable(false);
            viewMorePublisherText = (TextView) findViewById(R.id.viewmorePublisher);
            viewMorePublisherText.setOnClickListener(this);
            mPublisherView.setAdapter(mPublisherAdapter);
            mPublisherView.setNestedScrollingEnabled(false);


            mPriceView = (RecyclerView) findViewById(R.id.shopByPriceRecyclerView);
            mPriceAdapter = new ChildCategoryCardAdapter(this, mDummyList);
            GridLayoutManager gm1 = new GridLayoutManager(this, 2);
            mPriceView.setLayoutManager(gm1);
            mPriceView.setFocusable(false);
            mPriceView.setItemAnimator(new DefaultItemAnimator());
            viewMorePriceText = (TextView) findViewById(R.id.viewmorePrice);
            viewMorePriceText.setOnClickListener(this);
            mPriceView.setAdapter(mPriceAdapter);
            mPriceView.setNestedScrollingEnabled(false);


            mDiscountView = (RecyclerView) findViewById(R.id.discountRecyclerView);
            mDiscountAdapter = new ChildCategoryCardAdapter(this, mDummyList);
            GridLayoutManager gm2 = new GridLayoutManager(this, 2);
            mDiscountView.setLayoutManager(gm2);
            mDiscountView.setFocusable(false);
            mDiscountView.setItemAnimator(new DefaultItemAnimator());
            viewMoreDiscountText = (TextView) findViewById(R.id.viewmoreDiscount);
            viewMoreDiscountText.setOnClickListener(this);
            mDiscountView.setAdapter(mDiscountAdapter);
            mDiscountView.setNestedScrollingEnabled(false);

            mPopularCategView = (RecyclerView) findViewById(R.id.popularCategoryRecyclerView);
            mPopularCategAdapter = new ChildCategoryCardAdapter(this, mDummyList);
            GridLayoutManager gm3 = new GridLayoutManager(this, 2);
            mPopularCategView.setLayoutManager(gm3);
            mPopularCategView.setFocusable(false);
            mPopularCategView.setItemAnimator(new DefaultItemAnimator());
            viewMorePopularCategText = (TextView) findViewById(R.id.viewmorePopularCateg);
            viewMorePopularCategText.setOnClickListener(this);
            mPopularCategView.setAdapter(mPopularCategAdapter);
            mPopularCategView.setNestedScrollingEnabled(false);
        }
            newLaunchView = (RecyclerView) findViewById(R.id.newLaunchRecyclerView);
            mnewLaunchAdapter = new ChildCategoryCardAdapter(this, mDummyList);
            final GridLayoutManager lm = new GridLayoutManager(this, 2);
            newLaunchView.setLayoutManager(lm);
            newLaunchView.setNestedScrollingEnabled(false);
            newLaunchView.setItemAnimator(new DefaultItemAnimator());
            viewMoreLaunchText = (TextView) findViewById(R.id.viewmoreLaunch);
            viewMoreLaunchText.setOnClickListener(this);
            newLaunchView.setFocusable(false);
            newLaunchView.setAdapter(mnewLaunchAdapter);



        getSupportActionBar().setTitle(getIntent().getStringExtra("get"));
        Log.i("get", getIntent().getStringExtra("get"));
        inti();
        gridView = (MyGridView) findViewById(R.id.singlechildlistview);
        gridView.setFocusable(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            gridView.setNestedScrollingEnabled(false);
        }
        Intent intent = getIntent();
        String choice = intent.getStringExtra("get");
        if (MainActivity.hashMap.get(arrayList.get(0).getPARENTCATEGORY()).get(0).equals(choice)) {
            setBhagavad();
            CATEGORY_FLAG=1;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, bhagavad);
            mGetList = bhagavad;
            gridView.setAdapter(childCategoryAdapter);
            // setGridViewHeightBasedOnChildren(gridView,3);


        } else if (MainActivity.hashMap.get(arrayList.get(0).getPARENTCATEGORY()).get(1).equals(choice)) {
            setPaperback();
            CATEGORY_FLAG=1;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, paperback);
            mGetList = paperback;
            gridView.setAdapter(childCategoryAdapter);
            //    setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(0).getPARENTCATEGORY()).get(2).equals(choice)) {

            setMedia();
            CATEGORY_FLAG=1;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, media);
            mGetList = media;
            gridView.setAdapter(childCategoryAdapter);
            //   setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(0).equals(choice)) {

            setItemsofworship();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, itemsofworship);
            mGetList = itemsofworship;
            gridView.setAdapter(childCategoryAdapter);
            // setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(1).equals(choice)) {
            setOtheressentials();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, otheressentials);
            mGetList = otheressentials;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(2).equals(choice)) {
            setBells();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, bells);
            mGetList = bells;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);

        } else if (MainActivity.hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(3).equals(choice)) {

            setAgarbatti();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, agarbatti);
            mGetList = agarbatti;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(4).equals(choice)) {

            setMurtis();
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, murtis);
            mGetList = murtis;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(2).getPARENTCATEGORY()).get(0).equals(choice)) {

            setHomedecor();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, homedecor);
            mGetList = homedecor;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(2).getPARENTCATEGORY()).get(1).equals(choice)) {

            setHomefurnishing();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, homefurnishing);
            mGetList = homefurnishing;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(2).getPARENTCATEGORY()).get(2).equals(choice)) {
            setKitchenndinning();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, kitchenndinning);
            mGetList = kitchenndinning;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);

        } else if (MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(0).equals(choice)) {

            setPersonalcare();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, personalcare);
            mGetList = personalcare;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(1).equals(choice)) {

            setHealthandfood();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, healthandfood);
            mGetList = healthandfood;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(2).equals(choice)) {

            setFashion();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, fashion);
            mGetList = fashion;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(3).equals(choice)) {

            setWomen();
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, women);
            mGetList = women;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(4).equals(choice)) {

            setMen();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, men);
            mGetList = men;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);
        } else if (MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(5).equals(choice)) {
            setBags();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, bags);
            mGetList = bags;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);

        } else if (MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(6).equals(choice)) {
            setMobile();
            CATEGORY_FLAG=0;
            childCategoryAdapter = new ChildCategoryAdapter(Childcategoru.this, mobile);
            mGetList = mobile;
            gridView.setAdapter(childCategoryAdapter);
            //setGridViewHeightBasedOnChildren(gridView,3);

        }
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


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Childcategoru.this,String.valueOf(CATEGORY_FLAG),Toast.LENGTH_SHORT).show();
                if(CATEGORY_FLAG!=-1) {
                    Intent intent1 = new Intent(Childcategoru.this, CategoryPage.class);
                    intent1.putExtra("CATEGORYFLAG", CATEGORY_FLAG);
                    intent1.putExtra("Topic", mGetList.get(position).getCHILDCATEGORYNAME());
                    intent1.putExtra("getFilterName", getIntent().getStringExtra("getFilterName"));
                    Log.i("getFilterName", String.valueOf(getIntent().getStringExtra("getFilterName")));
                    startActivity(intent1);
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });
    }

    public void inti() {
        homedecor = new ArrayList<>();
        homefurnishing = new ArrayList<>();
        kitchenndinning = new ArrayList<>();
        agarbatti = new ArrayList<>();
        murtis = new ArrayList<>();
        bells = new ArrayList<>();
        itemsofworship = new ArrayList<>();
        paperback = new ArrayList<>();
        mobile = new ArrayList<>();
        bags = new ArrayList<>();
        women = new ArrayList<>();
        men = new ArrayList<>();
        fashion = new ArrayList<>();
        healthandfood = new ArrayList<>();
        personalcare = new ArrayList<>();
        otheressentials = new ArrayList<>();
        bhagavad = new ArrayList<>();
        media = new ArrayList<>();
    }


    public void setHomedecor() {
        homedecor.add(new ChildCategoryList("Showpieces & Decoratives", R.mipmap.showcase));
        homedecor.add(new ChildCategoryList("Arts,Gift & Crafts", R.mipmap.gifts));
        homedecor.add(new ChildCategoryList("Clocks", R.mipmap.clock));
        homedecor.add(new ChildCategoryList("Lamps & Lighting", R.mipmap.lamps));
        homedecor.add(new ChildCategoryList("Paintings", R.mipmap.painting));
        homedecor.add(new ChildCategoryList("Wall Decals", R.mipmap.wall_decal));
        homedecor.add(new ChildCategoryList("Photo Frames & Albums", R.mipmap.photoframe));
        homedecor.add(new ChildCategoryList("Candles & Fragrances", R.mipmap.candles));
        homedecor.add(new ChildCategoryList("Flowers,Plants & Vases", R.mipmap.plant_vase));
        homedecor.add(new ChildCategoryList("Religion & Devotion", R.mipmap.religious));
        homedecor.add(new ChildCategoryList("Festive Decor", R.mipmap.festive));

    }

    public void setHomefurnishing() {


        homefurnishing.add(new ChildCategoryList("Bedsheets", R.mipmap.bedsheet));
        homefurnishing.add(new ChildCategoryList("Curtains", R.mipmap.curtain));
        homefurnishing.add(new ChildCategoryList("Cushion & Pillow Covers", R.mipmap.cushion_pillow));
        homefurnishing.add(new ChildCategoryList("Blankets,Quilts & Dohars", R.mipmap.blankets));
        homefurnishing.add(new ChildCategoryList("Towels", R.mipmap.towel));
        homefurnishing.add(new ChildCategoryList("Mats Carpets & Rugs", R.mipmap.mats));
        homefurnishing.add(new ChildCategoryList("Bath Linen", R.mipmap.linen));
        homefurnishing.add(new ChildCategoryList("Diwan Sets", R.mipmap.diwan));
        homefurnishing.add(new ChildCategoryList("Bedding Sets", R.mipmap.bedding_set));
        homefurnishing.add(new ChildCategoryList("Sofa Covers", R.mipmap.sofa));
        homefurnishing.add(new ChildCategoryList("Tables", R.mipmap.table));

    }

    public void setKitchenndinning() {

        kitchenndinning.add(new ChildCategoryList("Dinnerware", R.mipmap.dinnerware));
        kitchenndinning.add(new ChildCategoryList("Cookware", R.mipmap.cookware));
        kitchenndinning.add(new ChildCategoryList("Kitchen Tools & Cultery", R.mipmap.kitchen_tools));
        kitchenndinning.add(new ChildCategoryList("Kitchen Care", R.mipmap.kitchen_care));
        kitchenndinning.add(new ChildCategoryList("Laundry Care", R.mipmap.laundry_care));

    }

    public void setAgarbatti() {

        agarbatti.add(new ChildCategoryList("Incense Sticks", R.mipmap.incense));
        agarbatti.add(new ChildCategoryList("Natural Dhoops", R.mipmap.dhoop));
    }

    public void setBells() {

        bells.add(new ChildCategoryList("Brass", R.mipmap.ic_security_black_24dp));

    }

    public void setItemsofworship() {

        itemsofworship.add(new ChildCategoryList("Japa Mala & Bags", R.mipmap.japa_mala));
        itemsofworship.add(new ChildCategoryList(" Mats/Assan", R.mipmap.mats));
        itemsofworship.add(new ChildCategoryList("Other Items", R.mipmap.other));
        itemsofworship.add(new ChildCategoryList("Pooja Lamps", R.mipmap.lamps));
        itemsofworship.add(new ChildCategoryList("Pooja Thali", R.mipmap.thali));
        itemsofworship.add(new ChildCategoryList("Pooja Vessels", R.mipmap.vessel));
        itemsofworship.add(new ChildCategoryList("Sacrifices(Havan)Items", R.mipmap.havan));
        itemsofworship.add(new ChildCategoryList("Sindoor(Vermilion)", R.mipmap.sindoor));
        itemsofworship.add(new ChildCategoryList("Wicks(Batti)", R.mipmap.wicks));

    }

    public void setMurtis() {

        murtis.add(new ChildCategoryList("Brass", R.mipmap.secure_payment));
        murtis.add(new ChildCategoryList("Mini Temples", R.mipmap.temple));

    }

    public void setOtheressentials() {

        otheressentials.add(new ChildCategoryList("Kanthi Mala/Neck Beads", R.mipmap.kanth_mala));
        otheressentials.add(new ChildCategoryList("Khadaun/Slippers", R.mipmap.khadaun));
        otheressentials.add(new ChildCategoryList("Scarf/Chadar", R.mipmap.scarf));

    }

    public void setBhagavad() {

        bhagavad.add(new ChildCategoryList("Bengali", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Chinese", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("English", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Gujarati", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Hindi", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Kannada", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Malayalam", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Marathi", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Nepali", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Oriya", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Punjabi", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Russian", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Sindhi", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Tamil", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Telugu", R.mipmap.ic_security_black_24dp));
        bhagavad.add(new ChildCategoryList("Urdu", R.mipmap.ic_security_black_24dp));

    }

    public void setMedia() {

        media.add(new ChildCategoryList("Animation Movies", R.mipmap.animation));
        media.add(new ChildCategoryList("Independent Cinema", R.mipmap.cinema));
        media.add(new ChildCategoryList("kirtans/Bhajans", R.mipmap.kirtan));
        media.add(new ChildCategoryList("Lectures/Talks", R.mipmap.lecture));

    }

    public void setPaperback() {

        paperback.add(new ChildCategoryList("Astrology", R.mipmap.astrology));
        paperback.add(new ChildCategoryList("Ayurveda & Health", R.mipmap.ayurveda));
        paperback.add(new ChildCategoryList("Biography", R.mipmap.biography));
        paperback.add(new ChildCategoryList("Children", R.mipmap.children));
        paperback.add(new ChildCategoryList("Classic Text", R.mipmap.classic_text));
        paperback.add(new ChildCategoryList("Cooking & Vegetariansim", R.mipmap.cooking));
        paperback.add(new ChildCategoryList("Cow Protection", R.mipmap.cow));
        paperback.add(new ChildCategoryList("Magazines", R.mipmap.magazine));
        paperback.add(new ChildCategoryList("Personal Growth", R.mipmap.personal_growth));
        paperback.add(new ChildCategoryList("Philossophy", R.mipmap.philosophy));
        paperback.add(new ChildCategoryList("Re-Incranation", R.mipmap.reincarnation));
        paperback.add(new ChildCategoryList("Religious/Spirtual", R.mipmap.religious));
        paperback.add(new ChildCategoryList("Science", R.mipmap.science));
        paperback.add(new ChildCategoryList("Travel & Pilgrimage", R.mipmap.pilgrimage));
        paperback.add(new ChildCategoryList("Vedic/Indian Culture", R.mipmap.indian_culture));
        paperback.add(new ChildCategoryList("Yoga and Meditation", R.mipmap.yoga));
        paperback.add(new ChildCategoryList("Language Learning", R.mipmap.language));
    }

    public void setPersonalcare() {


        personalcare.add(new ChildCategoryList("Baby Care", R.mipmap.babycare));
        personalcare.add(new ChildCategoryList("Bath & Body", R.mipmap.bath_body));
        personalcare.add(new ChildCategoryList("Cosmetics/Skin Care", R.mipmap.cosmetic_skincare));
        personalcare.add(new ChildCategoryList("Hair Cair", R.mipmap.haircare));
        personalcare.add(new ChildCategoryList("Miscellaneous", R.mipmap.other));
        personalcare.add(new ChildCategoryList("Oral Care", R.mipmap.oralcare));

    }

    public void setHealthandfood() {


        healthandfood.add(new ChildCategoryList("Rice/Flour/Cereal", R.mipmap.rice_wheat_cereal));
        healthandfood.add(new ChildCategoryList("Spices(Masalas) & Herbs", R.mipmap.spices_herbs));
        healthandfood.add(new ChildCategoryList("Snacks", R.mipmap.snacks));
        healthandfood.add(new ChildCategoryList("Herbal Tea/Coffee", R.mipmap.tea));
        healthandfood.add(new ChildCategoryList("DryFruits,Nuts,Seeds", R.mipmap.nuts));
        healthandfood.add(new ChildCategoryList("Food Suplements", R.mipmap.supplements));
        healthandfood.add(new ChildCategoryList("Cow Products", R.mipmap.cow));
        healthandfood.add(new ChildCategoryList("Miscellaneous", R.mipmap.other));


    }

    public void setFashion() {


        fashion.add(new ChildCategoryList("Fashion Accessiories", R.mipmap.fashion_acc));
        fashion.add(new ChildCategoryList("JewelLery", R.mipmap.jewellery));
        fashion.add(new ChildCategoryList("Eye Wear", R.mipmap.eyewear));
    }

    public void setMen() {

        men.add(new ChildCategoryList("Footwear", R.mipmap.men_foot));

    }

    private void setWomen() {

        women.add(new ChildCategoryList("Footwear", R.mipmap.women_foot));
    }

    public void setBags() {


        bags.add(new ChildCategoryList("Footwear", R.mipmap.men_foot));
        bags.add(new ChildCategoryList("Bags", R.mipmap.bags));
        bags.add(new ChildCategoryList("School Stationery", R.mipmap.stationery));

    }

    public void setMobile() {

        mobile.add(new ChildCategoryList("Mobile & Accessiories", R.mipmap.mobile));

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
                startActivity(new Intent(Childcategoru.this, MyCart.class));
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });
        txtViewCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Childcategoru.this, MyCart.class));
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.my_cart:
                startActivity(new Intent(Childcategoru.this, MyCart.class));
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                break;
            case R.id.search_item:
                startActivity(new Intent(this, SearchActivity.class));
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
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
        final ShowCategoryAdapeter showCategoryAdapeter = new ShowCategoryAdapeter(Childcategoru.this, arrayList, hashMap, listView);
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

                Intent intent=new Intent(Childcategoru.this,Childcategoru.class);
                intent.putExtra("get",hashMap.get(arrayList.get(groupPosition).getPARENTCATEGORY()).get(childPosition));
                intent.putExtra("getFilterName",String.valueOf(arrayList.get(groupPosition).getPARENTCATEGORY()));
                startActivity(intent);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i).getFLAG_INDICATOR() == 1) {
                        listView.collapseGroup(i);
                        arrayList.get(i).setFLAG_INDICATOR(0);
                    }

                }
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

        switch (v.getId()) {
            case R.id.viewmoreLaunch:
                for (int i = 6; i < SHOP_BY_PUBLISHER.size(); i++) {
                    mDummyList.add(SHOP_BY_PUBLISHER.get(i));
                    viewMoreLaunchText.setVisibility(View.GONE);
                }
                mnewLaunchAdapter.notifyDataSetChanged();
                break;
            case R.id.viewmorePublisher:
                for (int i = 6; i < SHOP_BY_PUBLISHER.size(); i++) {
                    mDummyList.add(SHOP_BY_PUBLISHER.get(i));
                    viewMorePublisherText.setVisibility(View.GONE);
                }
                mPublisherAdapter.notifyDataSetChanged();
                break;
            case R.id.viewmorePrice:
                for (int i = 6; i < SHOP_BY_PUBLISHER.size(); i++) {
                    mDummyList.add(SHOP_BY_PUBLISHER.get(i));
                    viewMorePriceText.setVisibility(View.GONE);
                }
                mPriceAdapter.notifyDataSetChanged();
                break;
            case R.id.viewmoreDiscount:
                for (int i = 6; i < SHOP_BY_PUBLISHER.size(); i++) {
                    mDummyList.add(SHOP_BY_PUBLISHER.get(i));
                    viewMoreDiscountText.setVisibility(View.GONE);
                }
                mDiscountAdapter.notifyDataSetChanged();
                break;
            case R.id.viewmorePopularCateg:
                Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show();
                for (int i = 6; i < SHOP_BY_PUBLISHER.size(); i++) {
                    mDummyList.add(SHOP_BY_PUBLISHER.get(i));
                    viewMorePopularCategText.setVisibility(View.GONE);
                }
                mPopularCategAdapter.notifyDataSetChanged();
                break;
        }
    }

    public String load(String url) {
        try {
            JSON_RESPONSE = new FetchingFromUrl().execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return JSON_RESPONSE;

    }


/*
    @Override
    public void onClickMore(int j) {

        Log.i("mAshish",String.valueOf(j));

        viewMoreLaunchAdapter.setWithFooter(false);

        for (int i=6;i<SHOP_BY_PUBLISHER.size();i++){
            mDummyList.add(SHOP_BY_PUBLISHER.get(i));
        }
        viewMoreLaunchAdapter.notifyDataSetChanged();

    }

*/
}
