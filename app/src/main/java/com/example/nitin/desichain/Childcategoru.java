package com.example.nitin.desichain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.nitin.desichain.Adapters.ChildCategoryAdapter;
import com.example.nitin.desichain.Contents.ChildCategoryList;
import com.example.nitin.desichain.SubCategoryList.ShowCategoryAdapeter;
import com.example.nitin.desichain.Utility.Utility;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.nitin.desichain.MainActivity.*;
import static com.example.nitin.desichain.MainActivity.arrayList;



public class Childcategoru extends AppCompatActivity implements View.OnClickListener {

    ArrayList<ChildCategoryList> homedecor;
    ArrayList<ChildCategoryList> homefurnishing;
    ArrayList<ChildCategoryList> kitchenndinning;
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
    View headerView;
    DrawerLayout drawer;
    NestedScrollView nestedScrollView;
    public static ArrayList<String> Poojaitem;
    public static  ArrayList<String> Books;
    public static ArrayList<String> Homecare;
    public static   ArrayList<String> others;
    public  static HashMap<String,ArrayList<String>> hashMap;
    LinearLayout myorder,mycart,myaccount,helpcenter,ratedesichain,productPage,policy,facebook,google,twitter,pinterest,youtube,instagram,aboutus;

    GridView gridView;
    ChildCategoryAdapter childCategoryAdapter;





    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childcategoru);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inti();
        gridView= (GridView) findViewById(R.id.singlechildlistview);
        Intent intent = getIntent();
        String choice = intent.getStringExtra("get");
         if(MainActivity.hashMap.get(arrayList.get(0).getPARENTCATEGORY()).get(0).equals(choice)){
             setBhagavad();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,bhagavad);
             gridView.setAdapter(childCategoryAdapter);


         }
        else if(MainActivity.hashMap.get(arrayList.get(0).getPARENTCATEGORY()).get(1).equals(choice))
         {

                setPaperback();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,paperback);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(MainActivity.hashMap.get(arrayList.get(0).getPARENTCATEGORY()).get(2).equals(choice)){

             setMedia();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,media);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(MainActivity.hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(0).equals(choice)){

             setItemsofworship();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,itemsofworship);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(MainActivity.hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(1).equals(choice)){
             setOtheressentials();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,otheressentials);
             gridView.setAdapter(childCategoryAdapter);

         }
        else if(MainActivity.hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(2).equals(choice)){
             setBells();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,bells);
             gridView.setAdapter(childCategoryAdapter);

         }
        else if(MainActivity.hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(3).equals(choice)){

             setAgarbatti();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,agarbatti);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(MainActivity.hashMap.get(arrayList.get(1).getPARENTCATEGORY()).get(4).equals(choice)){

             setMurtis();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,murtis);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(MainActivity.hashMap.get(arrayList.get(2).getPARENTCATEGORY()).get(0).equals(choice)){

             setHomedecor();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,homedecor);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(MainActivity.hashMap.get(arrayList.get(2).getPARENTCATEGORY()).get(1).equals(choice)){

             setHomefurnishing();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,homefurnishing);
             gridView.setAdapter(childCategoryAdapter);
         }
        else if(MainActivity.hashMap.get(arrayList.get(2).getPARENTCATEGORY()).get(2).equals(choice))
         {
             setKitchenndinning();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,kitchenndinning);
             gridView.setAdapter(childCategoryAdapter);

         }
         else if(MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(0).equals(choice)){

             setPersonalcare();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,personalcare);
             gridView.setAdapter(childCategoryAdapter);
         }
         else if(MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(1).equals(choice)){

             setHealthandfood();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,healthandfood);
             gridView.setAdapter(childCategoryAdapter);
         }
         else if(MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(2).equals(choice)){

             setFashion();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,fashion);
             gridView.setAdapter(childCategoryAdapter);
         }
         else if(MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(3).equals(choice)){

             setWomen();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,women);
             gridView.setAdapter(childCategoryAdapter);
         }
         else if(MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(4).equals(choice)){

             setMen();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,men);
             gridView.setAdapter(childCategoryAdapter);
         }
         else if(MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(5).equals(choice)){
             setBags();
             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,bags);
             gridView.setAdapter(childCategoryAdapter);

         }
         else if(MainActivity.hashMap.get(arrayList.get(3).getPARENTCATEGORY()).get(6).equals(choice))
         {
             setMobile();

             childCategoryAdapter=new ChildCategoryAdapter(Childcategoru.this,mobile);
             gridView.setAdapter(childCategoryAdapter);

           }
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
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
        nestedScrollView= (NestedScrollView) navigationView.findViewById(R.id.scrollposition);
        listView= (Helper) navigationView.findViewById(R.id.parentcategoryList);
        initiaze();
        add();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1=new Intent(Childcategoru.this,CategoryPage.class);
                startActivity(intent1);
            }
        });
    }

    public void inti(){
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
        homedecor.add(new ChildCategoryList("Showpieces & Decoratives", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Arts,Gift & Crafts", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Clocks", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Lamps & Lighting", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Paintings", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Wall Decals", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Photo Frames & Albums", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Candles & Fragrances", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Flowers,Plants & Vases", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Religion & Devotion", R.mipmap.ic_security_black_24dp));
        homedecor.add(new ChildCategoryList("Festive Decor", R.mipmap.ic_security_black_24dp));

    }

    public void setHomefurnishing() {


        homefurnishing.add(new ChildCategoryList("Bedsheets", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Curtains", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Cushion & Pillow Covers", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Blankets,Quilts & Dohars", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Towels", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Mats Carpets & Rugs", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Bath Linen", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Diwan Sets", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Bedding Sets", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Sofa Covers", R.mipmap.ic_security_black_24dp));
        homefurnishing.add(new ChildCategoryList("Tables", R.mipmap.ic_security_black_24dp));

    }

    public void setKitchenndinning() {

        kitchenndinning.add(new ChildCategoryList("Dinnerware", R.mipmap.ic_security_black_24dp));
        kitchenndinning.add(new ChildCategoryList("Cookware", R.mipmap.ic_security_black_24dp));
        kitchenndinning.add(new ChildCategoryList("Kitchen Tools & Cultery", R.mipmap.ic_security_black_24dp));
        kitchenndinning.add(new ChildCategoryList("Kitchen Care", R.mipmap.ic_security_black_24dp));
        kitchenndinning.add(new ChildCategoryList("Laundry Care", R.mipmap.ic_security_black_24dp));

    }

    public void setAgarbatti() {

        agarbatti.add(new ChildCategoryList("Incense Sticks", R.mipmap.ic_security_black_24dp));
        agarbatti.add(new ChildCategoryList("Natural Dhoops", R.mipmap.ic_security_black_24dp));
    }

    public void setBells() {

        bells.add(new ChildCategoryList("Brass", R.mipmap.ic_security_black_24dp));

    }

    public void setItemsofworship() {

        itemsofworship.add(new ChildCategoryList("Japa Mala & Bags", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList(" Mats/Assan", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Other Items", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Pooja Lamps", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Pooja Thali", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Pooja Vessels", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Sacrifices(Havan)Items", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Sindoor(Vermilion)", R.mipmap.ic_security_black_24dp));
        itemsofworship.add(new ChildCategoryList("Wicks(Batti", R.mipmap.ic_security_black_24dp));

    }

    public void setMurtis() {

        murtis.add(new ChildCategoryList("Brass", R.mipmap.ic_security_black_24dp));
        murtis.add(new ChildCategoryList("Mini Temples", R.mipmap.ic_security_black_24dp));

    }

    public void setOtheressentials() {

        otheressentials.add(new ChildCategoryList("Kanthi Mala/Neck Beads", R.mipmap.ic_security_black_24dp));
        otheressentials.add(new ChildCategoryList("Khadaun/Slippers", R.mipmap.ic_security_black_24dp));
        otheressentials.add(new ChildCategoryList("Scarf/Chadar", R.mipmap.ic_security_black_24dp));

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

        media.add(new ChildCategoryList("Animation Movies", R.mipmap.ic_security_black_24dp));
        media.add(new ChildCategoryList("Independent Cinema", R.mipmap.ic_security_black_24dp));
        media.add(new ChildCategoryList("kirtans/Bhajans", R.mipmap.ic_security_black_24dp));
        media.add(new ChildCategoryList("Lectures/Talks", R.mipmap.ic_security_black_24dp));

    }

    public void setPaperback() {

        paperback.add(new ChildCategoryList("Astrology", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Ayurveda & Health", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Biography", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Children", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Classic Text", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Cooking & Vegetariansim", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Cow Protection", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Magazines", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Personal Growth", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Philossophy", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Re-Incranation", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Religious/Spirtual", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Science", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Travel & Pilgrimage", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Vedic/Indian Culture", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Yoga and Meditation", R.mipmap.ic_security_black_24dp));
        paperback.add(new ChildCategoryList("Language Learning", R.mipmap.ic_security_black_24dp));
    }

    public void setPersonalcare() {



        personalcare.add(new ChildCategoryList("Baby Care", R.mipmap.ic_security_black_24dp));
        personalcare.add(new ChildCategoryList("Bath & Body", R.mipmap.ic_security_black_24dp));
        personalcare.add(new ChildCategoryList("Cosmetics/Skin Care", R.mipmap.ic_security_black_24dp));
        personalcare.add(new ChildCategoryList("Hair Cair", R.mipmap.ic_security_black_24dp));
        personalcare.add(new ChildCategoryList("Miscellaneous", R.mipmap.ic_security_black_24dp));
        personalcare.add(new ChildCategoryList("Oral Care", R.mipmap.ic_security_black_24dp));

    }

    public void setHealthandfood() {


        healthandfood.add(new ChildCategoryList("Rice/Flour/Cereal", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Spices(Masalas) & Herbs", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Snacks", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Herbal Tea/Coffee", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("DryFruits,Nuts,Seeds", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Food Suplements", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Cow Products", R.mipmap.ic_security_black_24dp));
        healthandfood.add(new ChildCategoryList("Miscellaneous", R.mipmap.ic_security_black_24dp));


    }

    public void setFashion() {


        fashion.add(new ChildCategoryList("Fashion Accessiories", R.mipmap.ic_security_black_24dp));
        fashion.add(new ChildCategoryList("JewelLery", R.mipmap.ic_security_black_24dp));
        fashion.add(new ChildCategoryList("Eye Wear", R.mipmap.ic_security_black_24dp));
    }

    public void setMen() {

        men.add(new ChildCategoryList("Footwear", R.mipmap.ic_security_black_24dp));

    }

    private void setWomen() {

        women.add(new ChildCategoryList("Footwear", R.mipmap.ic_security_black_24dp));
    }

    public void setBags() {


        bags.add(new ChildCategoryList("Footwear", R.mipmap.ic_security_black_24dp));
        bags.add(new ChildCategoryList("Bags", R.mipmap.ic_security_black_24dp));
        bags.add(new ChildCategoryList("School Stationery", R.mipmap.ic_security_black_24dp));

    }

    public void setMobile() {

        mobile.add(new ChildCategoryList("Mobile & Accessiories", R.mipmap.ic_security_black_24dp));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_cart_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.my_cart:
                startActivity(new Intent(Childcategoru.this,MyCart.class));
        }

        return true;

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
        final ShowCategoryAdapeter showCategoryAdapeter=new ShowCategoryAdapeter(Childcategoru.this,arrayList,hashMap,listView);
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
                Intent intent=new Intent(Childcategoru.this,Childcategoru.class);
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
