package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nitin.desichain.Adapters.BrandStudioItemsAdapter;
import com.example.nitin.desichain.Adapters.SingleCartAdapter;
import com.example.nitin.desichain.Contents.CategoryList;
import com.example.nitin.desichain.Contents.ProductHorizontal;
import com.example.nitin.desichain.Internet.FetchingFromUrl;
import com.example.nitin.desichain.ParsingJson.BestSellingProduct;
import com.example.nitin.desichain.ParsingJson.ParticularPublisherDetail;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BrandProducts extends AppCompatActivity implements View.OnClickListener,SingleCartAdapter.ListChange {

    private static final String TAG = BrandProducts.class.getSimpleName();
    private RecyclerView mBrandRecyclerView;
    private List<ProductHorizontal> mList;
    private BrandStudioItemsAdapter mAdapter;
    private String mJsonResponse;
    DrawerLayout drawer;
    private Toolbar mToolbar;
    private TextView mEmptyText;
    View headerView;
    private int FLAG = 1;
    private ArrayList<CategoryList> mBrandProdList;
    private Bundle bundle;
    private String JSON_RESPONSE;
    private Helper listView;
    NestedScrollView nestedScrollView;
    public static ArrayList<String> Poojaitem;
    public static ArrayList<CategoryHolder> arrayList;
    public static ArrayList<String> Books;
    public static ArrayList<String> Homecare;
    public static ArrayList<String> others;
    public static HashMap<String, ArrayList<String>> hashMap;
    LinearLayout myorder, mycart, myaccount, helpcenter, ratedesichain, productPage, policy, facebook, google, twitter, pinterest, youtube, instagram, aboutus;
    ImageView brandimage;
    TextView brandname, branddescription;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_products);
        mBrandRecyclerView = (RecyclerView) findViewById(R.id.brandRecyclerView);

        mToolbar = (Toolbar) findViewById(R.id.myToolBar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Brand Name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent intent = getIntent();
        int prodId = intent.getIntExtra("PRODUCTID",0);

        mEmptyText=(TextView)findViewById(R.id.emptyViewText);

        brandimage = (ImageView) findViewById(R.id.brand_image);
        brandname = (TextView) findViewById(R.id.brand_name);
        branddescription = (TextView) findViewById(R.id.brand_description);

//        Log.i(TAG,bundle.getString(AllConstants.Brandname));
//

        mBrandProdList = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        String imageUrl = extras.getString("bundleImageUrl");
        String prodName = extras.getString("bundleProdName");
        String prodDesc = extras.getString("bundleProdDesc");
        int sno = extras.getInt("bundleBrandSno");



        if (intent.getIntExtra(AllConstants.FLAG, 0) == AllConstants.CALLFROMSHOPBYPUBLISHERACTIVITY) {
            JSON_RESPONSE = load("http://dc.desichain.in/DesiChainWeService.asmx/PublisherDetail?ProId=" + String.valueOf(intent.getIntExtra("PRODUCTID", 0)));
           String url = "http://dc.desichain.in/DesiChainWeService.asmx/PublisherProductDetail?CatId=";
            loadProducts(url,prodId);
            bundle = new ParticularPublisherDetail(JSON_RESPONSE, BrandProducts.this).parseParticularPublisher();
            Picasso.with(BrandProducts.this).load("http://www.desichain.in/uploads/" + bundle.get(AllConstants.Brandimageurl)).into(brandimage);
            brandname.setText(bundle.getString(AllConstants.Brandname));
            branddescription.setText(bundle.getString(AllConstants.Branddescription));

        } else if (intent.getIntExtra(AllConstants.FLAG,0)==AllConstants.CALLFROMBRANDPRODUCTMAINACTIVITY){
            String url = "http://dc.desichain.in/DesiChainWeService.asmx/BrandProductDetail?catid=";
            loadProducts(url,sno);
            Picasso.with(BrandProducts.this).load("http://www.desichain.in/uploads/" + getIntent().getStringExtra("bundleImageUrl")).into(brandimage);
            brandname.setText(prodName);
            branddescription.setText(prodDesc);

        }


        if (mBrandProdList.size() != 0) {
            mAdapter = new BrandStudioItemsAdapter(mBrandProdList, this);

            mEmptyText.setVisibility(View.GONE);
            GridLayoutManager manager = new GridLayoutManager(this, 2);
            mBrandRecyclerView.setLayoutManager(manager);
            mBrandRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mBrandRecyclerView.setNestedScrollingEnabled(false);
            mBrandRecyclerView.setFocusable(false);
            mBrandRecyclerView.setAdapter(mAdapter);
        } else {
            mBrandRecyclerView.setVisibility(View.GONE);
            mEmptyText.setVisibility(View.VISIBLE);
        }

//        if (!imageUrl.isEmpty() && !prodName.isEmpty() && !prodDesc.isEmpty()) {
//            Picasso.with(BrandProducts.this).load("http://www.desichain.in/uploads/" + getIntent().getStringExtra("bundleImageUrl")).into(brandimage);
//            brandname.setText(prodName);
//            branddescription.setText(prodDesc);
//        }
//        } else {
//            Picasso.with(BrandProducts.this).load("http://www.desichain.in/uploads/" + bundle.get(AllConstants.Brandimageurl)).into(brandimage);
//            brandname.setText(bundle.getString(AllConstants.Brandname));
//            branddescription.setText(bundle.getString(AllConstants.Branddescription));
//        }



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

    public void loadProducts(String url,int sno) {
        if (!(Utility.isNetworkAvailable(this))) {

            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        } else {
            try {
                JSON_RESPONSE = new FetchingFromUrl().execute(url+sno).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            if (JSON_RESPONSE != null) {
                mBrandProdList = new BestSellingProduct(JSON_RESPONSE, BrandProducts.this).parseBestSellingProduct();
            }
        }
    }

    private void add() {
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

    private void navigationCategoryList() {

        final ShowCategoryAdapeter showCategoryAdapeter=new ShowCategoryAdapeter(BrandProducts.this,arrayList,hashMap,listView);
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
                Intent intent=new Intent(BrandProducts.this,Childcategoru.class);
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

    private void initiaze() {
        arrayList=new ArrayList<>();
        hashMap=new HashMap<>();
        Books=new ArrayList<>();
        Poojaitem=new ArrayList<>();
        Homecare=new ArrayList<>();
        others=new ArrayList<>();


    }

    private void refferencetonavigationcategory(View view) {
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


    }

   /* private void prepareItems() {

        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));

        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));

        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));

        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));
        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));

        mList.add(new ProductHorizontal("MICROMAX SPARK VDEO(8GB) 4G VOLTE","Rs. 50000",R.mipmap.ic_launcher, "4.0","12"));


    }*/

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

    public String load(String url)
    {
        try {
            JSON_RESPONSE=new FetchingFromUrl().execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return JSON_RESPONSE;

    }
}
